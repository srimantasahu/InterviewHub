package com.kvvssut.interviews.dsalgo.datastructure.tree;

public class KthElementFromEndOfBinaryTree {

	public static void main(String[] args) {
		BinaryTree root = createNode(10);
		addLeftChildNode(root, 5);
		addLeftChildNode(root.getLeft(), 1);
		addRightChildNode(root.getLeft(), 6);
		addRightChildNode(root, 19);
		addLeftChildNode(root.getRight(), 17);
		addLeftChildNode(root.getRight().getLeft(), 15);

		System.out.println(getKthElementFromEndOfBinaryTree(null, root, 4, false));
	}

	private static int getKthElementFromEndOfBinaryTree(BinaryTree prev, BinaryTree node, int k, boolean reachedEnd) {

		if (k == 0) {
			return node.getData();
		}

		if (node.getRight() == null && node.getLeft() == null) {
			reachedEnd = true;
		}
		
		if (reachedEnd) {
			k--;
		}

		if (node.getRight() != null) {
			return getKthElementFromEndOfBinaryTree(node, node.getRight(), k, reachedEnd);
		}

		if (node.getLeft() != null) {
			return getKthElementFromEndOfBinaryTree(node, node.getLeft(), k, reachedEnd);
		}

		return 0;
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
