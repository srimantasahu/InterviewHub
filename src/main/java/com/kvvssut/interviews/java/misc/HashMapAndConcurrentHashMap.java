package com.kvvssut.interviews.java.misc;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapAndConcurrentHashMap {

	/*
	 * final int hash(Object k) - method used by V put(K key, V value)
	 * 
	 * Retrieves object hash code and applies a supplemental hash function to
	 * the result hash, which defends against poor quality hash functions. This
	 * is critical because HashMap uses power-of-two length hash tables, that
	 * otherwise encounter collisions for hashCodes that do not differ in lower
	 * bits. Note: Null keys always map to hash 0, thus index 0.
	 */

	public static void main(String[] args) {

		// Type 1
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}

		// Type 2
		Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Integer, Integer> entry = it.next();
			System.out.println(entry.getKey() + " = " + entry.getValue());
			it.remove(); // avoids a ConcurrentModificationException
		}
		
		/*
		 * ConcurrentModificationException will occur if the underlying
		 * collection that is being iterated over is modified by anything other
		 * than the Iterator itself.
		 * 
		 * Iterator it = map.entrySet().iterator();
		 * 
		 * while (it.hasNext()) {			// throws a ConcurrentModificationException on next iteration
		 * 
		 * 		Entry item = it.next();
		 * 
		 * 		map.remove(item.getKey());	// causes a ConcurrentModificationException
		 * 
		 * }
		 */
	}
	
	/**
	 * ConcurrentHashMap(int initialCapacity, float loadFactor, int concurrencyLevel)
     *                        
	 * Creates a new, empty map with the specified initial capacity, load factor
	 * and concurrency level.
	 *
	 * @param initialCapacity
	 *            the initial capacity. The implementation performs internal
	 *            sizing to accommodate this many elements.
	 * @param loadFactor
	 *            the load factor threshold, used to control resizing. Resizing
	 *            may be performed when the average number of elements per bin
	 *            exceeds this threshold.
	 * @param concurrencyLevel
	 *            the estimated number of concurrently updating threads. The
	 *            implementation performs internal sizing to try to accommodate
	 *            this many threads.
	 * @throws IllegalArgumentException
	 *             if the initial capacity is negative or the load factor or
	 *             concurrencyLevel are nonpositive.
	 *             
	 *
	 * ConcurrentHashMap()
	 * 
	 * Creates a new, empty map with a default initial capacity (16), load factor (0.75) and concurrencyLevel (16).
	 * 
	 * loadFactor - The value of this field is always (int)(capacity * loadFactor).
	 */
	
	/*
	╔═══════════════╦═══════════════════╦═══════════════════╦═════════════════════╗
	║   Property    ║     HashMap       ║    Hashtable      ║  ConcurrentHashMap  ║
	╠═══════════════╬═══════════════════╬═══════════════════╩═════════════════════╣ 
	║      Null     ║     allowed       ║              not allowed                ║
	║  values/keys  ║                   ║                                         ║
	╠═══════════════╬═══════════════════╬═════════════════════════════════════════╣
	║Is thread-safe ║       no          ║                  yes                    ║
	╠═══════════════╬═══════════════════╬═══════════════════╦═════════════════════╣
	║     Lock      ║       not         ║ locks the whole   ║ locks the portion   ║        
	║  mechanism    ║    applicable     ║       map         ║                     ║ 
	╠═══════════════╬═══════════════════╩═══════════════════╬═════════════════════╣
	║   Iterator    ║               fail-fast               ║       fail-safe     ║ 
	╚═══════════════╩═══════════════════════════════════════╩═════════════════════╝
	 */
	
	/*
	 * Fail-Fast iterators immediately throw ConcurrentModificationException if
	 * a collection is modified while iterating over it. Where as Fail-Safe
	 * iterators don’t throw any exceptions if a collection is modified while
	 * iterating over it. Because, they operate on the clone of the collection,
	 * not on the actual collection.
	 */

}
