package com.kvvssut.interviews.java.collections.sets;

import java.util.Collections;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

import com.kvvssut.interviews.java.collections.collectioninterface.CodingTask;
import com.kvvssut.interviews.java.collections.collectioninterface.EmptyTask;
import com.kvvssut.interviews.java.collections.collectioninterface.PhoneTask;

public class NavigableSetMain {

	/*
	 * NavigableSet was introduced in Java 6 to supplement deficiencies in
	 * SortedSet (so, new client code should use NavigableSet in preference to
	 * SortedSet).
	 */

	/*
	 * It adds methods in four groups -
	 */
	public static void main(String[] args) {
		PhoneTask mikePhone = new PhoneTask("Mike", "987 6543");
		PhoneTask paulPhone = new PhoneTask("Paul", "123 4567");
		CodingTask datatbaseCode = new CodingTask("db");
		CodingTask interfaceCode = new CodingTask("gui");

		NavigableSet<PriorityTask> priorityTasks = new TreeSet<PriorityTask>();
		priorityTasks.add(new PriorityTask(mikePhone, Priority.MEDIUM));
		priorityTasks.add(new PriorityTask(paulPhone, Priority.HIGH));
		priorityTasks.add(new PriorityTask(datatbaseCode, Priority.MEDIUM));
		priorityTasks.add(new PriorityTask(interfaceCode, Priority.LOW));

		/*
		 * 1. Getting the First and Last Elements - E pollFirst(); E pollLast();
		 * - retrieves and removes the first and the last element respectively,
		 * or return null if this set is empty (just to retrieve elements
		 * without removing it - we can always use the methods first and last
		 * inherited from SortedSet).
		 */
		PriorityTask nextTask = priorityTasks.pollFirst();
		assert nextTask.toString().equals("phone Paul : HIGH");
		System.out.println(nextTask);

		/*
		 * 2. Getting Range Views - NavigableSet<E> subSet(E fromElement,
		 * boolean fromInclusive, E toElement, boolean toInclusive);
		 * NavigableSet<E> headSet(E toElement, boolean inclusive);
		 * NaviagbleSet<E> tailSet(E fromElement, boolean inclusive);
		 */
		PriorityTask firstMediumPriorityTask = new PriorityTask(
				new EmptyTask(), Priority.MEDIUM);

		PriorityTask mikePhoneMedium = new PriorityTask(mikePhone,
				Priority.MEDIUM);
		NavigableSet<PriorityTask> closedInterval = priorityTasks.subSet(
				firstMediumPriorityTask, true, mikePhoneMedium, true);
		assert closedInterval.toString().equals(
				"[code db : MEDIUM, phone Mike : MEDIUM]");
		System.out.println(closedInterval);

		/*
		 * 3. Getting Closeset Matches - E ceiling(E e); E floor(E e); E
		 * higher(E e); E lower(E e); - ceiling|floor returns the least/higher
		 * element greater/less than or equal to e and higher|lower returns the
		 * least/greatest element strictly greater/less than e; if there is no
		 * such element, null is returned by all
		 * 
		 * These methods are useful for short-distance navigation.
		 */
		NavigableSet<String> stringSet = new TreeSet<String>();
		Collections.addAll(stringSet, "zed", "x-ray", "cde", "abc");

		String last = stringSet.floor("x-ray");
		assert last.equals("x-ray");
		System.out.println(last);

		String secondLast = last == null ? null : stringSet.lower(last);
		assert secondLast.equals("cde");
		System.out.println(secondLast);

		String thirdLast = secondLast == null ? null : stringSet
				.lower(secondLast);
		assert thirdLast.equals("abc");
		System.out.println(thirdLast);

		/*
		 * 4. Navigating the Set in Reverse Order - NaviggableSet<E>
		 * descendingSet(); Iterator<E> descendingIterator(); - methods of this
		 * group make traversing a NavigableSet equally easy in the descending
		 * ordering.
		 */

		NavigableSet<String> headSet = stringSet.headSet(last, true);
		NavigableSet<String> reverseHeadSet = headSet.descendingSet();
		assert reverseHeadSet.toString().equals("");
		System.out.println(reverseHeadSet);

		/*
		 * If the iterative processing involves structural changes to the set,
		 * and the implementation being used is TreeSet(which has fail-fast
		 * iterators), we will have to use an explicit iterator to avoid
		 * ConcurrentModificationException.
		 */

		for (Iterator<String> itr = headSet.descendingIterator(); itr.hasNext();) {
			itr.next();
			itr.remove();
		}
		assert headSet.isEmpty() == true;
		System.out.println(headSet.isEmpty());
	}
}
