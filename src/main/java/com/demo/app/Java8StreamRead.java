package com.demo.app;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class Java8StreamRead {

    public static void main(String... args) {

        long startTime = System.nanoTime();

        Path file = Paths.get("/Users/Shared/data.csv");

        try(Stream<String> lines = Files.lines(file, StandardCharsets.ISO_8859_1)){
            lines.forEach((line) -> {/*System.out.println(line)*/});
        }catch(IOException e) {
            e.printStackTrace();
        }

        long endTime = System.nanoTime();
        long elapsedTimeInMillis = TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS);
        System.out.println("Total elapsed time: " + elapsedTimeInMillis + " ms");
    }
}



