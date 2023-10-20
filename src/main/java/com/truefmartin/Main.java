package com.truefmartin;

import com.truefmartin.inverter.Inverter;
import com.truefmartin.parser.HTMLParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String inFileDir = args.length >= 1 ? args[0] : "files";
        String outFileDir = args.length >= 2 ? args[1] : "outfiles";
        // Size in bytes of file with most unique words
        int largestFileSize = args.length >= 3 ? Integer.parseInt(args[2]) : 39564;
        // Number of unique words in that file
        int largestFileNumUnique = args.length >= 4 ? Integer.parseInt(args[2]) : 5795;

        HTMLParser htmlParser = new HTMLParser(inFileDir, outFileDir, largestFileSize, largestFileNumUnique);
        Set<String> fileNames = htmlParser.begin();
        // After sorted files are outputted, count the total number of unique words in the directory
        Set<String> uniqueWords = countUniqueWords(outFileDir);
        System.out.println("Number of unique words for entire directory: " + uniqueWords.size());
        Inverter inverter = new Inverter(uniqueWords.size(), fileNames, outFileDir + "/");
        fileNames = null;
        List<String> uniqueWordsSorted = uniqueWords.stream().sorted().collect(Collectors.toList());
        uniqueWords = null;
        inverter.fillGlobalHash(uniqueWordsSorted);
        uniqueWordsSorted = null;



    }
    // Count the number of unique words in the output directory, only reads first space separated column
    private static Set<String> countUniqueWords(String directoryPath) {
        Set<String> uniqueWords = new HashSet<>();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            String[] columns = line.split("\\s+");
                            if (columns.length > 0) {
                                uniqueWords.add(columns[0]);
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return uniqueWords;
    }
}