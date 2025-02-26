package com.kvvssut.interviews.problemsolving;

import java.util.*;

public class DataStructuresImpl {

    public static void main(String[] args) {
        DataStructuresImpl dsi = new DataStructuresImpl();
        dsi.array();
        dsi.string();
        dsi.list();
        dsi.stack();
        dsi.queue();
        dsi.priorityQueue();
        dsi.tree();
        dsi.redBlackTree();
    }

    // 1. Array
    private void array() {
        // Fixed-size array
        int[] array = new int[10];
        array[4] = 5;

        // Dynamic array
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.addFirst(0);

        System.out.println("Array output:\t array: " + Arrays.toString(array) + ", list: " + list);
        // array: [0, 0, 0, 0, 5, 0, 0, 0, 0, 0], list: [0, 1]
    }

    // 2. String
    private void string() {
        String str = "Hello";

        // Mutable, fast
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" ").append("World");

        // Thread-safe
        StringBuffer sbuf = new StringBuffer("Hello");
        sbuf.append(" ").append("World").append('!');

        System.out.println("String output:\t str: " + str + ", sb: " + sb + ", sbuf: " + sbuf);
        // str: Hello, sb: Hello World, sbuf: Hello World!
    }

    // 3. List (Dynamic Arrays and Linked Lists)
    private void list() {
        // Use ArrayList for fast access (random access) to elements and fewer insertions/removals.
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);

        // Use LinkedList for frequent insertions/deletions at the beginning or middle, but not random access.
        List<Integer> linkedList = new LinkedList<>();
        linkedList.addFirst(5);
        linkedList.add(7);
        linkedList.add(1, 6);

        System.out.println("List output:\t arrayList: [" + arrayList.get(0) + ", " + arrayList.get(1) + "], linkedList: " + linkedList);
        // arrayList: [1, 2], linkedList: [5, 6, 7]
    }

    // 4. Stack (LIFO)
    private void stack() {
        // Stack (Legacy API) is a subclass of Vector, which is synchronized and generally slower due to thread safety overhead.
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.pop();

        // ArrayDeque is not synchronized (unlike Stack, which extends Vector) and does not suffer from resizing overhead like an ArrayList-based stack.
        Deque<Integer> arrayDequeAsStack = new ArrayDeque<>(); // Recommended to use as Stack for java implementations
        arrayDequeAsStack.push(10);
        arrayDequeAsStack.push(20);
        arrayDequeAsStack.push(30);
        arrayDequeAsStack.pop();

        System.out.println("Stack output:\t top element: " + arrayDequeAsStack.peek() + ", arrayDequeAsStack:  " + arrayDequeAsStack);
        // top element: 20, arrayDequeAsStack:  [20, 10]
    }

    // 5. Queue (FIFO)
    private void queue() {
        // LinkedList uses a doubly linked list, which requires O(1) for enqueue/dequeue but has extra memory overhead (pointers for each node).
        // LinkedList suffers from pointer chasing, which increases cache misses and degrades performance.
        Queue<Integer> linkedListAsQueue = new LinkedList<>();
        linkedListAsQueue.add(10);
        linkedListAsQueue.remove();

        // ArrayDeque is backed by a resizable array, providing O(1) time complexity for enqueue (offer/add) and dequeue (poll/remove) operations.
        // ArrayDeque has better cache locality (since arrays are stored contiguously in memory), making it faster in practice.
        Queue<Integer> arrayDequeAsQueue = new ArrayDeque<>(); // Faster than LinkedList and Recommended to use as Queue for java implementations
        // Enqueue elements
        arrayDequeAsQueue.offer(10);
        arrayDequeAsQueue.offer(20);
        arrayDequeAsQueue.offer(30);
        // Dequeue elements
        arrayDequeAsQueue.poll();

        System.out.println("Queue output:\t top element: " + arrayDequeAsQueue.peek() + ", arrayDequeAsQueue: " + arrayDequeAsQueue);
        // top element: 20, arrayDequeAsQueue: [20, 30]
    }

    // 6. Priority Queue (Heap - MinHeap by default)
    private void priorityQueue() {
        PriorityQueue<Integer> priorityQueueAsMinHeap = new PriorityQueue<>(); // Min-Heap
        // Adding elements
        priorityQueueAsMinHeap.offer(30);
        priorityQueueAsMinHeap.offer(10);
        priorityQueueAsMinHeap.offer(20);
        priorityQueueAsMinHeap.offer(5);
        // Removing elements
        priorityQueueAsMinHeap.poll();

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // Max-Heap

        System.out.println("Heap output:\t top element: " + priorityQueueAsMinHeap.peek() + ", priorityQueueAsMinHeap: " + priorityQueueAsMinHeap);
        // top element: 10, priorityQueueAsMinHeap: [10, 30, 20]
    }

    // 7. Trees (Binary Tree, BST, AVL, ...)
    class TreeNode<T> {
        T data;
        TreeNode<T> left, right;

        public TreeNode(T data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
    class BinaryTree<T> {
        TreeNode<T> root;

        public BinaryTree(T rootData) {
            this.root = new TreeNode<>(rootData);
        }

        // Preorder Traversal (Root -> Left -> Right)
        public void preorder(TreeNode<T> node) {
            if (node == null) return;
            System.out.print(node.data + " ");
            preorder(node.left);
            preorder(node.right);
        }

        // Inorder Traversal (Left -> Root -> Right)
        public void inorder(TreeNode<T> node) {
            if (node == null) return;
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }

        // Postorder Traversal (Left -> Right -> Root)
        public void postorder(TreeNode<T> node) {
            if (node == null) return;
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data + " ");
        }

        // Level Order Traversal (BFS)
        public void levelOrder() {
            if (root == null) return;

            Queue<TreeNode<T>> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                TreeNode<T> current = queue.poll();
                System.out.print(current.data + " ");

                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
        }
    }
    private void tree() {
        // Create a binary tree
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        // Manually create left and right children
        tree.root.left = new TreeNode<>(2);
        tree.root.right = new TreeNode<>(3);
        tree.root.left.left = new TreeNode<>(4);
        tree.root.left.right = new TreeNode<>(5);
        tree.root.right.left = new TreeNode<>(6);
        tree.root.right.right = new TreeNode<>(7);

        System.out.print("Tree output:\t level order traversal: ");
        tree.levelOrder();
        System.out.println();
        // level order traversal: 1 2 3 4 5 6 7
    }

    // 8. Red-Black Tree (Balanced BST)
    private void redBlackTree() {
        // A TreeMap in Java is a sorted map implementation based on a Red-Black Tree.
        // It maintains keys in sorted order and provides O(log n) time complexity for insertion, deletion, and lookup.
        TreeMap<Integer, String> treeMap = new TreeMap<>(); // keys sorted in natural order
        // Adding key-value pairs
        treeMap.put(3, "Three");
        treeMap.put(1, "One");
        treeMap.put(2, "Two");
        treeMap.put(5, "Five");
        treeMap.put(4, "Four");
        // Removing an entry
        treeMap.remove(2);

        Map<Integer, String> descTreeMap = new TreeMap<>(Comparator.reverseOrder()); // keys sorted in descending order

        // Displaying the TreeMap (keys are sorted)
        System.out.println("RedBlack Tree:\t first key: " + treeMap.firstKey() + ", last key: " + treeMap.lastKey() + ", treeMap: " + treeMap);
        // first key: 1, last key: 5, treeMap: {1=One, 3=Three, 4=Four, 5=Five}
    }

}
