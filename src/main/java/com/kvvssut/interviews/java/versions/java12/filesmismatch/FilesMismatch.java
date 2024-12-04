package com.kvvssut.interviews.java.versions.java12.filesmismatch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/*
Files.mismatch method is part of the java.nio.file package in Java, and it is used to compare the content of two files for differences.
It’s specifically designed to efficiently determine whether two files have differing content without needing to read the entire contents of the files.
 */
public class FilesMismatch {

    public static void main(String[] args) throws IOException {
        Path filePath1 = Files.createTempFile("file1", ".txt");
        Path filePath2 = Files.createTempFile("file2", ".txt");
        Files.writeString(filePath1, "I love Java");
        Files.writeString(filePath2, "I love Technology");

        long mismatch = Files.mismatch(filePath1, filePath2); // It returns 7
        System.out.println("Mismatch index: " + mismatch);
    }

}
