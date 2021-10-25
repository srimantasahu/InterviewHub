package com.kvvssut.interviews.dsalgo.problems;

import java.util.Stack;

class BSTFromPreorder {

    private int index = 0;

    public static void main(String[] args) {
        System.out.println(new BSTFromPreorder().bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12}));
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorderRecursive(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode bstFromPreorderRecursive(int[] preorder, int min, int max) {
        if (index == preorder.length) {
            return null;
        }

        int val = preorder[index];
        if (val < min || val > max) {
            return null;
        }

        index++;

        TreeNode node = new TreeNode(val);
        node.left = bstFromPreorderRecursive(preorder, min, val);
        node.right = bstFromPreorderRecursive(preorder, val, max);

        return node;
    }

    public TreeNode bstFromPreorderIterative(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        TreeNode lastNode = null;

        for (int i = 1; i < preorder.length; i++) {
            TreeNode newNode = new TreeNode(preorder[i]);

            if (preorder[i] > stack.peek().val) {
                while (!stack.isEmpty() && preorder[i] > stack.peek().val) {
                    lastNode = stack.pop();
                }
                lastNode.right = newNode;
            } else {
                stack.peek().left = newNode;
            }

            stack.add(newNode);
        }

        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}