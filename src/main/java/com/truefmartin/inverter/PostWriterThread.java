package com.truefmartin.inverter;

import java.util.AbstractMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class PostWriterThread implements Runnable{
    private final ConcurrentLinkedQueue<AbstractMap.SimpleEntry<Integer, Integer>> queue;

    private boolean stop = false;

    public PostWriterThread(ConcurrentLinkedQueue<AbstractMap.SimpleEntry<Integer, Integer>> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try (var postFileWriter = new InvertedFileWriter(InvertedFileWriter.FileType.POST)) {
            while (!stop) {
                AbstractMap.SimpleEntry<Integer, Integer> entry;
                if ((entry = queue.poll()) == null)
                    continue;
                postFileWriter.writePostRecord(entry.getKey(), entry.getValue());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }
}
