package com.kvvssut.interviews.java.collections.collectioninterface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class Main {

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

		CodingTask datatbaseCode = new CodingTask("db");
		CodingTask interfaceCode = new CodingTask("gui");
		CodingTask logicCode = new CodingTask("logic");

		Collection<PhoneTask> phoneTasks = new ArrayList<PhoneTask>();
		Collection<CodingTask> codingTasks = new ArrayList<CodingTask>();
		Collection<Task> mondayTasks = new ArrayList<Task>();
		Collection<Task> tuesdayTasks = new ArrayList<Task>();

		Collections.addAll(phoneTasks, mikePhone, paulPhone);
		Collections
				.addAll(codingTasks, datatbaseCode, interfaceCode, logicCode);
		Collections.addAll(mondayTasks, logicCode, mikePhone);
		Collections.addAll(tuesdayTasks, datatbaseCode, interfaceCode,
				paulPhone);

		assert phoneTasks.toString().equals("[phone Mike, phone Paul]");
		assert codingTasks.toString().equals("[code db, code gui, code logic]");
		assert mondayTasks.toString().equals("[code logic, phone Mike]");
		assert tuesdayTasks.toString()
				.equals("[code db, code gui, phone Paul]");
		System.out.println(phoneTasks);
		System.out.println(codingTasks);
		System.out.println(mondayTasks);
		System.out.println(tuesdayTasks);

		// 1. Adding Elements
		System.out.println("\nAdding Elements");
		mondayTasks.add(new PhoneTask("Ruth", "567 1234"));
		assert mondayTasks.toString().equals(
				"[code logic, phone Mike, phone Ruth]");
		System.out.println(mondayTasks);

		Collection<Task> allTasks = new ArrayList<Task>(mondayTasks);
		allTasks.addAll(tuesdayTasks);
		assert allTasks
				.toString()
				.equals("[code logic, phone Mike, phone Ruth, code db,code gui, phone Paul]");
		System.out.println(allTasks);

		Collection<Task> mondayTasksRef = new ArrayList<Task>(mondayTasks);

		// 2. Removing Elements
		System.out.println("\nRemoving Elements");
		boolean wasPresent = mondayTasks.remove(mikePhone);
		assert wasPresent;
		System.out.println(wasPresent);
		assert mondayTasks.toString().equals("[code logic, phone Ruth]");
		System.out.println(mondayTasks);

		mondayTasks.clear();
		assert mondayTasks.toString().equals("[]");
		System.out.println(mondayTasks);

		Collection<Task> tuesdayTasksRef = new ArrayList<Task>(tuesdayTasks);

		Collection<Task> tuesdayNonPhoneTasks = new ArrayList<Task>(
				tuesdayTasks);
		tuesdayNonPhoneTasks.removeAll(phoneTasks);
		assert tuesdayNonPhoneTasks.toString().equals("[code db, code gui]");
		System.out.println(tuesdayNonPhoneTasks);

		Collection<Task> tuesdayPhoneTasks = new ArrayList<Task>(
				tuesdayTasksRef);
		tuesdayPhoneTasks.retainAll(phoneTasks);
		assert tuesdayPhoneTasks.toString().equals("[phone paul]");
		System.out.println(tuesdayPhoneTasks);

		Collection<Task> tuesdayPhoneTasks2 = new ArrayList<Task>(phoneTasks);
		tuesdayPhoneTasks2.retainAll(tuesdayTasksRef);
		assert tuesdayPhoneTasks2.toString().equals("[phone Paul]");
		System.out.println(tuesdayPhoneTasks2);

		// 3. Querying the Contents of a Collection
		System.out.println("\nQuerying the Contents of a Collection");
		assert tuesdayPhoneTasks.contains(paulPhone);
		System.out.println(tuesdayPhoneTasks);
		assert tuesdayTasks.contains(tuesdayPhoneTasks);
		System.out.println(tuesdayTasks);
		assert mondayTasks.isEmpty();
		System.out.println(mondayTasks.isEmpty());
		assert mondayTasks.size() == 0;
		System.out.println(mondayTasks.size());

		// 4. Making the Collection's Contents Available for Further Processing
		System.out
				.println("\nMaking the Collection's Contents Available for Further Processing");
		for (Task task : tuesdayTasks) {
			System.out.println(task);
		}

		// throws ConcurrentModificationException
		// for (Task task : tuesdayTasks) {
		// if (task instanceof PhoneTask) {
		// tuesdayTasks.remove(task);
		// }
		// }

		// throws ConcurrentModificationException
		// for (Iterator<Task> iterator = tuesdayTasks.iterator(); iterator
		// .hasNext();) {
		// Task task = iterator.next();
		// if (task instanceof PhoneTask) {
		// tuesdayTasks.remove(task);
		// }
		// }

		// Correct way is to use the iterator's structure-changing methods
		System.out
				.println("\nCorrect way to avoid ConcurrentModificationException while simultaneously iterating a collection and removing an element from it");
		System.out.println(tuesdayTasks);
		for (Iterator<Task> iterator = tuesdayTasks.iterator(); iterator
				.hasNext();) {
			Task task = iterator.next();
			if (task instanceof PhoneTask) {
				iterator.remove();
			}
		}
		System.out.println(tuesdayTasks);

		// Merge Collections 
		System.out.println("\nMerge Collections");
		Collection<Task> mergedTasks = MergeCollections.merge(mondayTasksRef,
				tuesdayTasksRef);
		assert mergedTasks.toString().equals(
				"[code db, code gui, code logic, phone Mike, phone Paul, phone Ruth]");
		System.out.println(mergedTasks);

	}

}
