package com.kvvssut.interviews.dsalgo.algorithm.searching;

public class TernarySearchImplForUnimodalFucntions {

	/*
	 * Use of ternary search:
	 * 
	 * This concept is used in unimodal functions to determine the maximum or
	 * minimum value of that function. Unimodal functions are functions that,
	 * have a single highest value.
	 * 
	 * Let us consider a function func in the interval [a,b], and you are
	 * required to determine the func(x) is maximized. The function func is
	 * unimodal in nature, i.e. it strictly increases in the interval [a,x] and
	 * strictly decreases in the interval [x,b].
	 */

	public static void main(String[] args) {
		int input[] = { 1, 2, 3, 5, 6, 8, 13, 15 };
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
