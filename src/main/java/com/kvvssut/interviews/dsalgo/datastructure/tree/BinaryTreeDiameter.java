package com.kvvssut.interviews.dsalgo.datastructure.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinaryTreeDiameter {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] inputs = line.split(" ");
        int noOfTestCases = Integer.parseInt(inputs[0]) - 1;
        BinaryTree root = createNode(Integer.parseInt(inputs[1]));

        for (int i = 0; i < noOfTestCases; i++) {
            line = br.readLine();
            char paths[] = line.toCharArray();
            int pathsLength = paths.length;
            BinaryTree currentNode = root;
            for (int j = 0; j < pathsLength; j++) {
                if (j + 1 == pathsLength) {
                    if (paths[j] == 'L') {
                        addLeftChildNode(currentNode, Integer.parseInt(br.readLine()));
                    } else {
                        addRightChildNode(currentNode, Integer.parseInt(br.readLine()));
                    }
                } else {
                    if (paths[j] == 'L') {
                        currentNode = currentNode.getLeftNode();
                    } else {
                        currentNode = currentNode.getRightNode();
                    }
                }
            }
        }

        System.out.println(diameterOfTree(root));
    }

    private static int diameterOfTree(BinaryTree node) {
        if (node == null) {
            return 0;
        }

        int lHeight = heightOfTree(node.getLeft());
        int rHeight = heightOfTree(node.getRight());

        int lDiameter = diameterOfTree(node.getLeft());
        int rDiameter = diameterOfTree(node.getRight());

        return Math.max(1 + lHeight + rHeight, Math.max(lDiameter, rDiameter));
    }

    private static int heightOfTree(BinaryTree node) {
        if (node == null) {
            return 0;
        }

        return (1 + Math.max(heightOfTree(node.getLeft()), heightOfTree(node.getRight())));
    }

    public static BinaryTree createNode(int data) {
        return new BinaryTreeDiameter().new BinaryTree(data, null, null);
    }

    private static void addLeftChildNode(BinaryTree node, int data) {
        if (node.getLeft() != null) {
            node.getLeft().setData(data);
        } else {
            BinaryTree newNode = createNode(data);
            node.setLeft(newNode);
        }
    }

    private static void addRightChildNode(BinaryTree node, int data) {
        if (node.getRight() != null) {
            node.getRight().setData(data);
        } else {
            BinaryTree newNode = createNode(data);
            node.setRight(newNode);
        }
    }

    final class BinaryTree {
        private int data;
        private BinaryTree left, right;

        public BinaryTree(int data, BinaryTree left, BinaryTree right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public BinaryTree getLeft() {
            return left;
        }

        public void setLeft(BinaryTree left) {
            this.left = left;
        }

        public BinaryTree getRight() {
            return right;
        }

        public void setRight(BinaryTree right) {
            this.right = right;
        }

        public BinaryTree getLeftNode() {
            if (this.getLeft() == null) {
                this.setLeft(new BinaryTree(0, null, null));
            }
            return left;
        }

        public BinaryTree getRightNode() {
            if (this.getRight() == null) {
                this.setRight(new BinaryTree(0, null, null));
            }
            return right;
        }

    }

}
