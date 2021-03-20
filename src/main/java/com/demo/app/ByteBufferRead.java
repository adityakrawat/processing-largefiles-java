package com.demo.app;

import java.io.CharArrayReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.TimeUnit;

public class ByteBufferRead {

    public static void main(String... args) {
        long startTime = System.nanoTime();

        try {
            RandomAccessFile aFile = new RandomAccessFile("/Users/Shared/data.csv", "r");
            FileChannel inChannel = aFile.getChannel();
            MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
            StringBuffer line = new StringBuffer();

            for (int i = 0; i < buffer.limit(); i++) {
                char read = (char)buffer.get();
                if(read == '\n') {
                    //System.out.println(line);
                    line = new StringBuffer();
                }else {
                    line.append(read);
                }
            }

            buffer.clear();
            inChannel.close();
            aFile.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        long endTime = System.nanoTime();
        long elapsedTimeInMillis = TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS);
        System.out.println("Total elapsed time: " + elapsedTimeInMillis + " ms");
    }
}
