package com.truefmartin.parser;

import com.truefmartin.IRLexer;
import com.truefmartin.IRParser;
import com.truefmartin.IRParserBaseListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.File;
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
    private String outFileDir;
    private final int largestFileNumUnique;
    private final String inFileDir;
    public int largestFileSize;
    private SynchronizedCounter synchronizedCounter;
    private int docHtSizeOverride = -1;

    private final boolean debug;
    //---------- NOT USED YET ---------------
    public static final int TERM_SIZE = 14;
    public static final int FREQ_SIZE = 6;
    //--------------------------------------


    public HTMLParser(String inFileDir, String outFileDir, int largestFileSize, int largestFileNumUnique) {
        this.inFileDir = inFileDir;
        this.largestFileSize = largestFileSize;
        this.outFileDir = outFileDir;
        this.largestFileNumUnique = largestFileNumUnique;
        this.synchronizedCounter = new SynchronizedCounter();
        String docHashOverride = System.getenv("DHT_SIZE");
        if(docHashOverride != null && !docHashOverride.isEmpty()) {
            docHtSizeOverride = Integer.parseInt(docHashOverride);
        }
        String debugEnv = System.getenv("DEBUG");
        debug = (debugEnv != null && debugEnv.equals("true"));
    }

    public Set<String> begin() {
        // Get max number of processors as possible
        int numThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        // Get a map of FileName to FileLength in bytes
        Map<String, Long> htmlFiles = getHTMLFilesFromDirectory(this.inFileDir);

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
            if (this.debug) {
                System.out.println("Number of total tokens in corpus: " + synchronizedCounter.getNumTokens());
                System.out.println("Number of unique terms per document summed: " + synchronizedCounter.getNumTokensUnique());
            }

            return htmlFiles.keySet();
        }
    }

    private void parseHTMLFile(String filePath, Long fileSize) {
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

        /*
         Calculate an estimated number of unique terms in this file.
         Compare this file size to the file size of the file with the highest
         number of unique words, and take that % of the number of unique terms
         in that largest file.
         Increase that by 1.25 for safety and add 10 for very small files.
        */
        int docHashTableSize;
        if (docHtSizeOverride == -1) {
            docHashTableSize = (int) (((fileSize * 1.0 / largestFileSize ) * largestFileNumUnique) * 1.25 + 10);
        } else {
            // User passed in an override
            docHashTableSize = docHtSizeOverride;
        }
        if (debug) {
            System.out.println("H-table size: "  + docHashTableSize + "\tfor: " + filePath);
        }
        // Create an instance of listener that handles exiting of rules
        IRParserBaseListener customListener = new IRParserEvaluator(
                filePath, outFileDir, docHashTableSize, synchronizedCounter);

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



    protected static class SynchronizedCounter {

        private AtomicInteger globalNumTokensUnique;
        private AtomicInteger globalNumTokens;

        SynchronizedCounter() {
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
