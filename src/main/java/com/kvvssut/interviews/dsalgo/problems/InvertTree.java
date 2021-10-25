package com.kvvssut.interviews.dsalgo.problems;


class InvertTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7, new TreeNode(6), new TreeNode(9)));

        System.out.println(new InvertTree().invertTree(root));
    }

    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = invertTree(right);
            root.right = invertTree(left);
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