package com.kvvssut.interviews.dsalgo.datastructure.heap;

/*
 * Operations on Min Heap:
 * 1) getMin(): It returns the root element of Min Heap. Time Complexity of this operation is O(1).
 * 2) extractMin(): Removes the minimum element from Min Heap. Time Complexity of this Operation is O(Logn) as this operation needs to maintain the heap property (by calling heapify()) after removing root.
 * 3) decreaseKey(): Decreases value of key. Time complexity of this operation is O(Logn). If the decreases key value of a node is greater than parent of the node, then we don�t need to do anything. Otherwise, we need to traverse up to fix the violated heap property.
 * 4) insert(): Inserting a new key takes O(Logn) time. We add a new key at the end of the tree. IF new key is greater than its parent, then we don�t need to do anything. Otherwise, we need to traverse up to fix the violated heap property.
 * 5) delete(): Deleting a key also takes O(Logn) time. We replace the key to be deleted with minum infinite by calling decreaseKey(). After decreaseKey(), the minus infinite value must reach root, so we call extractMin() to remove key.
 */
public class MinBinaryHeapImpl {

	public static void main(String[] args) {
		MinHeap minHeap = new MinHeap(11);
		minHeap.insertKey(3);
		minHeap.insertKey(2);
		minHeap.deleteKey(1);
		minHeap.insertKey(15);
		minHeap.insertKey(5);
		minHeap.insertKey(4);
		minHeap.insertKey(45);
		System.out.println(minHeap.extractMin());
		System.out.println(minHeap.getMin());
		minHeap.decreaseKey(2, 1);
		System.out.println(minHeap.getMin());
	}

}

class MinHeap {
	private int harr[];
	private int capacity;
	private int heap_size;

	public MinHeap(int capacity) {
		this.harr = new int[capacity];
		this.capacity = capacity;
		this.heap_size = 0;
	}

	// Returns the minimum key (key at root) from min heap
	public int getMin() {
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
		while (i != 0 && harr[parent(i)] > harr[i]) {
			swap(i, parent(i));
			i = parent(i);
		}
	}

	// Decreases value of key at index 'i' to new_val. It is assumed that
	// new_val is smaller than harr[i].
	public void decreaseKey(int i, int new_val) {
		harr[i] = new_val;
		while (i != 0 && harr[parent(i)] > harr[i]) {
			swap(i, parent(i));
			i = parent(i);
		}
	}

	// Method to remove minimum element (or root) from min heap
	public int extractMin() {
		if (heap_size <= 0) {
			return Integer.MAX_VALUE;
		} else if (heap_size == 1) {
			heap_size--;
			return harr[0];
		}

		int root = harr[0];
		harr[0] = harr[heap_size - 1];
		heap_size--;
		minHeapify(0);

		return root;
	}

	// A recursive method to heapify a subtree with root at given index
	// This method assumes that the subtrees are already heapified
	public void minHeapify(int i) {
		int l = left(i);
		int r = right(i);
		int smallest = i;

		if (l < heap_size && harr[l] < harr[smallest]) {
			smallest = l;
		}
		if (r < heap_size && harr[r] < harr[smallest]) {
			smallest = r;
		}
		if (smallest != i) {
			swap(i, smallest);
			minHeapify(smallest);
		}
	}

	// This function deletes key at index i. It first reduced value to minus
	// infinite, then calls extractMin()
	public void deleteKey(int i) {
		decreaseKey(i, Integer.MIN_VALUE);
		extractMin();
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
