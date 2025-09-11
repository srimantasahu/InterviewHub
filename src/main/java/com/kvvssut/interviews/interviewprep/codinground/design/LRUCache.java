package com.kvvssut.interviews.interviewprep.codinground.design;

import java.util.HashMap;

public class LRUCache<K, V> {
    private class Node {
        K key;
        V value;
        Node prev, next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final HashMap<K, Node> map;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    private void removeNode(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }

    private void addToHead(Node node) {
        node.next = head;
        node.prev = null;

        if (head != null) {
            head.prev = node;
        }
        head = node;

        if (tail == null) {
            tail = head;
        }
    }

    public V get(K key) {
        Node node = map.get(key);
        if (node == null) {
            return null;
        }
        // Move the accessed node to the head
        removeNode(node);
        addToHead(node);
        return node.value;
    }

    public void put(K key, V value) {
        Node node = map.get(key);

        if (node != null) {
            // Update the value
            node.value = value;
            // Move the node to the head
            removeNode(node);
            addToHead(node);
        } else {
            // Create a new node
            Node newNode = new Node(key, value);
            if (map.size() >= capacity) {
                // Evict the tail node
                map.remove(tail.key);
                removeNode(tail);
            }
            // Add the new node to the head
            addToHead(newNode);
            map.put(key, newNode);
        }
    }

    public void printCache() {
        Node current = head;
        while (current != null) {
            System.out.print(current.key + ":" + current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);

        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");
        cache.printCache(); // Outputs: 3:C 2:B 1:A

        cache.get(2);
        cache.printCache(); // Outputs: 2:B 3:C 1:A

        cache.put(4, "D");
        cache.printCache(); // Outputs: 4:D 2:B 3:C (1 is evicted)

        cache.put(5, "E");
        cache.printCache(); // Outputs: 5:E 4:D 2:B (3 is evicted)
    }
}
