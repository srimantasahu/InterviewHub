package com.kvvssut.interviews.dsalgo.datastructure.tree;

public class RecursiveLevelorderTraversal {

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

        levelorderTraversal(root);
    }

    // https://www.geeksforgeeks.org/level-order-tree-traversal/
    private static void levelorderTraversal(BinaryTree root) {
        final int heightOfTree = heightOfTree(root);

        for (int level = 1; level <= heightOfTree; level++) {
            printNodesAtLevel(root, level);
        }
    }

    private static void printNodesAtLevel(BinaryTree root, int level) {
        if (level == 1) {
            System.out.println(root.getData());
            return;
        } else {
            printNodesAtLevel(root.getLeft(), level - 1);
            printNodesAtLevel(root.getRight(), level - 1);
        }
    }

    private static int heightOfTree(BinaryTree root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(heightOfTree(root.getLeft()), heightOfTree(root.getRight()));
    }

}
