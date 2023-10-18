package com.truefmartin.inverter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
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
    private ArrayList<SortedBuffer> sortedBuffers;



    public Inverter(int numTerms, Set<String> fileNames) {
        this.NUM_TERMS = numTerms;
        this.NUM_FILES = fileNames.size();
        this.DOC_ID_SIZE = 0;
        this.NUM_DOC_SIZE = 0;
        this.START_SIZE = 0;
        this.FILE_NAME_SIZE = 0;
        this.sortedBuffers = new ArrayList<>(this.NUM_FILES);
        int index = 0;
        for (String fileName: fileNames) {
            sortedBuffers.add(index, )
        }
        TERM_SIZE = 0;
    }

    private class FileEntry {
        String term;
        int freq;
        String fileName;

        public FileEntry() {
            this("");
        }
        public FileEntry(String fileName) {
            this.fileName = fileName;
            this.term = "";
            this.freq = -1;
        }

    }

    private class SortedBuffer {
        BufferedReader reader;
        FileEntry entry;

        public SortedBuffer(String filePath) {
            try {
                Path path = new File(filePath).toPath().resolve();
                InputStreamReader stream = new InputStreamReader(Files.newInputStream(path), StandardCharsets.UTF_8);
                this.entry = new FileEntry(String.valueOf(path.getFileName()));
                this.reader = new BufferedReader(stream, BUFFERED_READ_SIZE);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        public open(){

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
                    return new FileEntry();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
