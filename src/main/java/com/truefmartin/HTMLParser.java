package com.truefmartin;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HTMLParser {
    private static String outFileDir;
    public static void main(String[] args) {
        String inFileDir = args.length == 2 ? args[0]: "C:\\Users\\truef\\OneDrive - University of Arkansas\\School\\InfoRet\\AntlrHW1\\target\\classes\\testfiles";
        outFileDir = args.length == 2 ? args[1]: "/outfiles";

        System.out.println(Paths.get(outFileDir).toAbsolutePath());
        System.out.println(Paths.get(inFileDir).toAbsolutePath());
        // Specify the number of threads you want to use
        int numThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        // List of HTML files to process

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
            // Invoke all tasks in parallel
            executor.invokeAll(tasks);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    private static void parseHTMLFile(String filePath, Long fileSize) {
        IRLexer lexer = null;
        int fileLength;
        try {
            lexer = new IRLexer(CharStreams.fromFileName(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        IRParser parser = new IRParser(tokens);

        // Create an instance of your custom listener
        IRParserBaseListener customListener = new IRParserEvaluator(filePath, outFileDir, fileSize);

        // Attach the custom listener to the parser
        parser.addParseListener(customListener);

        // Start the parsing process
        IRParser.DocumentContext documentContext = parser.document();
//         Process the parsed data as needed

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
        // Implement logic to retrieve a list of HTML files in the specified directory
        // You can use File.listFiles() or other file-handling libraries
    }
}
