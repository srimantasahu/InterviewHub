package com.kvvssut.interviews.dsalgo.datastructure.tree;

public class MirrorOfATree {

    public static void main(String[] args) {
        BinaryTree root = createNode(5);
        addLeftChildNode(root, 3);
        addLeftChildNode(root.getLeft(), 1);
        addRightChildNode(root.getLeft(), 4);
        addRightChildNode(root, 9);
        addLeftChildNode(root.getRight(), 6);
        addRightChildNode(root.getRight(), 7);
        addRightChildNode(root.getRight().getRight(), 8);

        System.out.println("\n\nPrinting of tree nodes -");
        inOrderTraversalOfATree(root);

        mirrorBinaryTree(root);

        System.out.println("\n\nPrinting after mirroring of tree nodes -");
        inOrderTraversalOfATree(root);
    }

    /*
     * (1) Call Mirror for left-subtree i.e., Mirror(left-subtree) (2) Call
     * Mirror for right-subtree i.e., Mirror(right-subtree) (3) Swap left and
     * right subtrees.
     */
    public static void mirrorBinaryTree(BinaryTree root) {
        if (root.getLeft() != null) {
            mirrorBinaryTree(root.getLeft());
        }
        if (root.getRight() != null) {
            mirrorBinaryTree(root.getRight());
        }
        swapLeftAndRightNodes(root, root.getLeft(), root.getRight());
    }

    private static void swapLeftAndRightNodes(BinaryTree root, BinaryTree left, BinaryTree right) {
        root.setLeft(right);
        root.setRight(left);
    }

    /*
     * In in-order traversal: Before processing root node, first process left
     * subtree. Once left subtree is completed, process current root node.
     * Process right subtree.
     */
    public static void inOrderTraversalOfATree(BinaryTree root) {
        if (root.getLeft() != null) {
            inOrderTraversalOfATree(root.getLeft());
        }
        System.out.print(root.getData() + "  ");
        if (root.getRight() != null) {
            inOrderTraversalOfATree(root.getRight());
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
