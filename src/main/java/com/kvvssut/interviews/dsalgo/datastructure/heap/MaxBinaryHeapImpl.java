package com.kvvssut.interviews.dsalgo.datastructure.heap;

/*
 * Priority-Queues - stores elements in it on the basis of the values of its elements. A Priority Queue is based on Heaps.
 * Priority queues are used to obtain elements on the basis of some of the properties they possess. For example, 
 * a Max-Heap based Priority Queue always dequeues the maximum element present in the queue. A min-heap dequeues the minimum element present in the queue.
 * 
 * Heaps are a special type of binary trees, which stores elements on the basis of their values.
 * There are specifically two types of heaps -
 * 	Min-Heaps
 * 	Max-Heaps
 * 
 * A Binary Heap is a Binary Tree with following properties.
 * 1) It�s a complete tree (All levels are completely filled except possibly the last level and the last level has all keys as left as possible). This property of Binary Heap makes them suitable to be stored in an array.
 * 2) A Binary Heap is either Min Heap or Max Heap. In a Min Binary Heap, the key at root must be minimum among all keys present in Binary Heap. The same property must be recursively true for all nodes in Binary Tree. Max Binary Heap is similar to Min Heap.
 * 
 * In a max-heap, each node has greater value than any of its children. Suppose there are N jobs in a queue to be done, and each job has its own priority. 
 * The job with maximum priority will get completed first than others. At each instant, we are completing a job with maximum priority and at the same time, 
 * we are also interested in inserting a new job in the queue with its own priority. So at each instant, we have to check for the job with maximum priority 
 * to complete it and also insert if there is a new job. This task can be very easily executed using a heap by considering N jobs as N nodes of the tree. 
 * Assume a heap having some elements which are stored in array A. The way to convert this array into a heap structure is the following -
 * 
 * 	Pick a node in the array, check if the left subtree and the right subtree are max-heaps, in themselves and the node itself is a max-heap 
 * (its value should be greater than all the child nodes).
 * 
 */
public class MaxBinaryHeapImpl {

	public static void main(String[] args) {
		MaxHeap maxHeap = new MaxHeap(11);
		maxHeap.insertKey(3);
		maxHeap.insertKey(2);
		maxHeap.deleteKey(1);
		maxHeap.insertKey(15);
		maxHeap.insertKey(5);
		maxHeap.insertKey(4);
		maxHeap.insertKey(45);
		System.out.println(maxHeap.extractMax());
		System.out.println(maxHeap.getMax());
		maxHeap.increaseKey(2, 25);
		System.out.println(maxHeap.getMax());

	}
}

class MaxHeap {

	private int harr[];
	private int capacity;
	private int heap_size;

	public MaxHeap(int capacity) {
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

	// Decreases value of key at index 'i' to new_val. It is assumed that
	// new_val is smaller than harr[i].
	public void increaseKey(int i, int new_val) {
		harr[i] = new_val;
		while (i != 0 && harr[parent(i)] < harr[i]) {
			swap(i, parent(i));
			i = parent(i);
		}
	}

	// Method to remove maximum element (or root) from the max heap
	public int extractMax() {
		if (heap_size <= 0) {
			return Integer.MAX_VALUE;
		} else if (heap_size == 1) {
			heap_size--;
			return harr[0];
		}

		int root = harr[0];
		harr[0] = harr[heap_size - 1];
		heap_size--;
		maxHeapify(0);

		return root;
	}

	// A recursive method to heapify a subtree with root at given index
	// This method assumes that the subtrees are already heapified
	public void maxHeapify(int i) {
		int l = left(i);
		int r = right(i);
		int largest = i;

		if (l < heap_size && harr[l] > harr[largest]) {
			largest = l;
		}
		if (r < heap_size && harr[r] > harr[largest]) {
			largest = r;
		}
		if (largest != i) {
			swap(i, largest);
			maxHeapify(largest);
		}
	}

	// This function deletes key at index i. It first reduced value to minus
	// infinite, then calls extractMin()
	public void deleteKey(int i) {
		increaseKey(i, Integer.MAX_VALUE);
		extractMax();
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
