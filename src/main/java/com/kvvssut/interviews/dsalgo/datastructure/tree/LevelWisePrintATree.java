package com.kvvssut.interviews.dsalgo.datastructure.tree;

public class LevelWisePrintATree {

	public static void main(String[] args) {
		BinaryTree root = createNode(5);
		addLeftChildNode(root, 3);
		addLeftChildNode(root.getLeft(), 1);
		addRightChildNode(root.getLeft(), 4);
		addRightChildNode(root, 9);
		addLeftChildNode(root.getRight(), 6);
		addRightChildNode(root.getRight(), 7);
		addRightChildNode(root.getRight().getRight(), 8);

		System.out.println("Printing of tree nodes -");
		inOrderTraversalOfATree(root);

		System.out.println("\n\nPrinting the tree nodes level wise -");
		levelWiseTraversalOfATree(root);
	}

	/*
	 * In level-wise traversal: Process each node at the same level from left to
	 * right.
	 */
	public static void levelWiseTraversalOfATree(BinaryTree root) {
		int height = heightOfTree(root);
		for (int level = 1; level <= height; level++) {
			printGivenLevelOfATree(root, level);
		}
	}

	public static void printGivenLevelOfATree(BinaryTree root, int level) {
		if (root == null) {
			return;
		} else if (level == 1) {
			System.out.print(root.getData() + "  ");
		} else {
			printGivenLevelOfATree(root.getLeft(), level - 1);
			printGivenLevelOfATree(root.getRight(), level - 1);
		}
	}

	/*
	 * In in-order traversal: Before processing root node, first process left
	 * subtree. Once left subtree is completed, process current root node.
	 * Process right subtree.
	 */
	public static void inOrderTraversalOfATree(BinaryTree root) {
		if (root.getLeft() != null) {
			inOrderTraversalOfATree(root.getLeft());
		}
		System.out.print(root.getData() + "  ");
		if (root.getRight() != null) {
			inOrderTraversalOfATree(root.getRight());
		}
	}

	private static int heightOfTree(BinaryTree node) {
		if (node == null) {
			return 0;
		}

		return (1 + Math.max(heightOfTree(node.getLeft()), heightOfTree(node.getRight())));
	}

	static class BinaryTree {
		private int data;
		private BinaryTree left, right;

		public BinaryTree(int data, BinaryTree left, BinaryTree right) {
			this.data = data;
			this.left = left;
			this.right = right;
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

	public static BinaryTree createNode(int data) {
		return new BinaryTree(data, null, null);
	}

	public static void addLeftChildNode(BinaryTree node, int data) {
		BinaryTree newNode = createNode(data);
		node.setLeft(newNode);
	}

	public static void addRightChildNode(BinaryTree node, int data) {
		BinaryTree newNode = createNode(data);
		node.setRight(newNode);
	}

}
