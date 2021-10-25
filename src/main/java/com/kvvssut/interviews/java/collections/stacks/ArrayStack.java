package com.kvvssut.interviews.java.collections.stacks;

public class ArrayStack implements Stack {
	private final int MAX_ELEMENTS = 10;
	private int[] stack;
	private int index;

	public ArrayStack() {
		stack = new int[MAX_ELEMENTS];
		index = -1;
	}

	/*
	 * Operations 1 and 2 are not atomic and during race condition it will leave
	 * the program in an inconsistent state
	 */

	public void push(int elt) {
		if (index != stack.length - 1) {
			index++; // 1
			stack[index] = elt; // 2
		} else {
			throw new IllegalStateException("Stack overflow");
		}
	}

	public int pop() {
		if (index != -1) {
			int elt = stack[index]; // 1
			index--; // 2
			return elt;
		} else {
			throw new IllegalStateException("Stack underflow");
		}
	}

	public boolean isEmpty() {
		return index == -1;
	}
}
