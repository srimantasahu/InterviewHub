package com.kvvssut.interviews.java.collections.sets;

import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

import com.kvvssut.interviews.java.collections.collectioninterface.CodingTask;
import com.kvvssut.interviews.java.collections.collectioninterface.EmptyTask;
import com.kvvssut.interviews.java.collections.collectioninterface.PhoneTask;

public class SortedSetMain {

	/*
	 * Set has one sub-interface, SortedSet, which adds to the Set contract a
	 * guarantee that its iterator will traverse the set in ascending element
	 * order. SortedSet was itself extended by NavigableSet, which adds methods
	 * to find the closest matches to a target element.
	 */

	/*
	 * TreeSet is an implementation of SortedSet interface.
	 * 
	 * Element ordering can either be defined by the element class itself, if
	 * that implements Comparable, or it can be imposed by an external
	 * Comparator, supplied by a constructor such as this one, for TreeSet :
	 * 
	 * TreeSet(Comparator<? super E> comparator)
	 */

	/*
	 * Methods defined by SortedSet interface fall into three groups:
	 * 
	 * 1. Getting the First and Last Element - E first(); E last(); - if set is
	 * empty, these operations throw NoSuchElementException.
	 * 
	 * 2. Retrieving the Comparator - Comparator<? super E> comparator(); - the
	 * type with wildcard and super is used because a SortedSet parameterized on
	 * E can rely for ordering on a Comparator defined on any supertype of E.
	 * 
	 * 3. Getting Range Views - SortedSet<E> subSet(E fromElement, E toElement);
	 * SortedSet<E> headSet(E toElement); SortedSet<E> tailSet(E fromElement); -
	 * the above sets returned are half-open intervals: they are inclusive of
	 * the fromElement and exclusive of the toElement.
	 */

	public static void main(String[] args) {
		PhoneTask mikePhone = new PhoneTask("Mike", "987 6543");
		PhoneTask paulPhone = new PhoneTask("Paul", "123 4567");
		CodingTask datatbaseCode = new CodingTask("db");
		CodingTask interfaceCode = new CodingTask("gui");
		CodingTask logicCode = new CodingTask("logic");

		NavigableSet<PriorityTask> priorityTasks = new TreeSet<PriorityTask>();
		priorityTasks.add(new PriorityTask(mikePhone, Priority.MEDIUM));
		priorityTasks.add(new PriorityTask(paulPhone, Priority.HIGH));
		priorityTasks.add(new PriorityTask(datatbaseCode, Priority.MEDIUM));
		priorityTasks.add(new PriorityTask(interfaceCode, Priority.LOW));
		assert priorityTasks
				.toString()
				.equals("[phone Paul : HIGH, code db : MEDIUM, phone Mike : MEDIUM, code gui : LOW]");
		System.out.println(priorityTasks);

		PriorityTask firstLowPriorityTask = new PriorityTask(new EmptyTask(),
				Priority.LOW);

		SortedSet<PriorityTask> highAndMediumPriorityTasks = priorityTasks
				.headSet(firstLowPriorityTask);
		assert highAndMediumPriorityTasks.toString().equals(
				"[phone Paul : HIGH, code db : MEDIUM, phone Mike : MEDIUM]");
		System.out.println(highAndMediumPriorityTasks);

		PriorityTask firstMediumPriorityTask = new PriorityTask(
				new EmptyTask(), Priority.MEDIUM);

		SortedSet<PriorityTask> mediumPriorityTasks = priorityTasks.subSet(
				firstMediumPriorityTask, firstLowPriorityTask);
		assert mediumPriorityTasks.toString().equals(
				"[code db : MEDIUM, phone Mike : MEDIUM]");
		System.out.println(mediumPriorityTasks);

		/*
		 * Notice that the sets returned by these operations are not independent
		 * sets but new views of the original SortedSet. So we can add elements
		 * to the original set and see the changes reflected in the view -
		 */
		PriorityTask logicCodeMedium = new PriorityTask(logicCode,
				Priority.MEDIUM);
		priorityTasks.add(logicCodeMedium);
		assert mediumPriorityTasks.toString().equals(
				"[code db : MEDIUM, code logic : MEDIUM, phone Mike : MEDIUM]");
		System.out.println(mediumPriorityTasks);

		/*
		 * The reverse applies also; changes in the view are reflected in the
		 * original set -
		 */
		mediumPriorityTasks.remove(logicCodeMedium);
		assert mediumPriorityTasks.toString().equals(
				"[code db : MEDIUM, phone Mike : MEDIUM]");
		System.out.println(mediumPriorityTasks);

		/*
		 * To understand how it works, think of all the possible values in an
		 * ordering as lying on a line. A range is defined as a fixed segment of
		 * that line, regardless of which values are actually in the original
		 * set. So a subset, defined on a SortedSet and a range, will allow to
		 * work with whichever elements of the SortedSet currently lie within
		 * the range.
		 */
	}
}
