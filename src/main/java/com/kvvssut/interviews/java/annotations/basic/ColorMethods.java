package com.kvvssut.interviews.java.annotations.basic;

public class ColorMethods {

    private static String[] colors = {"Red", "Blue", "Green", "Yellow"};

    @Deprecated
    public static void printAllColors() { // usage of deprecated methods in the
        // same class don't give warning, so
        // we separated it into two classes
        for (String color : colors) {
            System.out.println(color);
        }
    }

    public static void printColor(int i) {
        if (i < colors.length && i >= 0) {
            System.out.println(colors[i]);
        } else {
            System.out.println("Index out of bound : " + i);
        }
    }

    @SuppressWarnings("unused")
    // annotation to suppress unused method warning
    private void printColorNotUsed() { // Warning - The method
        // printColorNotUsed() from the type
        // ColorMethods is never used locally
        // method not used anywhere
    }
}
