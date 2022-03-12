package com.kvvssut.interviews.dsalgo.datastructure.tree;

import java.io.IOException;
import java.util.Scanner;

public class CreateBST {

    public static void main(String[] args) throws IOException {
        Scanner scanner = null;
        BinaryTree root = null;
        int inputElement = -1;
        try {
            scanner = new Scanner(System.in);
            int noOfEle = scanner.nextInt();
            scanner.nextLine();
            String input = scanner.nextLine();
            String[] inputArr = input.split(" ");

            root = createNode(Integer.parseInt(inputArr[0]));
            for (int i = 1; i < noOfEle; i++) {
                insertElementInBST(root, Integer.parseInt(inputArr[i]));
            }

            inputElement = scanner.nextInt();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        root = getNodeByElementInBST(root, inputElement);
        preOrderTraversalBST(root);

    }

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

    public static BinaryTree getNodeByElementInBST(BinaryTree root, int element) {
        if (element == root.getData()) {
            return root;
        } else if (element < root.getData()) {
            if (root.getLeft() != null) {
                return getNodeByElementInBST(root.getLeft(), element);
            }
        } else if (element > root.getData()) {
            if (root.getRight() != null) {
                return getNodeByElementInBST(root.getRight(), element);
            }
        }
        return null;
    }

    public static void preOrderTraversalBST(BinaryTree root) {
        System.out.println(root.getData());
        if (root.getLeft() != null) {
            preOrderTraversalBST(root.getLeft());
        }
        if (root.getRight() != null) {
            preOrderTraversalBST(root.getRight());
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
