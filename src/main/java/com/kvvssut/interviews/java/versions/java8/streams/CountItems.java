package com.kvvssut.interviews.java.versions.java8.streams;

import java.util.ArrayList;
import java.util.List;

public class CountItems {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<String>();
        for (int i = 0; i < 1000000; i++) {
            strings.add("Item : " + i);
        }

        long start = System.currentTimeMillis();

        strings.stream().count();
        System.out.println("Total time taken to count using sequential stream is : " + (System.currentTimeMillis() - start) + " ms");

        start = System.currentTimeMillis();

        strings.parallelStream().count();
        System.out.println("\nTotal time taken to count using parallel stream is : " + (System.currentTimeMillis() - start) + " ms");

    }

}