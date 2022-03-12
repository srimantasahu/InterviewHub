package com.kvvssut.interviews.dsalgo.datastructure.tree;

public class RecursiveReverseLevelorderTraversal {

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

        reverseLevelorderTraversal(root);
    }

    private static void reverseLevelorderTraversal(BinaryTree root) {
        if (root != null) {
            final int sizeOfTree = sizeOfBinaryTree(root);

            for (int level = sizeOfTree - 1; level >= 0; level--) {
                printNodesAtLevel(root, level);
            }
        }
    }

    private static void printNodesAtLevel(BinaryTree root, int level) {
        if (root == null) {
            return;
        }

        if (level == 0) {
            System.out.println(root.getData());
        }

        printNodesAtLevel(root.getLeft(), level - 1);

        printNodesAtLevel(root.getRight(), level - 1);
    }

    private static int sizeOfBinaryTree(BinaryTree root) {
        if (root == null) {
            return 0;
        }

        return sizeOfBinaryTree(root.getLeft()) + 1 + sizeOfBinaryTree(root.getRight());
    }

}
