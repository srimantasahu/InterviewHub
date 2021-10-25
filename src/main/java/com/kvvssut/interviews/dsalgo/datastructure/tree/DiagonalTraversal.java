package com.kvvssut.interviews.dsalgo.datastructure.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DiagonalTraversal {

	private static Map<Integer, List<Integer>> slopeMap = new TreeMap<>();

	public static void main(String[] args) {
		final BinaryTree root = new BinaryTree(1);
		final BinaryTree l1 = new BinaryTree(2);
		final BinaryTree r1 = new BinaryTree(3);
		final BinaryTree ll2 = new BinaryTree(4);
		final BinaryTree lr2 = new BinaryTree(5);
		final BinaryTree rl2 = new BinaryTree(6);
		final BinaryTree rr2 = new BinaryTree(7);

		root.setLeft(l1);
		root.setRight(r1);
		l1.setLeft(ll2);
		l1.setRight(lr2);
		r1.setLeft(rl2);
		r1.setRight(rr2);

		diagonalTraversal(0, root);

		for (Integer slope : slopeMap.keySet()) {
			System.out.println(slopeMap.get(slope));
		}
	}

	// https://www.geeksforgeeks.org/diagonal-traversal-of-binary-tree/
	private static void diagonalTraversal(int slope, BinaryTree root) {
		if (root == null) {
			return;
		} else {
			addToMap(slope, root.getData());
		}

		if (root.getLeft() != null) {
			diagonalTraversal(slope + 1, root.getLeft());
		}
		if (root.getRight() != null) {
			diagonalTraversal(slope, root.getRight());
		}
	}

	private static void addToMap(int slope, int data) {
		List<Integer> list = slopeMap.get(slope);

		if (list == null) {
			list = new ArrayList<>();
			slopeMap.put(slope, list);
		}

		list.add(data);
	}

}
