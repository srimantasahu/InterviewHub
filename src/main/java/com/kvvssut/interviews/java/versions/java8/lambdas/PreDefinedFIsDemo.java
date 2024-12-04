package com.kvvssut.interviews.java.versions.java8.lambdas;

import java.util.*;

public class PreDefinedFIsDemo {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<String>();
        strings.add("AAA");
        strings.add("bbb");
        strings.add("CCC");
        strings.add("ddd");
        strings.add("EEE");

        // 1. Sorting list of Strings in natural ordering of its elements
        System.out.println("Simple case-sensitive sort operation -");
        Collections.sort(strings);

        // 1. Printing values using default Collection's iterator
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // 2. Sorting list of Strings using custom comparator in a
        // case-insensitive manner
        System.out.println("\nCase-insensitive sort using custom comparator -");
        Comparator<String> comparator1 = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareToIgnoreCase(s2);
            }
        };

        Collections.sort(strings, comparator1);

        // 2. Printing values using foreach loop
        for (String string : strings) {
            System.out.println(string);
        }

        // 3. Sorting list of Strings using lambda expression in
        // descending order & case-insensitive manner
        System.out.println(
                "\nDescending order & case-insensitive sorting using Java 8 foreach method and lambda expression -");
        Comparator<String> comparator2 = (str1, str2) -> {
            return str2.compareToIgnoreCase(str1);
        };
        Collections.sort(strings, comparator2);

        // 3. Printing values using lambda expression and Java 8 foreach method
        strings.forEach(str -> System.out.println(str));

    }

}