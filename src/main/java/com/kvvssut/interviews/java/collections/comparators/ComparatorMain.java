package com.kvvssut.interviews.java.collections.comparators;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorMain {

    /*
     * interface Comparator<T> { int compare(T o1, T o2); }
     *
     * Comparator interface is basically used to specify additional orderings
     * (instead of natural ordering).
     *
     * The compare method returns a value that is negative, zero, or positive
     * depending upon whether the first object is less than, equal to, or
     * greater than the second object - just as with compareTo.
     */

    /*
     * Below is a comparator that considers the shorter of the two strings to be
     * smaller. If the two strings have the same length, they are compared using
     * the natural ordering.
     */
    static Comparator<String> sizeOrder = new Comparator<String>() {

        @Override
        public int compare(String str1, String str2) {
            return str1.length() < str2.length() ? -1 : str1.length() > str2
                    .length() ? 1 : str1.compareTo(str2);
        }
    };

    /*
     * In natural alphabetic ordering, "two" is greater than "three", whereas in
     * the size ordering it is smaller.
     */

    public static void main(String[] args) {
        assert "two".compareTo("three") > 0;
        System.out.println("two".compareTo("three") > 0);

        assert sizeOrder.compare("two", "three") < 0;
        System.out.println(sizeOrder.compare("two", "three") < 0);

        Collection<String> strings = Arrays.asList("from", "aaa", "to", "zzz");

        assert Collections.max(strings).equals("zzz");
        System.out.println(Collections.max(strings));

        assert Collections.min(strings).equals("aaa");
        System.out.println(Collections.min(strings));

        assert Collections.max(strings, sizeOrder).equals("from");
        System.out.println(Collections.max(strings, sizeOrder));

        assert Collections.min(strings, sizeOrder).equals("to");
        System.out.println(Collections.min(strings, sizeOrder));
    }

}
