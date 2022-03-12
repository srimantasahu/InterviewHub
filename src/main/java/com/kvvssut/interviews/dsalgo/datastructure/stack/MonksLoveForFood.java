package com.kvvssut.interviews.dsalgo.datastructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MonksLoveForFood {

    private static int SIZE = 0;
    private static int top = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        SIZE = Integer.parseInt(line);
        int stack[] = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            line = br.readLine();
            if (line.charAt(0) == '1') {
                pop(stack);
            } else {
                push(stack, Integer.parseInt(line.split(" ")[1]));
            }
        }
    }

    private static void push(int[] stack, int item) {
        top = top + 1;
        stack[top] = item;
    }

    private static void pop(int[] stack) {
        if (isEmpty()) {
            System.out.println("No Food");
        } else {
            System.out.println(stack[top]);
            top = top - 1;
        }
    }

    private static boolean isEmpty() {
        if (top == -1) {
            return true;
        }
        return false;
    }
}
