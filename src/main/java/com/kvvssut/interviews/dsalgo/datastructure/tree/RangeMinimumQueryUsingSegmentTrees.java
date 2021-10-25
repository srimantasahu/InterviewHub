package com.kvvssut.interviews.dsalgo.datastructure.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RangeMinimumQueryUsingSegmentTrees {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));

			String readLine = reader.readLine();
			String[] readArray = readLine.split(" ");

			int sizeOfArr = Integer.parseInt(readArray[0]), noOfQueries = Integer.parseInt(readArray[1]);

			int[] array = new int[sizeOfArr];
			int[] tree = new int[(int) Math.pow(2, getLog2OfArrayLength(sizeOfArr) + 2)];

			readLine = reader.readLine();
			readArray = readLine.split(" ");

			for (int i = 0; i < sizeOfArr; i++) {
				array[i] = Integer.parseInt(readArray[i]);
				tree[i] = array[i];
			}
			
			buildSegmentTree(array, tree, 0, 0, array.length - 1);

			for (int i = 0; i < noOfQueries; i++) {
				readLine = reader.readLine();
				readArray = readLine.split(" ");

				if (readArray[0].equals("q")) {
					System.out.println(queryANodeInSegmentTree(array, tree, 0, 0, sizeOfArr - 1,
							Integer.parseInt(readArray[1]) - 1, Integer.parseInt(readArray[2]) - 1));
				} else {
					updateNodeInSegmentTree(array, tree, 0, 0, sizeOfArr - 1, Integer.parseInt(readArray[1]) - 1,
							Integer.parseInt(readArray[2]));
				}
			}

		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}

	public static void buildSegmentTree(int[] array, int[] tree, int node, int start, int end) {
		if (start == end) {
			// Leaf node will have a single element
			tree[node] = array[start];
		} else {
			int mid = (start + end) / 2;

			// Recurse on the left child
			buildSegmentTree(array, tree, 2 * node + 1, start, mid);

			// Recurse on the right child
			buildSegmentTree(array, tree, 2 * node + 2, mid + 1, end);

			tree[node] = Math.min(tree[2 * node + 1], tree[2 * node + 2]);
		}
	}

	public static void updateNodeInSegmentTree(int[] array, int[] tree, int node, int start, int end, int idx,
			int val) {
		if (start == end) {
			// leaf node
			array[idx] = val;
			tree[node] = val;
		} else {
			int mid = (start + end) / 2;
			if (start <= idx && idx <= mid) {
				// if idx is in the left child, recurse on the left child
				updateNodeInSegmentTree(array, tree, 2 * node + 1, start, mid, idx, val);
			} else {
				// if idx is in the right child, recurse on the right child
				updateNodeInSegmentTree(array, tree, 2 * node + 2, mid + 1, end, idx, val);
			}
			tree[node] = Math.min(tree[2 * node + 1], tree[2 * node + 2]);
		}
	}

	public static int queryANodeInSegmentTree(int[] array, int[] tree, int node, int start, int end, int l, int r) {
		if (r < start || l > end) {
			// range represented by a node is completely outside the given range
			return Integer.MAX_VALUE;
		}

		if (l <= start && r >= end) {
			// range represented by a node is completely inside the given range
			return tree[node];
		}

		int mid = (start + end) / 2;
		int p1 = queryANodeInSegmentTree(array, tree, 2 * node + 1, start, mid, l, r);
		int p2 = queryANodeInSegmentTree(array, tree, 2 * node + 2, mid + 1, end, l, r);

		return Math.min(p1, p2);
	}

	public static int getLog2OfArrayLength(int length) {
		int log2OfLength = 0;
		while (length > 0) {
			log2OfLength++;
			length /= 2;
		}
		return log2OfLength;
	}

}
