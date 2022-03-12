package com.kvvssut.interviews.dsalgo.algorithm.searching;

public class TernarySearchImpl {

    /*
     * In binary search, the sorted array is divided into two parts while in
     * ternary search, it is divided into 3 3 parts and then you determine in
     * which part the element exists.
     *
     * Ternary search, like binary search, is a divide-and-conquer algorithm. It
     * is mandatory for the array (in which you will search for an element) to
     * be sorted before you begin the search. In this search, after each
     * iteration it neglects ⅓ part of the array and repeats the same operations
     * on the remaining ⅔.
     *
     * Complexity : O(log3 N)
     */

    public static void main(String[] args) {
        int input[] = {1, 2, 3, 5, 6, 8, 13, 15};
        System.out.println(ternarySearch(input, 0, 7, 13));
    }

    public static int ternarySearch(int[] input, int l, int r, int key) {
        if (r >= l) {
            int mid1 = l + (r - l) / 3;
            int mid2 = r - (r - l) / 3;

            if (key == input[mid1]) {
                return input[mid1];
            } else if (key == input[mid2]) {
                return input[mid2];
            } else if (key < input[mid1]) {
                return ternarySearch(input, l, mid1 - 1, key);
            } else if (key > input[mid2]) {
                return ternarySearch(input, mid2 + 1, r, key);
            } else {
                return ternarySearch(input, mid1 + 1, mid2 - 1, key);
            }
        }
        return -1;
    }

}
