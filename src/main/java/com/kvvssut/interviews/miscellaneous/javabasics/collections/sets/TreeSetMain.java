package com.kvvssut.interviews.miscellaneous.javabasics.collections.sets;

import java.util.TreeSet;

class CustomString implements Comparable<CustomString> {
    String value;

    CustomString(String value) {
        this.value = value;
    }

    @Override
    public int compareTo(CustomString o) {
        return -1;  // Sorts elements in reverse insertion order!
    }

    @Override
    public String toString() {
        return value;
    }
}

public class TreeSetMain {

    public static void main(String[] args) {
        TreeSet<CustomString> set = new TreeSet<>();
        set.add(new CustomString("Banana"));
        set.add(new CustomString("Apple"));
        set.add(new CustomString("Mango"));

        System.out.println(set); // [Mango, Apple, Banana]
    }

}
