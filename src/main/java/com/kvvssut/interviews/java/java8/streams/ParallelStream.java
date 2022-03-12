package com.kvvssut.interviews.java.java8.streams;

import java.util.ArrayList;
import java.util.List;

public class ParallelStream {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            strings.add("Item : " + i);
        }

        System.out.println("Printing using sequential streams -");
        strings.stream().forEach(str -> System.out.println(str));

        System.out.println("\n\nPrinting using parallel streams -");
        strings.parallelStream().forEach(str -> System.out.println(str));
    }

}