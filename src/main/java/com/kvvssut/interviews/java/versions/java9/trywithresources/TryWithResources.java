package com.kvvssut.interviews.java.versions.java9.trywithresources;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
The try-with-resources statement is used in Java to automatically close resources that are used within a try block.
It simplifies resource management by ensuring that resources are closed properly, even in the presence of exceptions.
Resources that can be used with try-with-resources must implement the AutoCloseable or java.io.Closeable interface.
 */

public class TryWithResources {

    public static void main(String[] args) throws FileNotFoundException {

        // Before Java 9:
        try (Scanner scanner = new Scanner(new File("testRead.txt"));
             PrintWriter writer = new PrintWriter(new File("testWrite.txt"))) {
            // ...
        }

        // Java 9 and After: The try-with-resources statement was enhanced to handle final variables declared in the try block.
        final Scanner scanner = new Scanner(new File("testRead.txt"));
        final PrintWriter writer = new PrintWriter(new File("testWrite.txt"));
        try (scanner; writer) {
            // ...
        }
    }

}
