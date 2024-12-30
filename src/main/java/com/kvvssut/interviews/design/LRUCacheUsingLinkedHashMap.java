package com.kvvssut.interviews.design;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheUsingLinkedHashMap<K, V> {
    private final int capacity;
    private final LinkedHashMap<K, V> cache;

    public LRUCacheUsingLinkedHashMap(int capacity) {
        this.capacity = capacity;

        // true enables access order for LinkedHashMap
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > LRUCacheUsingLinkedHashMap.this.capacity;
            }
        };
    }

    public V get(K key) {
        return cache.getOrDefault(key, null);
    }

    public void put(K key, V value) {
        cache.put(key, value);
    }

    public void printCache() {
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
