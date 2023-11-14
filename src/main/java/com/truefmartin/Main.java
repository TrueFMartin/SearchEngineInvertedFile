package com.truefmartin;

import com.truefmartin.builder.InvertedFileBuilder;
import com.truefmartin.querier.FileNameRetriever;
import com.truefmartin.querier.Query;
import com.truefmartin.querier.accumulator.CompareType;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        if (args.length > 0) {
            String[] relevantArgs = Arrays.copyOfRange(args, 1, args.length);
            if (args[0].equals("build")){
                var builder = new InvertedFileBuilder(relevantArgs);
                builder.begin();
            } else if (args[0].equals("query")) {
                // Parse query command line arguments
                Query query = new Query(relevantArgs);
                // Get docID and weights of results
                CompareType[] sortedDocs = query.query();
                // Get filename and weights
                List<AbstractMap.SimpleEntry<String, Integer>> fileNames = FileNameRetriever.getFileNames(sortedDocs);
                if (fileNames != null) {
                    for(var fileName: fileNames) {
                        System.out.println("Weight: " + fileName.getValue() + ",\t\t" + fileName.getKey());
                    }
                } else {
                    System.out.println("No results found, please try again.");
                }
            } else throw new RuntimeException("Invalid arguments. Pass in either 'query' or 'build' with their relevant args");
        }
    }
}