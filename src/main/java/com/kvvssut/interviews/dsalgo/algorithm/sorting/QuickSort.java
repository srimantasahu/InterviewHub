package com.kvvssut.interviews.dsalgo.algorithm.sorting;

import java.util.Random;

/**
 * This sorting algorithm is based on the idea of choosing one element as pivot
 * element and partitioning the array around it such that the left side of pivot
 * contains all elements less than the pivot element and right side contains all
 * elements greater than the pivot.
 * <p>
 * It is also based on the divide and conquer approach. It reduces the space
 * complexity and removes the use of auxiliary array used in merge sort.
 * <p>
 * The worst case time complexity of this algorithm is O( n2 ), but as this is
 * randomized algorithm, its time complexity fluctuates between O( n2 ) and O(n
 * (log n) ) and mostly it comes out to be O( n (log n)) .
 */
public class QuickSort {

    public static void main(String[] args) {
        int input[] = {5, 7, 1, 2, 4, 6, 8, 9, 3};
        quickSort(input, 0, input.length - 1);
        for (int i : input) {
            System.out.print(i + "  ");
        }
    }

    public static void quickSort(int[] inputs, int start, int end) {
        if (start < end) {
            int pivot_pos = randomPartition(inputs, start, end);
            quickSort(inputs, start, pivot_pos - 1);
            quickSort(inputs, pivot_pos + 1, end);
        }
    }

    private static int randomPartition(int[] inputs, int start, int end) {
        int random = start + (Math.abs(new Random(957).nextInt())) % (end - start + 1);
        System.out.println("random : " + random);
        swap(inputs, random, start);
        return partition(inputs, start, end);
    }

    private static int partition(int[] inputs, int start, int end) {
        int i = start + 1;
        int pivot = inputs[start];
        System.out.println("Pivot is - " + pivot);
        for (int j = i; j < inputs.length; j++) {
            if (inputs[j] < pivot) {
                swap(inputs, j, i);
                i = i + 1;
            }
        }
        swap(inputs, i - 1, start);
        return i - 1;
    }

    private static void swap(int[] inputs, int i, int j) {
        if (i != j) {
            System.out.println("Swapping - " + inputs[j] + " & " + inputs[i]);
            inputs[i] = inputs[i] + inputs[j];
            inputs[j] = inputs[i] - inputs[j];
            inputs[i] = inputs[i] - inputs[j];
        }
    }

}
