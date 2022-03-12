package com.kvvssut.interviews.dsalgo.datastructure.tree;

public class BoundaryTraversal {

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

        boundaryTraversal(root);
    }

    // https://articles.leetcode.com/print-edge-nodes-boundary-of-binary/
    private static void boundaryTraversal(BinaryTree root) {
        if (root != null) {
            System.out.println(root.getData());
        }

        printLeftBoundaryInTopDownOrder(root.getLeft());

        printLeafNodesInLeftToRightOrder(root.getLeft());
        printLeafNodesInLeftToRightOrder(root.getRight());

        printRightBoundaryInBottomUpOrder(root.getRight());
    }

    private static void printLeftBoundaryInTopDownOrder(BinaryTree root) {
        if (root == null || isLeafNode(root)) {
            return;
        }

        System.out.println(root.getData());

        printLeftBoundaryInTopDownOrder(root.getLeft());
    }

    private static void printLeafNodesInLeftToRightOrder(BinaryTree root) {
        if (root == null) {
            return;
        }

        if (isLeafNode(root)) {
            System.out.println(root.getData());
            return;
        }

        printLeafNodesInLeftToRightOrder(root.getLeft());

        printLeafNodesInLeftToRightOrder(root.getRight());
    }

    private static void printRightBoundaryInBottomUpOrder(BinaryTree root) {
        if (root == null || isLeafNode(root)) {
            return;
        }

        printRightBoundaryInBottomUpOrder(root.getRight());

        System.out.println(root.getData());
    }

    private static boolean isLeafNode(BinaryTree root) {
        return root.getLeft() == null && root.getRight() == null;
    }

}
