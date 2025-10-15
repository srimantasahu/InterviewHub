package com.kvvssut.interviews.codinground.problems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class VerifyPreorderToBST {

    // Main method to test the function
    public static void main(String[] args) {
        VerifyPreorderToBST obj = new VerifyPreorderToBST();

        int[] preorder1 = {10, 5, 1, 7, 40, 50};
        System.out.println("Test Case 1: " + Arrays.toString(preorder1));
        System.out.println("Is Valid BST Preorder? " + obj.verifyPreorder(preorder1)); // true

        int[] preorder2 = {10, 5, 1, 7, 40, 30};
        System.out.println("\nTest Case 2: " + Arrays.toString(preorder2));
        System.out.println("Is Valid BST Preorder? " + obj.verifyPreorder(preorder2)); // false
    }

    // Function to verify if preorder array can represent a BST
    public boolean verifyPreorder(int[] preorder) {
        // Stack to store ancestors
        Deque<Integer> stack = new ArrayDeque<>();

        // This keeps track of the minimum allowed value
        // for the current node (BST lower bound)
        int lowerBound = Integer.MIN_VALUE;

        // Iterate through each value in the preorder traversal
        for (int value : preorder) {
            // If we ever find a value smaller than the lower bound,
            // it violates BST property -> return false
            if (value < lowerBound) {
                return false;
            }

            // While current value is greater than the top of stack,
            // it means we are done with left subtree and moving to right subtree.
            // Pop ancestors and update lowerBound.
            while (!stack.isEmpty() && value > stack.peek()) {
                lowerBound = stack.pop();
            }

            // Push current value as a potential ancestor
            stack.push(value);
        }

        // If we reach here, no violations found
        return true;
    }
}