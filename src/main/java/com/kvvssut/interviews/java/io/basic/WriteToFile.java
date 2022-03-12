package com.kvvssut.interviews.java.io.basic;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteToFile {

    public static void main(String[] args) {
        String filename = "D:\\Tech_Workspace\\Workspace_OldBooks\\JavaTuotrialWithJava8Examples\\src\\io\\basic\\Sample.txt";

        System.out.print("Before: \n");
        System.out.println(ReadFromFile.getTextFromFile(filename));

        writeToAFileUsingPrintWriter(filename,
                "I am \na \ngoooood \n\tboy.");

        System.out.println("\n\nAfter: ");
        System.out.println(ReadFromFile.getTextFromFile(filename));
    }

    static void writeToAFile(String filename, String text) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(filename, true));
            writer.write(text);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    static void writeToAFileUsingPrintWriter(String filename, String text) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileWriter(filename, true));
            writer.println(text); // This method behaves as though it invokes
            // print(String) and then println()
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

}
