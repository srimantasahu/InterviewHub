package com.kvvssut.interviews.problemsolving.easy;

import com.kvvssut.interviews.problemsolving.TreeNode;

/*
    Given the root of a binary tree, determine if it is a valid binary search tree (BST).

    A valid BST is defined as follows:

        The left subtree of a node contains only nodes with keys less than the node's key.
        The right subtree of a node contains only nodes with keys greater than the node's key.
        Both the left and right subtrees must also be binary search trees.
*/

public class Tree_ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }

        if (node.left != null) {
            if (node.left.val >= node.val || node.left.val <= min) {
                return false;
            }
        }

        if (node.right != null) {
            if (node.right.val <= node.val || node.right.val >= max) {
                return false;
            }
        }

        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }

}
