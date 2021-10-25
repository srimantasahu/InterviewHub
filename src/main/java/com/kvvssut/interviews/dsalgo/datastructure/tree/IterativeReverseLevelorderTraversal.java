package com.kvvssut.interviews.dsalgo.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IterativeReverseLevelorderTraversal {

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

		reverseLevelorderTraversal(root);
	}

	private static void reverseLevelorderTraversal(BinaryTree root) {
		if (root != null) {
			final Queue<BinaryTree> queue = new LinkedList<>();
			final Stack<BinaryTree> stack = new Stack<>();

			BinaryTree currentNode = root;
			queue.add(currentNode);

			while (!queue.isEmpty()) {
				currentNode = queue.remove();

				if (currentNode.getRight() != null) {
					queue.add(currentNode.getRight());
				}

				if (currentNode.getLeft() != null) {
					queue.add(currentNode.getLeft());
				}

				stack.push(currentNode);
			}

			while (!stack.isEmpty()) {
				currentNode = stack.pop();

				System.out.println(currentNode.getData());
			}
		}
	}

}
