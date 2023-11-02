package com.truefmartin.inverter;

import java.util.AbstractMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class PostWriterThread implements Runnable{
    private final ConcurrentLinkedQueue<AbstractMap.SimpleEntry<Integer, Integer>> queue;
    private final InvertedFileWriter postFileWriter;


    private boolean stop = false;

    public PostWriterThread(ConcurrentLinkedQueue<AbstractMap.SimpleEntry<Integer, Integer>> queue) {
        this.postFileWriter = new InvertedFileWriter(InvertedFileWriter.FileType.POST);
        this.queue = queue;
    }

    @Override
    public void run() {
        while (!stop) {
        AbstractMap.SimpleEntry<Integer, Integer> entry;
            if ((entry = queue.poll()) == null)
                continue;
            postFileWriter.writePostRecord(entry.getKey(), entry.getValue());
        }
        postFileWriter.closeAfterWriting();
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }
}
