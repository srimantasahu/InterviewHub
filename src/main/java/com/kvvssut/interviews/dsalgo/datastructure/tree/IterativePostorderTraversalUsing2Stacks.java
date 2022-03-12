package com.kvvssut.interviews.dsalgo.datastructure.tree;

import java.util.Stack;

public class IterativePostorderTraversalUsing2Stacks {

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

        postorderTraversal(root);
    }

    // https://www.geeksforgeeks.org/iterative-postorder-traversal/
    private static void postorderTraversal(BinaryTree root) {
        if (root == null) {
            return;
        }

        final Stack<BinaryTree> firstStack = new Stack<>();
        final Stack<BinaryTree> secondStack = new Stack<>();

        BinaryTree currentNode = root;
        firstStack.push(currentNode);

        while (!firstStack.isEmpty()) {
            currentNode = firstStack.pop();

            secondStack.push(currentNode);

            if (currentNode.getLeft() != null) {
                firstStack.push(currentNode.getLeft());
            }
            if (currentNode.getRight() != null) {
                firstStack.push(currentNode.getRight());
            }
        }

        while (!secondStack.isEmpty()) {
            currentNode = secondStack.pop();
            System.out.println(currentNode.getData());
        }
    }

}
