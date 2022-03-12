package com.kvvssut.interviews.java.collections.sets;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetMain {

    /*
     * This class inherits from HashSet, still implementing Set and refining the
     * contract of its superclass in only one respect: it guarantees that its
     * iterators will return their elements in the order in which they were
     * first added. It does this by maintaining a linked list of the set
     * elements.
     */

    public static void main(String[] args) {
        Set<Character> linkedHashSet = new LinkedHashSet<Character>();
        Collections.addAll(linkedHashSet, 'a', 'b', 'j');

        assert linkedHashSet.toString().equals("[a, b, j]");
        System.out.println(linkedHashSet);
    }

    /*
     * The linked structure has a useful consequence in terms of improved
     * performance for iteration: next performs in constant time, as the linked
     * list can be used to visit each element in turn. This is in contrast to
     * HashSet, for which every bucket in the hash table must be visited whether
     * it is occupied or not, but the overhead involved in maintaining the
     * linked list means that you would choose LinkedHashSet in preference to
     * HashSet only if the order or the efficiency of iteration were important
     * for your application.
     */

    /*
     * The constructor for LinkedHashSet provide the same facilities as those of
     * HashSet for configuring the underlying hash table. Like HashSet, it is
     * unsynchronized and not thread-safe; its iterators are fail fast.
     */
}
