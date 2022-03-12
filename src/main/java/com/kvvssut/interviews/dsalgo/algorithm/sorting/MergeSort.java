package com.kvvssut.interviews.dsalgo.algorithm.sorting;

/**
 * This sorting algorithm works on the following principle - Divide the array in
 * two halves. Repeatedly sort each half, then merge two halves.
 * <p>
 * Array with n elements is divided recursively in 2 parts, so it will form a
 * tree with nodes as divided parts of array ( subproblems ). The height of the
 * tree will be log2n and at each level of tree the computation cost of all the
 * subproblems will be n. At each level the merge operation will take O( n )
 * time. So the overall complexity of this algorithm will be O( n( log2 n )).
 */
public class MergeSort {

    public static void main(String[] args) {
        int input[] = {5, 7, 1, 2, 4, 6, 8, 9, 3};
        mergeSort(input, 0, input.length - 1);
        for (int i : input) {
            System.out.print(i + "  ");
        }
    }

    public static void mergeSort(int inputs[], int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(inputs, start, mid);
            mergeSort(inputs, mid + 1, end);

            merge(inputs, start, mid, end);
        }
    }

    private static void merge(int[] inputs, int start, int mid, int end) {
        int p = start, q = mid + 1;
        int temp[] = new int[end - start + 1], k = 0;

        for (int i = start; i <= end; i++) {
            if (p > mid) {
                temp[k++] = inputs[q++];
            } else if (q > end) {
                temp[k++] = inputs[p++];
            } else if (inputs[p] < inputs[q]) {
                temp[k++] = inputs[p++];
            } else {
                temp[k++] = inputs[q++];
            }
        }

        for (int i = 0; i < k; i++) {
            inputs[start++] = temp[i];
        }
    }

}
