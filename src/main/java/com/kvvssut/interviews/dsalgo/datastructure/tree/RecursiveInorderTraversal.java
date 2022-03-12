package com.kvvssut.interviews.dsalgo.datastructure.tree;

public class RecursiveInorderTraversal {

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

        inorderTraversal(root);
    }

    private static void inorderTraversal(BinaryTree root) {
        if (root != null) {
            inorderTraversal(root.getLeft());
            System.out.println(root.getData());
            inorderTraversal(root.getRight());
        }
    }

}
