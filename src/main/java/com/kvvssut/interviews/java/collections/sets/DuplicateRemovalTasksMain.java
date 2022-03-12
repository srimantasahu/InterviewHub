package com.kvvssut.interviews.java.collections.sets;

import com.kvvssut.interviews.java.collections.collectioninterface.CodingTask;
import com.kvvssut.interviews.java.collections.collectioninterface.PhoneTask;
import com.kvvssut.interviews.java.collections.collectioninterface.Task;

import java.util.*;

public class DuplicateRemovalTasksMain {

    /*
     * Since the empty string precedes all others in the natural ordering on
     * strings, the empty task comes before all others in the natural ordering
     * on tasks.
     */

    /*
     * retailAll - its contract requires the removal of those elements of this
     * collection which do not occur in the argument collection.
     */

    public static void main(String[] args) {
        PhoneTask mikePhone = new PhoneTask("Mike", "987 6543");
        PhoneTask paulPhone = new PhoneTask("Paul", "123 4567");

        CodingTask logicCode = new CodingTask("logic");

        Collection<PhoneTask> phoneTasks = new ArrayList<PhoneTask>();
        Collection<Task> mondayTasks = new ArrayList<Task>();

        Collections.addAll(phoneTasks, paulPhone, mikePhone);
        Collections.addAll(mondayTasks, mikePhone, logicCode);

        assert phoneTasks.toString().equals("[phone Paul, phone Mike]");
        assert mondayTasks.toString().equals("[phone Mike, code logic]");

        System.out.println(phoneTasks);
        System.out.println(mondayTasks);

        Set<Task> phoneAndMondayTasks = new TreeSet<Task>(mondayTasks);
        phoneAndMondayTasks.addAll(phoneTasks);

        /*
         * Set discards the duplicate task phoneMike present in both mondayTasks
         * & phoneTasks and just preserve one copy of it
         */

        assert phoneAndMondayTasks.toString().equals(
                "[code logic, phone Mike, phone Paul]");

        System.out.println(phoneAndMondayTasks);
    }

}
