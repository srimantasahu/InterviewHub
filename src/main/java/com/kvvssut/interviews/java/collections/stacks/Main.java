package com.kvvssut.interviews.java.collections.stacks;

public class Main {

	public static void main(String[] args) {
		/*
		 * Synchronized wrappers : The only reference to the wrapped object is
		 * held by the wrapper, so all calls on the wrapped object will be
		 * synchronized on the same lock - that belonging to the wrapper object
		 * itself.
		 */

		// Usage as synchronized wrappers
		Stack stack = new SynchronizedArrayStackWrapper(new ArrayStack());

		/*
		 * Don't do this in a multi-threaded environment, because it may throw
		 * exception when the last element on the stack were removed by another
		 * thread in the time between the evaluation of isEmpty and the
		 * execution of pop. This is an example of common concurrent bug, called
		 * as test-then-act, in which program behavior is guided by information
		 * that in some circumstances will be out of date.
		 */
		// if (!stack.isEmpty()) {
		// stack.pop(); // can throw IllegalStateException
		// }

		// Instead use this way
		synchronized (stack) {
			if (!stack.isEmpty()) {
				stack.pop();
			}
		}
	}

}
