package com.kvvssut.interviews.dsalgo.datastructure.tree;

public class RecursiveDeleteElementInBinaryTree_undone {

	public static int maxLevel = -1;

	public static BinaryTree searchNode = null;
	public static BinaryTree deepestNode = null;

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

		System.out.print("Before deletion: ");
		printTree(root);

		System.out.println("\n\nDeleting element with data: " + l1.getData());

		deleteElement(root, l1);

		System.out.print("\n After deletion: ");
		printTree(root);
	}

	private static void deleteElement(BinaryTree root, BinaryTree node) {

		findElement(root, node);

		if (searchNode != null) {
			findDeepestElement(root, 0);

			deleteDeepestElement(root, deepestNode);

			searchNode.setData(deepestNode.getData());
		} else {
			System.out.println("\n\nElement " + node.getData() + " doesn't exist!");
		}

	}

	private static void findElement(BinaryTree root, BinaryTree node) {

		if (root != null) {
			if (root.getData() == node.getData()) {
				searchNode = root;
				return;
			}

			if (root.getLeft() != null) {
				findElement(root.getLeft(), node);
			}

			if (root.getRight() != null) {
				findElement(root.getRight(), node);
			}
		}

	}

	private static void findDeepestElement(BinaryTree root, int level) {

		if (root != null) {
			findDeepestElement(root.getLeft(), level + 1);

			if (level >= maxLevel) {
				deepestNode = root;
				maxLevel = level;
			}

			findDeepestElement(root.getRight(), level + 1);
		}
	}

	private static void deleteDeepestElement(BinaryTree root, BinaryTree node) {

		if (root != null) {
			boolean deleted = false;

			if (root.getLeft() != null) {
				if (root.getLeft().getData() == node.getData()) {
					root.setLeft(null);
					deleted = true;
				} else {
					deleteDeepestElement(root.getLeft(), node);
				}
			}

			if (!deleted && root.getRight() != null) {
				if (root.getRight().getData() == node.getData()) {
					root.setRight(null);
				} else {
					deleteDeepestElement(root.getRight(), node);
				}
			}
		}
	}

	private static void printTree(BinaryTree root) {
		if (root != null) {
			printTree(root.getLeft());

			System.out.print(String.format("%3d", root.getData()));

			printTree(root.getRight());
		}
	}

}
