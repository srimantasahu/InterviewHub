package com.kvvssut.interviews.dsalgo.datastructure.stack;

public class StackImpl {

    private static final int SIZE = 5;
    private static int top = -1;

    public static void main(String[] args) {
        int stack[] = new int[SIZE];

        push(stack, 1);

        push(stack, 2);

        push(stack, 3);

        push(stack, 1);

        push(stack, 2);

        System.out.println("Size of stack - " + size());

        push(stack, 3);

        pop(stack);

        pop(stack);

        System.out.println("Size of stack - " + size());

        pop(stack);

        pop(stack);

        pop(stack);

        System.out.println("Size of stack - " + size());

        pop(stack);

    }

    private static void push(int[] stack, int item) {
        if (isFull()) {
            System.out.println("Stack Overflow happenned! Please remove some items and try again..");
        } else {
            top = top + 1;
            stack[top] = item;
            System.out.println("Pushed item - " + item);
        }
    }

    private static void pop(int[] stack) {
        if (isEmpty()) {
            System.out.println("Stach Underflow happenned! Please add some item and then try again..");
        } else {
            System.out.println("Removed item - " + stack[top]);
            top = top - 1;
        }
    }

    private static boolean isFull() {
        if (top == SIZE - 1) {
            return true;
        }
        return false;
    }

    private static boolean isEmpty() {
        if (top == -1) {
            return true;
        }
        return false;
    }

    private static int size() {
        return top + 1;
    }

}
