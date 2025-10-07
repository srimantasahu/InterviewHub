package com.kvvssut.interviews.codinground.java;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU Cache using LinkedHashMap.
 * Access order is maintained, so least recently used entries
 * are evicted automatically when capacity is exceeded.
 */
public class LRUCacheUsingLinkedHashMap<K, V> {
    private final int capacity;
    private final Map<K, V> cache;

    public LRUCacheUsingLinkedHashMap(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
        this.capacity = capacity;

        // true = accessOrder (otherwise insertionOrder)
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > LRUCacheUsingLinkedHashMap.this.capacity;
            }
        };
    }

    /** Returns the value for the key, or null if not present. */
    public synchronized V get(K key) {
        return cache.get(key);
    }

    /** Inserts/updates a key-value pair. */
    public synchronized void put(K key, V value) {
        cache.put(key, value);
    }

    /** Returns current cache size. */
    public synchronized int size() {
        return cache.size();
    }

    /** Clears all entries. */
    public synchronized void clear() {
        cache.clear();
    }

    /** Prints the current cache state. */
    public synchronized void printCache() {
        System.out.println(cache);
    }

    public static void main(String[] args) {
        LRUCacheUsingLinkedHashMap<Integer, String> lruCache = new LRUCacheUsingLinkedHashMap<>(3);

        lruCache.put(1, "A");
        lruCache.put(2, "B");
        lruCache.put(3, "C");
        lruCache.printCache(); // {1=A, 2=B, 3=C}

        lruCache.get(2);       // Access key 2
        lruCache.put(4, "D");  // Add key 4, evicts key 1
        lruCache.printCache(); // {3=C, 2=B, 4=D}

        lruCache.put(5, "E");  // Add key 5, evicts key 3
        lruCache.printCache(); // {2=B, 4=D, 5=E}
    }
}
