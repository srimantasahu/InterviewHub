package com.kvvssut.interviews.dsalgo.datastructure.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddAndGetMaxInQueueHeapImpl {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			int sizeOfInitialSeq = Integer.parseInt(reader.readLine());

			String inputs = reader.readLine();
			String initialSeq[] = inputs.split(" ");

			int noOfQueries = Integer.parseInt(reader.readLine());

			MaxHeapImpl maxHeap = new MaxHeapImpl(sizeOfInitialSeq + noOfQueries);
			for (int i = 0; i < sizeOfInitialSeq; i++) {
				maxHeap.insertKey(Integer.parseInt(initialSeq[i]));
			}

			for (int i = 0; i < noOfQueries; i++) {
				String input = reader.readLine();
				String queryInputs[] = input.split(" ");

				if (queryInputs.length == 2) {
					maxHeap.insertKey(Integer.parseInt(queryInputs[1]));
				} else {
					System.out.println(maxHeap.getMax());
				}
			}

		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}

}

class MaxHeapImpl {

	private int harr[];
	private int capacity;
	private int heap_size;

	public MaxHeapImpl(int capacity) {
		this.harr = new int[capacity];
		this.capacity = capacity;
		this.heap_size = 0;
	}

	// Returns the maximum key (key at root) from max heap
	public int getMax() {
		return harr[0];
	}

	// Inserts a new key 'k'
	public void insertKey(int key) {
		if (heap_size == capacity) {
			System.out.println("Overflow : couldn't insert key!");
			return;
		}

		// First insert the new key at the end
		heap_size++;
		int i = heap_size - 1;
		harr[i] = key;

		// Fix the min heap property if it is violated
		while (i != 0 && harr[parent(i)] < harr[i]) {
			swap(i, parent(i));
			i = parent(i);
		}
	}

	public int parent(int i) {
		return (i - 1) / 2;
	}

	public int left(int i) {
		return (2 * i + 1);
	}

	public int right(int i) {
		return (2 * i + 2);
	}

	public void swap(int i, int j) {
		int dummy = harr[i];
		harr[i] = harr[j];
		harr[j] = dummy;
	}

}