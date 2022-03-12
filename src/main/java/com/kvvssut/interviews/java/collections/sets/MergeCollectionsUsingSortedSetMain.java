package com.kvvssut.interviews.java.collections.sets;

import com.kvvssut.interviews.java.collections.collectioninterface.CodingTask;
import com.kvvssut.interviews.java.collections.collectioninterface.PhoneTask;
import com.kvvssut.interviews.java.collections.collectioninterface.Task;

import java.util.*;

public class MergeCollectionsUsingSortedSetMain {

    /*
     * Merging two ordered lists, which was quite tricky using parallel
     * iterators (MergeCollections.java), is trivial if we get a SortedSet to do
     * the work; it requires just two lines of code. The simplicity comes at a
     * price, though; merging two sorted lists of size n is O(n), but adding n
     * elements to a TreeSet of size n is O(nlogn)
     */

    public static void main(String[] args) {
        PhoneTask mikePhone = new PhoneTask("Mike", "987 6543");
        PhoneTask paulPhone = new PhoneTask("Paul", "123 4567");

        CodingTask datatbaseCode = new CodingTask("db");
        CodingTask interfaceCode = new CodingTask("gui");
        CodingTask logicCode = new CodingTask("logic");

        Collection<Task> mondayTasks = new ArrayList<Task>();
        Collection<Task> tuesdayTasks = new ArrayList<Task>();

        Collections.addAll(mondayTasks, logicCode, mikePhone);
        Collections.addAll(tuesdayTasks, datatbaseCode, interfaceCode,
                paulPhone);

        Set<Task> naturallyOrderedTasks = new TreeSet<Task>(mondayTasks);
        naturallyOrderedTasks.addAll(tuesdayTasks);

        assert naturallyOrderedTasks.toString().equals(
                "[code db, code gui, code logic, phone Mike, phone Paul]");
        System.out.println(naturallyOrderedTasks);
    }

}
