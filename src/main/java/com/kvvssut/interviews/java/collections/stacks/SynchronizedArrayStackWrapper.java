package com.kvvssut.interviews.java.collections.stacks;

public class SynchronizedArrayStackWrapper implements Stack {
    private final Stack stack;

    public SynchronizedArrayStackWrapper(Stack stack) {
        this.stack = stack;
    }

    public synchronized void push(int elt) {
        stack.push(elt);
    }

    public synchronized int pop() {
        return stack.pop();
    }

    public synchronized boolean isEmpty() {
        return stack.isEmpty();
    }
}
