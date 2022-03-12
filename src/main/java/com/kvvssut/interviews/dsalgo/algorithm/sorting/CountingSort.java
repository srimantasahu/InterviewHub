package com.kvvssut.interviews.dsalgo.algorithm.sorting;

/**
 * In this sort, we count the frequencies of distinct elements of array and
 * store them in an auxiliary array, by mapping its value as index of auxiliary
 * array and then place each element in its proper position in the output array
 * .
 * <p>
 * As the above code runs in linear time so the complexity in worst case will be
 * O(max + n), where n is the number of elements and max is the range of input
 * element of array A[ ].
 */
public class CountingSort {

    public static void main(String[] args) {
        int input[] = {5, 7, 1, 2, 4, 6, 8, 9, 3, 2, 1, 9, 5};
        countingSort(input);
        for (int i : input) {
            System.out.print(i + "  ");
        }
    }

    public static void countingSort(int[] input) {
        int maxVal = 0;
        int length = input.length;

        for (int i = 0; i < length; i++) {
            if (input[i] > maxVal) {
                maxVal = input[i];
            }
        }

        int aux[] = new int[maxVal + 1];
        for (int i = 0; i <= maxVal; i++) {
            aux[i] = 0;
        }

        for (int i = 0; i < length; i++) {
            aux[input[i]] = aux[input[i]] + 1;
        }

        int val = 0, len = 0;
        for (int i = 0; i <= maxVal; i++) {
            val = aux[i];
            for (int j = 0; j < val; j++) {
                input[len++] = i;
            }
        }
    }

}
