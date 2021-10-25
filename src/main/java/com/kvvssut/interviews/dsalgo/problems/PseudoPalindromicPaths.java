package com.kvvssut.interviews.dsalgo.problems;

public class PseudoPalindromicPaths {

    private static int[] nodeCnt;
    private static int count;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2, new TreeNode(1, new TreeNode(1), new TreeNode(3, null, new TreeNode(1))), new TreeNode(1, new TreeNode(1), null));

        System.out.println(new PseudoPalindromicPaths().pseudoPalindromicPaths(root));
    }

    public int pseudoPalindromicPaths(TreeNode root) {
        nodeCnt = new int[10];
        count = 0;
        pseudoPalindromicPathsRec(root);
        return count;
    }

    public void pseudoPalindromicPathsRec(TreeNode root) {
        if (root != null) {
            nodeCnt[root.val]++;
            if (root.left != null && root.right != null) {
                pseudoPalindromicPathsRec(root.left);
                pseudoPalindromicPathsRec(root.right);
            } else if (root.left != null) {
                pseudoPalindromicPathsRec(root.left);
            } else if (root.right != null) {
                pseudoPalindromicPathsRec(root.right);
            } else {
                int odds = 0;
                for (int i = 1; i < 10; i++) {
                    if (nodeCnt[i] % 2 == 1) {
                        odds++;
                    }
                }
                if (odds <= 1) {
                    count++;
                }
            }
            nodeCnt[root.val]--;
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
