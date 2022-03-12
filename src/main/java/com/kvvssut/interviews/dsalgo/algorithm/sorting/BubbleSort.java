package com.kvvssut.interviews.dsalgo.algorithm.sorting;

/**
 * This algorithm is based on the idea of repeatedly comparing pairs of adjacent
 * elements and then switching their positions if they exist in the wrong order.
 */
public class BubbleSort {

    public static void main(String[] args) {
        int input[] = {5, 7, 1, 2, 4, 6, 8, 9, 3};
        bubbleSort(input);
        for (int i : input) {
            System.out.print(i + "  ");
        }
    }

    public static void bubbleSort(int inputs[]) {
        int len = inputs.length;

        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (inputs[j] > inputs[j + 1]) {
                    System.out.println("Swapping - " + inputs[j] + " & " + inputs[j + 1]);
                    inputs[j] = inputs[j] + inputs[j + 1];
                    inputs[j + 1] = inputs[j] - inputs[j + 1];
                    inputs[j] = inputs[j] - inputs[j + 1];
                }
            }
        }

    }

}
