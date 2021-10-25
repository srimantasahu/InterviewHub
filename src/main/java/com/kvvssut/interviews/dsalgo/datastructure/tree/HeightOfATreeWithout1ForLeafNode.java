package com.kvvssut.interviews.dsalgo.datastructure.tree;

public class HeightOfATreeWithout1ForLeafNode {

	public static void main(String[] args) {
		BinaryTree root = createNode(5);
		addLeftChildNode(root, 3);
		addLeftChildNode(root.getLeft(), 1);
		addRightChildNode(root.getLeft(), 4);
		addRightChildNode(root, 9);
		addLeftChildNode(root.getRight(), 6);

		System.out.println(heightOfABinaryTree(root));
	}

	static int heightOfABinaryTree(BinaryTree root) {
		if (root == null || isLeafNode(root)) {
			return 0;
		}
		return (1 + Math.max(heightOfABinaryTree(root.getLeft()), heightOfABinaryTree(root.getRight())));
	}

	static boolean isLeafNode(BinaryTree node) {
		return (node.getLeft() == null) && (node.getRight() == null);
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
