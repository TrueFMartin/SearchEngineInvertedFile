package com.truefmartin.inverter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Inverter {
    private GlobalHashTable globalHash;
    private final int NUM_TERMS;
    private final int TERM_SIZE;
    private final int NUM_DOC_SIZE;
    private final int START_SIZE;
    private final int DOC_ID_SIZE;
    private final int FILE_NAME_SIZE;
    private final int NUM_FILES;

    private final int BUFFERED_READ_SIZE = 400;

    private int currentStart;
    private String currentWord;
    private LinkedList<SortedBuffer> sortedBuffers;

    private static String tempFileDir = "outfile/";

    public Inverter(int numTerms, Set<String> fileNames, String tempFileDir) {
        this.NUM_TERMS = numTerms;
        this.NUM_FILES = fileNames.size();
        Inverter.tempFileDir = tempFileDir;
        this.DOC_ID_SIZE = 0;
        this.NUM_DOC_SIZE = 0;
        this.START_SIZE = 0;
        this.FILE_NAME_SIZE = 0;
        this.sortedBuffers = new LinkedList<>();
        this.TERM_SIZE = 0;
        int index = 0;
        InvertedFileWriter mapFileWriter = new InvertedFileWriter(InvertedFileWriter.FileType.MAP);
        for (String fileName: fileNames) {
            mapFileWriter.writeMapRecord(index++, fileName);
        }
        mapFileWriter.closeAfterWriting();
        index = 0;
        for (String fileName: fileNames) {
            sortedBuffers.addLast(new SortedBuffer(fileName, index++));
        }
        fileNames = null;
    }

    public void fillGlobalHash(List<String> uniquesSorted) {
        GlobalHashTable globalHashTable = new GlobalHashTable(NUM_TERMS);
        InvertedFileWriter postWriter = new InvertedFileWriter(InvertedFileWriter.FileType.POST);
        FileEntry entry = new FileEntry();
        int start = 0;
        for(String term: uniquesSorted) {
            Iterator<SortedBuffer> itr = sortedBuffers.iterator();
            int numDocs = 0;

            while (itr.hasNext()){
                SortedBuffer buffer = itr.next();
                entry = buffer.getLine();
                if(buffer.isClosed) {
                    itr.remove();
                    continue;
                }
                if (!term.equals(entry.term)) {
                    continue;
                }
                numDocs++;
                postWriter.writePostRecord(entry.docID, entry.freq);
            }
            globalHashTable.insert(term, numDocs, start);
            start += numDocs;
        }
        globalHashTable.printSorted();
    }


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

    private class SortedBuffer {
        BufferedReader reader;
        FileEntry entry;

        boolean isClosed = true;

        Path path;

        public SortedBuffer(String filePath, int docID) {
            this.path = new File(filePath).toPath().resolve(Inverter.tempFileDir);
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
        }
        public FileEntry getLine() {
            try {
                String line = reader.readLine();
                if (line != null) {
                    String[] splitLine = line.split(" ");
                    this.entry.term = splitLine[0];
                    this.entry.freq = Integer.parseInt(splitLine[1]);
                    return entry;
                } else {
                    reader.close();
                    this.isClosed = true;
                    return new FileEntry();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
