package com.truefmartin;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HTMLParser {
    private static String outFileDir;
    public static int LargestFileSize;
    private static TokenCounter tokenCounter;
    public static final int TERM_SIZE = 14;
    public static final int FREQ_SIZE = 6;
    public static void main(String[] args) {
        String inFileDir = args.length == 3 ? args[0]: "files";
        outFileDir = args.length == 3 ? args[1]: "outfiles";
        LargestFileSize = args.length == 3 ? Integer.parseInt(args[2]): 10000;
        tokenCounter = new TokenCounter();

        // Get max number of processors as possible
        int numThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        // Get a map of FileName to FileLength in bytes
        Map<String, Long> htmlFiles = getHTMLFilesFromDirectory(inFileDir);

        // Create a list of Callable tasks for parsing
        List<Callable<Void>> tasks = new LinkedList<>();

        for (Map.Entry<String, Long> fileEntry: htmlFiles.entrySet()) {
            tasks.add(() -> {
                parseHTMLFile(fileEntry.getKey(), fileEntry.getValue());
                return null;
            });
        }

        try {
            // Invoke tasks in parrallel, err parallell, pearal? parallel!
            executor.invokeAll(tasks);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
            if (IRParserEvaluator.isFailedFromHash())
                throw new RuntimeException("ERROR: Hash table to small. Rerun with a larger third arg input.");
            System.out.println("Number of total tokens in corpus: " + tokenCounter.getNumTokens());
            System.out.println("Number of unique terms per document summed: " + tokenCounter.getNumTokensUnique());

            // After sorted files are outputted, count the total number of unique words in the directory
            int uniqueWordsCount = countUniqueWords(outFileDir);
            System.out.println("Number of unique words for entire directory: " + uniqueWordsCount);
        }
    }

    private static void parseHTMLFile(String filePath, Long fileSize) {
        IRLexer lexer;
        try {
            lexer = new IRLexer(CharStreams.fromFileName(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        lexer.removeErrorListeners();
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        IRParser parser = new IRParser(tokens);
        parser.removeErrorListeners();
        // Create an instance of listener that handles exiting of rules
        IRParserBaseListener customListener = new IRParserEvaluator(filePath, outFileDir, fileSize, LargestFileSize, tokenCounter);

        parser.addParseListener(customListener);

        // Begin parsing
        IRParser.DocumentContext documentContext = parser.document();
    }

    private static Map<String, Long> getHTMLFilesFromDirectory(String directoryPath) {
        try (Stream<Path> stream = Files.list(Paths.get(directoryPath))) {
            return stream
                    .filter(file -> !Files.isDirectory(file))
                    .map(Path::toAbsolutePath)
                    .map(Path::toString)
                    .collect(Collectors.toMap(Function.identity(), file -> new File(file).length()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Count the number of unique words in an output directory, only reads first space separated column
    private static int countUniqueWords(String directoryPath) {
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

        return uniqueWords.size();
    }

    protected static class TokenCounter {

        private AtomicInteger globalNumTokensUnique;
        private AtomicInteger globalNumTokens;

        TokenCounter() {
            this.globalNumTokens = new AtomicInteger(0);
            this.globalNumTokensUnique = new AtomicInteger(0);
        }
        public void increaseNumTokens(int num) {
            this.globalNumTokens.getAndAdd(num);
        }
        public void increaseNumUniqueTokens(int num) {
            this.globalNumTokensUnique.getAndAdd(num);
        }

        public int getNumTokensUnique() {
            return this.globalNumTokensUnique.get();
        }

        public int getNumTokens() {
            return this.globalNumTokens.get();
        }
    }
}
