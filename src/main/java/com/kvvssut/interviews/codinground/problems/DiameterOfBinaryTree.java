package com.kvvssut.interviews.codinground.problems;

/*
Given the root of a binary tree, return the length of the diameter of the tree.
The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
The length of a path between two nodes is represented by the number of edges between them.

Example 1:
Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].

Example 2:
Input: root = [1,2]
Output: 1

Constraints:
The number of nodes in the tree is in the range [1, 104].
-100 <= Node.val <= 100
 */
public class DiameterOfBinaryTree {
    private int diameter = 0; // Global variable to track maximum diameter

    public static void main(String[] args) {
        DiameterOfBinaryTree obj = new DiameterOfBinaryTree();

        // Example 1: root = [1,2,3,4,5]
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        System.out.println("Diameter (Example 1): " + obj.diameterOfBinaryTree(root1));
        // Expected: 3 (path 4 -> 2 -> 1 -> 3 or 5 -> 2 -> 1 -> 3)

        // Example 2: root = [1,2]
        DiameterOfBinaryTree obj2 = new DiameterOfBinaryTree(); // reset diameter
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        System.out.println("Diameter (Example 2): " + obj2.diameterOfBinaryTree(root2));
        // Expected: 1 (path 1 -> 2)
    }

    /**
     * Returns the diameter of the binary tree.
     * The diameter is the longest path (in terms of edges) between any two nodes.
     */
    public int diameterOfBinaryTree(TreeNode root) {
        heightOfBinaryTree(root);
        return diameter;
    }

    /**
     * Helper function to compute the height of a node.
     * While computing height, it also updates the global diameter.
     */
    private int heightOfBinaryTree(TreeNode node) {
        if (node == null) return 0;

        // Recursively compute left and right subtree heights
        int leftHeight = heightOfBinaryTree(node.left);
        int rightHeight = heightOfBinaryTree(node.right);

        // Diameter passing through this node = left height + right height
        diameter = Math.max(diameter, leftHeight + rightHeight);

        // Return height of this node
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}