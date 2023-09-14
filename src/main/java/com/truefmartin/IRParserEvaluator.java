package com.truefmartin;


import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.regex.Pattern;

public class IRParserEvaluator extends IRParserBaseListener{
    private String outputFileName;
    private StringBuilder outputBuilder;

    // UNUSED! but here for future use
    private static final Pattern PUNCTUATION =
            Pattern.compile("[,-_./=:;<>?@\\[\\]{|}~!\"#$^`%&'()*+]");
    private static final Pattern CONTENT_START =
            Pattern.compile("[a-z]+?=\"\\{?");


    public IRParserEvaluator(String inputFileName, String outFileDir, long initBufferSize) {
        // Get inputFileName to be in form of "/fileName"
        if (inputFileName.lastIndexOf('/') == -1) {
            inputFileName = '/' + inputFileName;
        } else if (inputFileName.lastIndexOf('/') > 0) {
            inputFileName = inputFileName.substring(inputFileName.lastIndexOf('/'));
        }

        if(outFileDir.endsWith("/"))
            outFileDir =  outFileDir.substring(0, outFileDir.length()-1);
        // End with an output of the form "outfile/someFile.html"
        this.outputFileName = outFileDir + inputFileName;
        outputBuilder = new StringBuilder((int) initBufferSize);
    }

    // Called by every listener that has content to output,
    // Adds a new line and sets to lower case
    private void print(String s) {
        outputBuilder.append(s.toLowerCase()).append("\n");
    }

    // Remove ' content=" ' or ' alt=" ' from s
    private String contentStartRemove(String s) {
        return CONTENT_START.matcher(s).replaceFirst("");
    }

    // Remove ' " ' from ' someString" '
    private String contentEndRemove(String s) {
        try {
            return s.substring(0, s.lastIndexOf('"'));
        } catch (IndexOutOfBoundsException e) {
            return s;
        }
    }

    // UNUSED! but here for future use
    public static String removePunctuation(String s) {
        return PUNCTUATION.matcher(s).replaceAll("");
    }

    private void write() throws FileNotFoundException {
//        System.out.println("Writing to " + Path.of(outputFileDirectory + "/" + outputFileName).toAbsolutePath());
        byte[] buffer = outputBuilder.toString().getBytes();
        try {
            FileChannel rwChannel = new RandomAccessFile(outputFileName, "rw").getChannel();
            ByteBuffer wrBuf = rwChannel.map(FileChannel.MapMode.READ_WRITE, 0, buffer.length);
            wrBuf.put(buffer);
            rwChannel.close();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    // At end of document, write everything to output file
    @Override
    public void exitDocument(IRParser.DocumentContext ctx) {
        System.out.println("Exiting Document");
        try {
            this.write();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // Clean text that needs no modification
    @Override
    public void exitOutOfTagClean(IRParser.OutOfTagCleanContext ctx) {
        print(ctx.getText());
    }

    // The text that is in the content part of: <IMG content="XXX somethingElse", or <IMG alt="XXX somethingElse"
    // Clean up the XXX
    @Override
    public void exitContentText(IRParser.ContentTextContext ctx) {
        if (ctx.IN_TAG_URL() != null) {
            print(contentEndRemove(contentStartRemove(ctx.IN_TAG_URL().toString())));
            // If it's a URL, it won't have a 'CONTENT_START' and 'CONTENT_END'
        } else {
            print(contentStartRemove(ctx.CONTENT_START().toString()));
        }
    }

    // Print the rest of content="somethingElse XXX"
    @Override
    public void exitContentOptions(IRParser.ContentOptionsContext ctx) {
        if (ctx.CONTENT_TEXT() != null) {
            print(ctx.CONTENT_TEXT().toString());
        }
        if (ctx.CONTENT_EMAIL() != null) {
            print(ctx.CONTENT_EMAIL().toString());
        }
    }

    // Remove commas from integers
    @Override
    public void exitHandleInteger(IRParser.HandleIntegerContext ctx) {
        print(ctx.getText().replace(",", ""));
    }
}
