package com.kvvssut.interviews.dsalgo.datastructure.tree;

import java.util.Stack;

public class InOrderTraversalOfABinaryTreeUsingStack {

    public static void main(String[] args) {
        BinaryTree root = createNode(10);
        addLeftChildNode(root, 5);
        addLeftChildNode(root.getLeft(), 1);
        addRightChildNode(root.getLeft(), 6);
        addRightChildNode(root, 19);
        addLeftChildNode(root.getRight(), 17);
        addLeftChildNode(root.getRight().getLeft(), 15);

        inOrderTraversalUsingStack(root);
    }

    public static void inOrderTraversalUsingStack(BinaryTree root) {
        Stack<BinaryTree> stack = new Stack<BinaryTree>();
        BinaryTree node = root;

        // first node to be visited will be the left one
        while (node != null) {
            stack.push(node);
            node = node.getLeft();
        }

        // traverse the tree
        while (!stack.isEmpty()) {
            // visit the top node
            node = stack.pop();
            System.out.println(node.getData() + "  ");

            if (node.getRight() != null) {
                node = node.getRight();

                // the next node to be visited is the leftmost
                while (node != null) {
                    stack.push(node);
                    node = node.getLeft();
                }
            }
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

}
