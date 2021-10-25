package com.kvvssut.interviews.dsalgo.datastructure.tree;

import java.util.Stack;

public class IterativePostorderTraversalUsing1Stack {

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

		postorderTraversal(root);
	}

	// https://www.geeksforgeeks.org/iterative-postorder-traversal-using-stack/
	private static void postorderTraversal(BinaryTree root) {
		final Stack<BinaryTree> stack = new Stack<>();
		BinaryTree currentNode = root;

		while (true) {
			while (currentNode != null) {
				if (currentNode.getRight() != null) {
					stack.push(currentNode.getRight());
				}

				stack.push(currentNode);

				currentNode = currentNode.getLeft();
			}

			if (stack.isEmpty()) {
				return;
			}

			currentNode = stack.pop();

			if (!stack.isEmpty() && currentNode.getRight() == stack.peek()) {
				BinaryTree rightNode = stack.pop();

				stack.push(currentNode);

				currentNode = rightNode;
			} else {
				System.out.println(currentNode.getData());

				currentNode = null;
			}

		}
	}

}
