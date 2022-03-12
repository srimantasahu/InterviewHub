package com.kvvssut.interviews.dsalgo.datastructure.tree;

import java.util.Stack;

public class FindingPairWithGivenSumInBST {

    public static void main(String[] args) {
        BinaryTree root = createNode(10);
        addLeftChildNode(root, 6);
        addLeftChildNode(root.getLeft(), 4);
        addRightChildNode(root.getLeft(), 7);
        addRightChildNode(root.getLeft().getRight(), 8);
        addRightChildNode(root, 14);
        addLeftChildNode(root.getRight(), 12);
        addRightChildNode(root.getRight(), 15);

        System.out.println(isPairPresent(root, 20));
    }

    private static boolean isPairPresent(BinaryTree root, int key) {
        Stack<BinaryTree> stack1 = new Stack<BinaryTree>();
        Stack<BinaryTree> stack2 = new Stack<BinaryTree>();

        boolean done1 = false, done2 = false;
        int val1 = 0, val2 = 0;
        BinaryTree curr1 = root, curr2 = root;

        while (true) {

            while (done1 == false) {
                if (curr1 != null) {
                    stack1.push(curr1);
                    curr1 = curr1.getLeft();
                } else {
                    if (stack1.isEmpty()) {
                        done1 = true;
                    } else {
                        curr1 = stack1.pop();
                        val1 = curr1.getData();
                        curr1 = curr1.getRight();
                        done1 = true;
                    }
                }
            }

            while (done2 == false) {
                if (curr2 != null) {
                    stack2.push(curr2);
                    curr2 = curr2.getRight();
                } else {
                    if (stack2.isEmpty()) {
                        done2 = true;
                    } else {
                        curr2 = stack2.pop();
                        val2 = curr2.getData();
                        curr2 = curr2.getLeft();
                        done2 = true;
                    }
                }
            }

            if (val1 + val2 == key) {
                System.out.printf("Pair Found :- %d + %d = %d\n", val1, val2, key);
                return true;
            } else if (val1 + val2 < key) {
                done1 = false;
            } else if (val1 + val2 > key) {
                done2 = false;
            }

            if (val1 > val2) {
                return false;
            }

        }
    }

    public static BinaryTree createNode(int data) {
        return new BinaryTree(data, null, null);
    }

    public static void addLeftChildNode(BinaryTree node, int data) {
        BinaryTree newNode = createNode(data);
        node.setLeft(newNode);
    }

    public static void addRightChildNode(BinaryTree node, int data) {
        BinaryTree newNode = createNode(data);
        node.setRight(newNode);
    }

    static class BinaryTree {
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
    }

}
