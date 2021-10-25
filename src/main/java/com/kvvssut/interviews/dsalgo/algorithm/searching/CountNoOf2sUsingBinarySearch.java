package com.kvvssut.interviews.dsalgo.algorithm.searching;

public class CountNoOf2sUsingBinarySearch {

	public static void main(String[] args) {
		int[] inputs = { 0, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5 };
		System.out.println(countNoOf2s(inputs, 0, inputs.length - 1, 2));
	}

	private static int countNoOf2s(int[] inputs, int l, int r, int key) {
		if (r >= l) {
			int mid = (l + r) / 2;

			if (key < inputs[mid]) {
				return countNoOf2s(inputs, l, mid - 1, key);
			} else if (key > inputs[mid]) {
				return countNoOf2s(inputs, mid + 1, r, key);
			} else if (inputs[l] == inputs[r]) {
				return 1 + (r - l);
			} else {
				return 1 + (countNoOf2s(inputs, l, mid - 1, key) + countNoOf2s(inputs, mid + 1, r, key));
			}
		}
		return 0;
	}

}
