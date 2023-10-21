package com.truefmartin.inverter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Inverter {
    private final int NUM_TERMS;
//------These are here in case I want to pass them in later iterations
    private final int TERM_SIZE;
    private final int NUM_DOC_SIZE;
    private final int START_SIZE;
    private final int DOC_ID_SIZE;
    private final int FILE_NAME_SIZE;
//---------------------------------------------------
    // Default buffer size:
    private int BUFFERED_READ_SIZE = 400;

    private LinkedList<SortedBuffer> sortedBuffers;

    public Inverter(int numTerms, final List<String> fileNames) {
        this.NUM_TERMS = numTerms;
        String bufferSizeEnv = System.getenv("BUFFER_SIZE");
        if (bufferSizeEnv != null && Integer.parseInt(bufferSizeEnv) > 0)
            BUFFERED_READ_SIZE = Integer.parseInt(bufferSizeEnv);
        this.sortedBuffers = new LinkedList<>();
        // ----Not used yet ----
        this.DOC_ID_SIZE = 0;
        this.NUM_DOC_SIZE = 0;
        this.START_SIZE = 0;
        this.FILE_NAME_SIZE = 0;
        this.TERM_SIZE = 0;
        // ---------------------
        // Write map file, can be in seperate thread, no shared, non-final resources
        new Thread(() -> {
            int index = 0;
            InvertedFileWriter mapFileWriter = new InvertedFileWriter(InvertedFileWriter.FileType.MAP);
            // Write map file
            for (String fileName: fileNames) {
                mapFileWriter.writeMapRecord(index++, Path.of(fileName).getFileName().toString());
            }
            mapFileWriter.closeAfterWriting();
        }).start();

        // Initialize the buffers
        int index = 0;
        for (String fileName: fileNames) {
            sortedBuffers.addLast(new SortedBuffer(fileName, index++));
        }
    }

    public void fillGlobalHash(List<String> uniquesSorted) {
        // Open the buffered readers in each buffer
        for(SortedBuffer buffer: sortedBuffers) {
            buffer.open();
        }
        GlobalHashTable globalHashTable = new GlobalHashTable(NUM_TERMS);
        // Get post ready to write
        InvertedFileWriter postWriter = new InvertedFileWriter(InvertedFileWriter.FileType.POST);
        FileEntry entry = new FileEntry();
        int start = 0;
        // For each unique term (use this instead of searching array to reduce time complexity at cost of memory)
        for(String term: uniquesSorted) {
            // Iterator for the linked list
            Iterator<SortedBuffer> itr = sortedBuffers.iterator();
            // This term has been found in 0 docs
            int numDocs = 0;

            while (itr.hasNext()){
                SortedBuffer buffer = itr.next();
                // If file finished, remove it from linked list so we don't continue to check it
                if(buffer.isClosed) {
                    itr.remove();
                    continue;
                }
                // Get current term held by SortedBuffer class (it has already been read from file)
                entry = buffer.getEntry();
                if (!term.equals(entry.term)) {
                    continue;
                }
                numDocs++;
                // Write a postings entry
                postWriter.writePostRecord(entry.docID, entry.freq);
                // Update the latest term in buffer, increment the buffer
                buffer.next();
            }
            globalHashTable.insert(term, numDocs, start);
            start += numDocs;
        }
        postWriter.closeAfterWriting();
        // Prepare to write dict file
        InvertedFileWriter dictWriter = new InvertedFileWriter(InvertedFileWriter.FileType.DICT);
        // Write contents of hash file to dict file
        globalHashTable.printToAny(dictWriter::writeDictRecord);

        dictWriter.closeAfterWriting();
    }

    // Holds the contents and information about each entry in the sorted temporary files
    private class FileEntry {
        String term;
        int freq;
        int docID;

        public FileEntry() {
            this(-1);
        }
        public FileEntry(int docID) {
            this.docID = docID;
            this.term = "";
            this.freq = -1;
        }


    }

    // Holds the buffered reader and the current entry. One SortedBuffer for each temporary sorted file
    private class SortedBuffer {
        BufferedReader reader;

        FileEntry entry;

        boolean isClosed = true;

        boolean termUsed = false;
        Path path;
        public SortedBuffer(String fileName, int docID) {
            this.path = Path.of(fileName);
            this.entry = new FileEntry(docID);
        }

        public void open(){
            InputStreamReader stream = null;
            try {
                stream = new InputStreamReader(Files.newInputStream(path), StandardCharsets.UTF_8);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            this.reader = new BufferedReader(stream, BUFFERED_READ_SIZE);
            this.isClosed = false;
            // Load first 'entry'
            next();
        }

        // Progress to next line
        public void next() {
            String line = null;
            try {
                line = reader.readLine();
                if (line != null) {
                    String[] splitLine = line.split(" ");
                    this.entry.term = splitLine[0];
                    this.entry.freq = Integer.parseInt(splitLine[1]);
                } else {
                    reader.close();
                    this.isClosed = true;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ArrayIndexOutOfBoundsException e) {
                // Handle odd errors, get the posting # so that the tokenizer can be modified to accommodate.
                throw new ArrayIndexOutOfBoundsException("Error in Next: " + line + " " +
                        "with " + this.entry.docID);
            }
        }
        public FileEntry getEntry() {
            return entry;
        }
    }
}
