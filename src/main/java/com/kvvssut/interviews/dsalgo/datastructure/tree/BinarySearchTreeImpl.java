package com.kvvssut.interviews.dsalgo.datastructure.tree;

import static com.kvvssut.interviews.dsalgo.datastructure.tree.BinaryTreeImpl.addLeftChildNode;
import static com.kvvssut.interviews.dsalgo.datastructure.tree.BinaryTreeImpl.addRightChildNode;
import static com.kvvssut.interviews.dsalgo.datastructure.tree.BinaryTreeImpl.createNode;

/*
 * For a Binary Tree to be a Binary Search tree, the data of all nodes in the left subtree of the root node should be less than or equal to (<=) the data of the root 
 * and the data of all nodes in the right subtree of the root node should be greater than (>) the data of the root.
 */
public class BinarySearchTreeImpl {

	public static void main(String[] args) {
		BinaryTree root = createNode(10);
		addLeftChildNode(root, 5);
		addLeftChildNode(root.getLeft(), 1);
		addRightChildNode(root.getLeft(), 6);
		addRightChildNode(root, 19);
		addLeftChildNode(root.getRight(), 17);

		// System.out.println("Pre-Order traversal of binary search tree -");
		// preOrderTraversalBST(root);

		// System.out.println("\nIn-Order traversal of binary search tree - ");
		// inOrderTraversalBST(root);

		// System.out.println("\nPost-Order traversal of binary search tree -
		// ");
		// postOrderTraversalBST(root);

		insertElementInBST(root, 20);
		System.out.println("Inserted element \"20\" into binary search tree. ");
		System.out.println("In-Order traversal of binary search tree is -");
		inOrderTraversalBST(root);

		insertElementInBST(root, 9);
		System.out.println("Inserting element \"9\" into binary search tree. ");
		System.out.println("In-Order traversal of binary search tree is -");
		inOrderTraversalBST(root);

	}

	/*
	 * Pre-order traversal follows the following strategy :- Process data of root
	 * node. Traverse left subtree completely first. Then traverse right subtree.
	 */
	public static void preOrderTraversalBST(BinaryTree root) {
		System.out.println(root.getData());
		if (root.getLeft() != null) {
			preOrderTraversalBST(root.getLeft());
		}
		if (root.getRight() != null) {
			preOrderTraversalBST(root.getRight());
		}
	}

	/*
	 * In in-order traversal: Before processing root node, first process left
	 * subtree. Once left subtree is completed, process current root node. Process
	 * right subtree.
	 */
	public static void inOrderTraversalBST(BinaryTree root) {
		if (root.getLeft() != null) {
			inOrderTraversalBST(root.getLeft());
		}
		System.out.println(root.getData());
		if (root.getRight() != null) {
			inOrderTraversalBST(root.getRight());
		}
	}

	/*
	 * In post-order traversal: The root node is processed last, first process left
	 * subtree. Once left subtree is completed, process right subtree. Process the
	 * current root node.
	 */
	public static void postOrderTraversalBST(BinaryTree root) {
		if (root.getLeft() != null) {
			postOrderTraversalBST(root.getLeft());
		}
		if (root.getRight() != null) {
			postOrderTraversalBST(root.getRight());
		}
		System.out.println(root.getData());
	}

	/*
	 * Compare data of root node and element to be inserted.
	 * 
	 * If data of root node is greater, 1a. If left subtree exists, repeat step 1
	 * with root = root of left subtree. 1b. Else, insert element as left child of
	 * current root. Else, 2a. If right subtree exists, repeat step 2 with root =
	 * root of right subtree. 2b. Else, insert element as right child of current
	 * root.
	 */
	public static void insertElementInBST(BinaryTree root, int element) {
		if (element <= root.getData()) {
			if (root.getLeft() != null) {
				insertElementInBST(root.getLeft(), element);
			} else {
				addLeftChildNode(root, element);
			}
		} else {
			if (root.getRight() != null) {
				insertElementInBST(root.getRight(), element);
			} else {
				addRightChildNode(root, element);
			}
		}
	}
}
