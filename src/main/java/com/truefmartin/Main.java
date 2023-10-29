package com.truefmartin;

import com.truefmartin.inverter.Inverter;
import com.truefmartin.parser.HTMLParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;
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
        List<String> fileNames = new ArrayList<>(htmlParser.begin());
        fileNames.replaceAll(s -> s.replace(inFileDir, outFileDir));
        // After sorted files are outputted, count the total number of unique words in the directory
        HashMap<String, Integer> uniqueWords = countUniqueWords(outFileDir);
        String debugEnv = System.getenv("DEBUG");
        if ((debugEnv != null && debugEnv.equals("true"))) {
            System.out.println("Number of unique words for entire directory: " + uniqueWords.size());
        }
        // Prepare for the inverter
        Inverter inverter = new Inverter(uniqueWords.size(), fileNames );
        // I'm not sure if this helps or not, but maybe garbage collector can start working a little sooner.
        fileNames = null;
        List<AbstractMap.SimpleEntry<String, Integer>> uniqueWordsSorted = uniqueWords.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())  // Sort by token
                .map(AbstractMap.SimpleEntry::new) // Java doesn't have a Pair<T,K> class
                .collect(Collectors.toList());
        uniqueWords = null;
        inverter.fillGlobalHash(uniqueWordsSorted);
        uniqueWordsSorted = null;

    }
    // Count the number of unique words in the output directory, only reads first space separated column
    private static HashMap<String, Integer> countUniqueWords(String directoryPath) {
        HashMap<String, Integer> uniqueWords = new HashMap<>();

        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        int numThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        // Get a map of FileName to FileLength in bytes. FileLength is not used this time
        Map<String, Long> files = HTMLParser.getHTMLFilesFromDirectory(directoryPath);

        // Create a list of Callable tasks for parsing
        List<Callable<Void>> tasks = new LinkedList<>();
        for (String file: files.keySet()) {
            tasks.add(() -> {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] columns = line.split("\\s+");
                        if (columns.length > 0) {
                            queue.put(columns[0]);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            });
        }

        Thread consumer = null;
        try {
            consumer = new Thread(() -> {
                while(!queue.isEmpty()) {
                    try {
                        uniqueWords.merge(queue.take(), 1, Integer::sum);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
            executor.invokeAll(tasks);
            consumer.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
            try {
                Objects.requireNonNull(consumer).join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return uniqueWords;
    }
}