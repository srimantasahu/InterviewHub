package com.kvvssut.interviews.dsalgo.problems;

import java.util.ArrayList;
import java.util.List;

class KthSmallestInBST {

    private static List<Integer> sortedNodes = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4)), new TreeNode(6));

        System.out.println(new KthSmallestInBST().kthSmallest(root, 3));
    }

    public int kthSmallest(TreeNode root, int k) {
        sortedNodes.clear();
        inorderTraversalOfTree(root);
        return sortedNodes.get(k - 1);
    }

    private void inorderTraversalOfTree(TreeNode root) {
        if (root != null) {
            inorderTraversalOfTree(root.left);
            sortedNodes.add(root.val);
            inorderTraversalOfTree(root.right);
        }
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