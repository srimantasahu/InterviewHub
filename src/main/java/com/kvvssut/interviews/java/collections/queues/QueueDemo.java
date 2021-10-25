package com.kvvssut.interviews.java.collections.queues;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {

	/*
	 * Since Queue is an interface you need to instantiate a concrete
	 * implementation of the interface in order to use it. You can choose
	 * between the following Queue implementations in the Java Collections API:
	 * 
	 * java.util.LinkedList - LinkedList is a pretty standard queue implementation. 
	 * java.util.PriorityQueue - PriorityQueue stores its elements internally 
	 * according to their natural order (if they implement Comparable), or according 
	 * to a Comparator passed to the PriorityQueue.
	 * 
	 */

	public static void main(String[] args) {
		Queue<String> myQueue = new LinkedList<String>();

		myQueue.offer("abc");
		myQueue.offer("def");
		myQueue.offer("ghi");

		while (myQueue.peek() != null) {
			System.out.println(myQueue.poll());
		}

	}

}
