package com.truefmartin;

import com.truefmartin.builder.InvertedFileBuilder;
import com.truefmartin.querier.FileNameRetriever;
import com.truefmartin.querier.Query;
import com.truefmartin.querier.accumulator.CompareType;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No arguments passed in. Pass in either 'query' or 'build' with their relevant args");
            return;
        }
        String[] relevantArgs = Arrays.copyOfRange(args, 1, args.length);
        if (args[0].equals("build")){
            var builder = new InvertedFileBuilder(relevantArgs);
            builder.begin();
        } else if (!args[0].equals("query")) {
            System.out.println("Invalid arguments. Pass in either 'query' or 'build' with their relevant args");
            return;
        }
        // Parse query command line arguments
        Query query = new Query(relevantArgs);
        if(!query.isValidArgs()) {
            System.out.println("Invalid query. Pass in the optional query arguments followed by the query");
            return;
        }
        // Get docID and weights of results
        CompareType[] sortedDocs = query.query();
        if(sortedDocs == null || sortedDocs.length == 0) {
            System.out.println("No results found, please try again.");
            return;
        }
        // Get filename and weights
        List<AbstractMap.SimpleEntry<String, Integer>> fileNames = FileNameRetriever.getFileNames(sortedDocs);
        if (fileNames == null || fileNames.isEmpty()) {
            System.out.println("Error getting file names.");
            return;
        }
        for (var fileName : fileNames) {
            System.out.println("Weight: " + fileName.getValue() + ",\t\t" + fileName.getKey());
        }
    }
}