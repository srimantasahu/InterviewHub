package com.kvvssut.interviews.java.collections.stacks;

public class SynchronizedArrayStack implements Stack {
	private final int MAX_ELEMENTS = 10;
	private int[] stack;
	private int index;

	public SynchronizedArrayStack() {
		stack = new int[MAX_ELEMENTS];
		index = -1;
	}

	/*
	 * Using synchronized to modify the declaration of methods will guarantee
	 * that once a thread has started to execute it, all other threads are
	 * excluded from that method until the execution is done. This is called
	 * synchronizing on a critical section of code.
	 */

	public synchronized void push(int elt) {
		if (index != stack.length - 1) {
			index++; // 1
			stack[index] = elt; // 2
		} else {
			throw new IllegalStateException("Stack overflow");
		}
	}

	public synchronized int pop() {
		if (index != -1) {
			int elt = stack[index]; // 1
			index--; // 2
			return elt;
		} else {
			throw new IllegalStateException("Stack underflow");
		}
	}

	/*
	 * Each thread may use a separate memory cache, which means that writes by
	 * one thread may not seen by another unless either they both take place
	 * within blocks synchronized on the same lock, or unless the variable is
	 * marked with the volatile keyword.
	 */
	public synchronized boolean isEmpty() {
		return index == -1;
	}
}
