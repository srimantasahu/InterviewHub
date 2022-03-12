package com.kvvssut.interviews.dsalgo.datastructure.tree;

/*
 * Segment Tree is used in cases where there are multiple range queries on
 * array and modifications of elements of the same array. For example,
 * finding the sum of all the elements in an array from indices L to R, or
 * finding the minimum (famously known as Range Minimum Query problem) of
 * all the elements in an array from indices L to R.
 *
 * Segment Tree is a basically a binary tree used for storing the intervals
 * or segments. Each node in the Segment Tree represents an interval.
 *
 * Once the Segment Tree is built, its structure cannot be changed. We can
 * update the values of nodes but we cannot change its structure. Segment
 * tree provides two operations:
 *
 * Update: To update the element of the array A and reflect the
 * corresponding change in the Segment tree.
 *
 * Query: In this operation we can query on an interval or segment and
 * return the answer to the problem (say minimum/maximum/summation in the
 * particular segment).
 */
public class SegmentTreesImpl {

    public static void main(String[] args) {

        int[] array = {1, 3, 5, 7, 9, 11};

        int[] tree = new int[(int) Math.pow(2, getLog2OfArrayLength(array.length) + 2)];

        for (int i = 0; i < array.length; i++) {
            tree[i] = array[i];
        }

        buildSegmentTree(array, tree, 0, 0, array.length - 1);

        System.out.println(queryANodeInSegmentTree(array, tree, 0, 0, array.length - 1, 1, 3));    // 15

        updateNodeInSegmentTree(array, tree, 0, 0, array.length - 1, 2, 8);

        System.out.println(queryANodeInSegmentTree(array, tree, 0, 0, array.length - 1, 1, 3));    // 15 + 8 = 23
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

            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }

    public static void updateNodeInSegmentTree(int[] array, int[] tree, int node, int start, int end, int idx,
                                               int val) {
        if (start == end) {
            // leaf node
            array[idx] += val;
            tree[node] += val;
        } else {
            int mid = (start + end) / 2;
            if (start <= idx && idx <= mid) {
                // if idx is in the left child, recurse on the left child
                updateNodeInSegmentTree(array, tree, 2 * node + 1, start, mid, idx, val);
            } else {
                // if idx is in the right child, recurse on the right child
                updateNodeInSegmentTree(array, tree, 2 * node + 2, mid + 1, end, idx, val);
            }
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }

    public static int queryANodeInSegmentTree(int[] array, int[] tree, int node, int start, int end, int l, int r) {
        if (r < start || l > end) {
            // range represented by a node is completely outside the given range
            return 0;
        }

        if (l <= start && r >= end) {
            // range represented by a node is completely inside the given range
            return tree[node];
        }

        int mid = (start + end) / 2;
        int p1 = queryANodeInSegmentTree(array, tree, 2 * node + 1, start, mid, l, r);
        int p2 = queryANodeInSegmentTree(array, tree, 2 * node + 2, mid + 1, end, l, r);

        return (p1 + p2);
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
