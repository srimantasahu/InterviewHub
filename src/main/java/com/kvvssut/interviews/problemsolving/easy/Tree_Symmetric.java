package com.kvvssut.interviews.problemsolving.easy;

import com.kvvssut.interviews.problemsolving.TreeNode;

/*
    Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

    Input: root = [1,2,2,3,4,4,3]
    Output: true
*/

public class Tree_Symmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetricNodes(root.left, root.right);
    }

    public boolean isSymmetricNodes(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        } else if (node1.val != node2.val) {
            return false;
        }

        return isSymmetricNodes(node1.left, node2.right) && isSymmetricNodes(node1.right, node2.left);
    }

}
