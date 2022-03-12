package com.kvvssut.interviews.dsalgo.problems;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class ParentDepth {

    int parent;
    int depth;

    ParentDepth(int parent, int depth) {
        this.parent = parent;
        this.depth = depth;
    }
}


class CousinsInATreeCousinNodes {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3, new TreeNode(5, new TreeNode(7, null, null), null), new TreeNode(6, new TreeNode(8, null, new TreeNode(9)), null)));

        System.out.println(isCousins(root, 1, 9));
    }

    public static boolean isCousins(TreeNode root, int x, int y) {
        ParentDepth pdx = getParentAndDepth(root, x, 0);
        if (pdx == null) {
            return false;
        }

        ParentDepth pdy = getParentAndDepth(root, y, 0);
        if (pdy == null) {
            return false;
        }

        return pdx.depth == pdy.depth && pdx.parent != pdy.parent;
    }

    private static ParentDepth getParentAndDepth(TreeNode node, int ele, int depth) {
        if (node != null) {
            if (node.left != null && node.left.val == ele || node.right != null && node.right.val == ele) {
                return new ParentDepth(node.val, depth);
            }

            ParentDepth pd = getParentAndDepth(node.left, ele, depth + 1);
            if (pd != null) {
                return pd;
            } else {
                return getParentAndDepth(node.right, ele, depth + 1);
            }
        }

        return null;
    }
}

