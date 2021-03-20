package com.demo.app;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ApachecommonsIORead {

    public static void main(String... args) {

        long startTime = System.nanoTime();

        try {
            LineIterator it = FileUtils.lineIterator(new File("/Users/Shared/data.csv"), "UTF-8");
            try {
                while (it.hasNext()) {
                    String line = it.nextLine();
                    // do something with line
                }
            } finally {
                LineIterator.closeQuietly(it);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        long endTime = System.nanoTime();
        long elapsedTimeInMillis = TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS);
        System.out.println("Total elapsed time: " + elapsedTimeInMillis + " ms");
    }
}
