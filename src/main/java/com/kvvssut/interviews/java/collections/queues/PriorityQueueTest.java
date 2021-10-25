package com.kvvssut.interviews.java.collections.queues;

import java.util.Comparator;
import java.util.PriorityQueue;

class StringLengthComparator implements Comparator<String> {
	@Override
	public int compare(String x, String y) {
		return x.length() - y.length();
	}
}

public class PriorityQueueTest {
	public static void main(String[] args) {
		Comparator<String> comparator = new StringLengthComparator();
		PriorityQueue<String> priorityQueue = new PriorityQueue<String>(10, comparator);
		priorityQueue.add("short");
		priorityQueue.add("very long indeed");
		priorityQueue.add("medium");
		while (priorityQueue.size() != 0) {
			System.out.println(priorityQueue.remove());
		}
	}
}
