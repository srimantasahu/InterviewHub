package com.kvvssut.interviews.dsalgo.datastructure.tree;

public class BinaryTreeImpl {

	public static void main(String[] args) {
		BinaryTree root = createNode(5);
		addLeftChildNode(root, 3);
		addLeftChildNode(root.getLeft(), 1);
		addRightChildNode(root.getLeft(), 4);
		addRightChildNode(root, 9);
		addLeftChildNode(root.getRight(), 6);
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
