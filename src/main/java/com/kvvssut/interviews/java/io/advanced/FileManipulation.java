package com.kvvssut.interviews.java.io.advanced;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManipulation {

    public static void main(String[] args) {
        Path path = Paths
                .get("D:\\Tech_Workspace\\Workspace_OldBooks\\JavaTuotrialWithJava8Examples\\src\\io\\advanced\\SampleMovedFile.txt");

        try {
            Files.deleteIfExists(path);
            System.out.println("Successfully deleted!!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            Files.createFile(path);
            System.out.println("Successfully created!!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            Files.move(path, Paths.get("D:\\Tech_Workspace\\Workspace_OldBooks\\JavaTuotrialWithJava8Examples\\src\\io\\advanced\\SampleMovedFile.txt"));
            System.out.println("Successfully moved!!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
