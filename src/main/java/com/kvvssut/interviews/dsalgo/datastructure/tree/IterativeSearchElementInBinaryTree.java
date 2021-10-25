package com.kvvssut.interviews.dsalgo.datastructure.tree;

import java.util.Stack;

public class IterativeSearchElementInBinaryTree {
	
	static class BinaryTree {
		private int data;
		private BinaryTree left, right;

		public BinaryTree(int data) {
			this.data = data;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public BinaryTree getLeft() {
			return left;
		}

		public void setLeft(BinaryTree left) {
			this.left = left;
		}

		public BinaryTree getRight() {
			return right;
		}

		public void setRight(BinaryTree right) {
			this.right = right;
		}
		
	}

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

		final boolean maxValue = findElement(root, 5);

		System.out.println(maxValue);
	}

	// https://www.geeksforgeeks.org/iterative-search-for-a-key-x-in-binary-tree/
	private static boolean findElement(BinaryTree root, int searchVal) {
		boolean found = false;

		if (root != null) {
			final Stack<BinaryTree> stack = new Stack<>();

			BinaryTree currentNode = root;
			stack.push(currentNode);

			while (!stack.isEmpty()) {
				currentNode = stack.pop();

				if (currentNode.getData() == searchVal) {
					found = true;
					break;
				}

				if (currentNode.getRight() != null) {
					stack.push(currentNode.getRight());
				}

				if (currentNode.getLeft() != null) {
					stack.push(currentNode.getLeft());
				}
			}
		}

		return found;
	}

}
