package com.kvvssut.interviews.java.versions.java21.sequencedcollections;

import java.util.ArrayList;
import java.util.SequencedCollection;

/*
The absence of a universal supertype for collections with a specified encounter order has caused recurring issues and complaints within Java’s collections framework.
Additionally, the lack of consistent methods for accessing the first and last elements, as well as iterating in reverse order, has been a persistent drawback.

This new feature introduces three new interfaces - SequencedCollection, SequencedSet, and SequencedMap, which are added to the existing hierarchy of collections.
 */
public class SequencedCollections {

    /*
            interface SequencedCollection<E> extends Collection<E> {
                // new method
                SequencedCollection<E> reversed();
                // methods promoted from Deque
                void addFirst(E);
                void addLast(E);
                E getFirst();
                E getLast();
                E removeFirst();
                E removeLast();
            }
     */

    public static void main(String[] args) {

        SequencedCollection<String> listOfStrings = new ArrayList<>();

        listOfStrings.add("second");
        System.out.println(listOfStrings);  // [second]

        listOfStrings.addLast("third");
        System.out.println(listOfStrings);  // [second, third]

        listOfStrings.addFirst("first");
        System.out.println(listOfStrings);  // [first, second, third]

        listOfStrings.removeLast();
        System.out.println(listOfStrings);  // [first, second]

        listOfStrings.removeFirst();
        System.out.println(listOfStrings);  // [second]

        listOfStrings.remove("second");
        System.out.println(listOfStrings);  // []
    }

}
