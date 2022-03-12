package com.kvvssut.interviews.dsalgo.algorithm.sorting;

/**
 * This algorithm is based on the idea of finding the minimum or maximum element
 * in the unsorted array and then putting it in its correct position for a
 * sorted array.
 */
public class SelectionSort {

    public static void main(String[] args) {
        int input[] = {5, 7, 1, 2, 4, 6, 8, 9, 3};
        selectionSort(input);
        for (int i : input) {
            System.out.print(i + "  ");
        }
    }

    public static void selectionSort(int inputs[]) {
        int len = inputs.length, min;
        for (int i = 0; i < len - 1; i++) {
            min = i;

            for (int j = i + 1; j < len; j++) {
                if (inputs[min] > inputs[j]) {
                    min = j;
                }
            }

            if (min != i) {
                System.out.println("Swapping - " + inputs[i] + " & " + inputs[min]);
                inputs[i] = inputs[i] + inputs[min];
                inputs[min] = inputs[i] - inputs[min];
                inputs[i] = inputs[i] - inputs[min];
            }
        }

    }

}
