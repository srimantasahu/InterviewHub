package com.kvvssut.interviews.problemsolving.easy;

import com.kvvssut.interviews.problemsolving.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
*/

public class Tree_LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root != null) {
            Queue<TreeNode> queue = new LinkedList();
            queue.add(root);

            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> list = new ArrayList<>();

                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.remove();
                    list.add(node.val);

                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }

                result.add(list);
            }
        }

        return result;
    }

}
