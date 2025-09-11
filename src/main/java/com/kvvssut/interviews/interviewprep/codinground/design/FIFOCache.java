package com.kvvssut.interviews.interviewprep.codinground.design;

import java.util.HashMap;

public class FIFOCache<K, V> {
    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev, next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final HashMap<K, Node<K, V>> map;
    private final int capacity;
    private Node<K, V> head, tail;

    public FIFOCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    public void enqueue(K key, V value) {
        if (map.containsKey(key)) {
            // If the key already exists, update its value and move to the tail.
            Node<K, V> node = map.get(key);
            node.value = value;
            return;
        }

        // Create a new node.
        Node<K, V> newNode = new Node<>(key, value);

        // Add the node to the tail of the linked list.
        if (tail != null) {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;

        // If the list was empty, set the new node as the head.
        if (head == null) {
            head = newNode;
        }

        // Add the node to the map.
        map.put(key, newNode);

        // Check capacity and evict the oldest item if needed.
        if (map.size() > capacity) {
            dequeue();
        }
    }

    public V dequeue() {
        if (head == null) {
            return null; // The list is empty.
        }

        // Remove the head node.
        Node<K, V> oldHead = head;
        head = head.next;

        if (head != null) {
            head.prev = null;
        } else {
            tail = null; // The list is now empty.
        }

        // Remove the node from the map.
        map.remove(oldHead.key);

        return oldHead.value;
    }

    public V lookup(K key) {
        Node<K, V> node = map.get(key);
        return node != null ? node.value : null;
    }

    public void printCache() {
        Node<K, V> current = head;
        while (current != null) {
            System.out.print(current.key + ":" + current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        FIFOCache<Integer, String> cache = new FIFOCache<>(3);

        cache.enqueue(1, "A");
        cache.enqueue(2, "B");
        cache.enqueue(3, "C");

        cache.printCache(); // Outputs: 1:A 2:B 3:C

        System.out.println("Lookup 2: " + cache.lookup(2)); // Outputs: B

        cache.enqueue(4, "D");
        cache.printCache(); // Outputs: 2:B 3:C 4:D (1:A is evicted)

        cache.dequeue();
        cache.printCache(); // Outputs: 3:C 4:D
    }
}
