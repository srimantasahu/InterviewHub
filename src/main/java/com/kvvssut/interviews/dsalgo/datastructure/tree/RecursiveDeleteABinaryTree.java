package com.kvvssut.interviews.dsalgo.datastructure.tree;

public class RecursiveDeleteABinaryTree {

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

        deleteTree(root);
    }

    private static void deleteTree(BinaryTree root) {
        if (root != null) {
            deleteSubTrees(root);

            System.out.println("Deleted root : " + root.getData());
            root = null;
        }
    }

    private static void deleteSubTrees(BinaryTree node) {
        if (node == null) {
            return;
        }

        deleteSubTrees(node.getLeft());

        deleteSubTrees(node.getRight());

        deleteChildNodes(node);
    }

    private static void deleteChildNodes(BinaryTree node) {
        if (node.getLeft() != null) {
            node.setLeft(null);
            System.out.println("Deleted left child of : " + node.getData());
        }
        if (node.getRight() != null) {
            node.setRight(null);
            System.out.println("Deleted right child of : " + node.getData());
        }
    }

}
