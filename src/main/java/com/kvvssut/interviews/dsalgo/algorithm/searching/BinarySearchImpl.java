package com.kvvssut.interviews.dsalgo.algorithm.searching;

public class BinarySearchImpl {

	/*
	 * Binary search is the most popular Search algorithm.It is efficient and
	 * also one of the most commonly used techniques that is used to solve
	 * problems.
	 * 
	 * Binary search works only on a sorted set of elements. To use binary
	 * search on a collection, the collection must first be sorted. When binary
	 * search is used to perform operations on a sorted set, the number of
	 * iterations can always be reduced on the basis of the value that is being
	 * searched.
	 */

	public static void main(String[] args) {
		int input[] = { 1, 2, 3, 5, 6, 8, 9, 10, 12 };
		System.out.println(binarySearch(input, 0, 9, 8));
	}

	public static int binarySearch(int input[], int low, int high, int key) {
		while (low <= high) {
			int mid = (low + high) / 2;
			if (key > input[mid]) {
				low = mid + 1;
			} else if (key < input[mid]) {
				high = mid - 1;
			} else {
				return input[mid];
			}
		}
		return -1;
	}

}
