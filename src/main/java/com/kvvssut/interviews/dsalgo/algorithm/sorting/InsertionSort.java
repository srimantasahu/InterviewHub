package com.kvvssut.interviews.dsalgo.algorithm.sorting;

/**
 * The idea behind is that in each iteration, it consumes one element from the
 * input elements, removes it and finds its correct position i.e., where it
 * belongs in the sorted list and places it there.
 *
 */
public class InsertionSort {

	public static void main(String[] args) {
		int input[] = { 5, 7, 1, 2, 4, 6, 8, 9, 3 };
		insertionSort(input);
		for (int i : input) {
			System.out.print(i + "  ");
		}
	}

	public static void insertionSort(int inputs[]) {
		int len = inputs.length, pos, temp;
		for (int i = 1; i < len; i++) {
			temp = inputs[i];
			pos = i - 1;

			while (pos >= 0 && temp < inputs[pos]) {
				System.out.println("Swapping - " + inputs[pos] + " & " + temp);
				inputs[pos + 1] = inputs[pos];
				pos = pos - 1;
			}
			inputs[pos + 1] = temp;
		}

	}

}
