package com.kvvssut.interviews.dsalgo.datastructure.tree;

public class FenwickBinaryIndexedTreesImpl {

	public static void main(String[] args) {
		int[] inputs = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		int[] BIT = new int[inputs.length];
		for (int i = 1; i < BIT.length; i++) {
			updateBIT(BIT, i, inputs[i]);
		}

		for (int i = 1; i < BIT.length; i++) {
			System.out.print(BIT[i] + " ");
		}

		System.out.println("\nSum is :- " + queryBIT(BIT, 11));

	}

	public static void updateBIT(int[] BIT, int i, int value) {
		for (; i < BIT.length; i += i & (-i)) {
			BIT[i] += value;
		}
	}

	public static int queryBIT(int[] BIT, int i) {
		int sum = 0;
		for (; i > 0; i -= i & (-i)) {
			sum += BIT[i];
		}
		return sum;
	}
}
