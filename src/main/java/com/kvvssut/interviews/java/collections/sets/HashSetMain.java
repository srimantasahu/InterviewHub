package com.kvvssut.interviews.java.collections.sets;

import java.util.HashSet;
import java.util.Set;

public class HashSetMain {

	/*
	 * HashSet is implemented by a hash table - an array in which elements are
	 * stored at a position derived from their contents. An element's position
	 * in a hash table is calculated by a hash function of its contents.
	 */

	/*
	 * HashSet is implemented by a specialized HashMap, with a key and a value
	 * for each cell and with all values being the same.
	 */

	// Dummy value to associate with an Object in the backing Map -
	// private static final Object PRESENT = new Object();

	/*
	 * Hash functions are designed to give, as far as possible, an even spread
	 * of results (hash codes) over the element values that might be stored.
	 */

	// Sample code used in String class to calculate a hash code -
	// int hash = 0;
	// for (char ch : str.toCharArray()) {
	// hash = hash * 31 + ch;
	// }

	/*
	 * Traditionally, hash tables obtain an index from the hash code by taking
	 * the remainder after division by the table length. The Collection
	 * Framework classes actually use bit masking rather than division. Since
	 * that means it is the pattern of bits at the low end of the hash code that
	 * is significant, prime numbers (such as 31, here) are used in calculating
	 * the hash code because multiplying by primes will not tend to shift
	 * information away from the low end - as would multiplying by a power of 2,
	 * for example.
	 */

	/*
	 * When collisions do occur, the colliding elements are still kept at the
	 * same location or bucket. This is often done by storing them in a linked
	 * list.
	 */

	/*
	 * HashSet additional constructors - HashSet(int initialCapacity)
	 * HashSet(int initialCapacity, float loadFactor)
	 * 
	 * These constructors create an empty set but allows some control over the
	 * size of the underlying table and the load factor, creating one with a
	 * length of the next-largest power of 2 after the supplied capacity.
	 */

	public static void main(String[] args) {
		Set<Character> collisionsBucketSet = new HashSet<Character>(8);
		collisionsBucketSet.add('a');
		collisionsBucketSet.add('b');
		collisionsBucketSet.add('j');

		/*
		 * The index values of the table have been calculated by using the
		 * bottom three bits (for a table of length 8) of the hash code of each
		 * element. In this implementation, a Character's hash code is just the
		 * Unicode value of the character it contains.
		 */

		// Sample code used in Character class to calculate hash code -
		// public static int hashCode(char value) {
		// return (int)value;
		// }
	}

	/*
	 * As long as there are no collisions, the cost of inserting or retrieving
	 * an element is constant. As the hash table fills, collisions become more
	 * likely; assuming a good hash function, the probability of a collision in
	 * a lightly loaded table is proportional to its load, defined as the number
	 * of elements in the table divided by its capacity (number of buckets). If
	 * a collision does take place, a linked list has to be created and
	 * subsequently traversed, adding an extra cost to insertion proportional to
	 * the number of elements in the list. If the size of the hash table is
	 * fixed, performance will worsen as more elements are added and the load
	 * increases. To prevent this from happening, the table size is increased by
	 * rehashing - copying to a new and larger table - when the load reaches a
	 * specified threshold (its load factor).
	 */

	/*
	 * Iterating over a hash table requires each bucket to be examined to see
	 * whether it is occupied and therefore costs a time proportional to the
	 * capacity of the hash table plus the number of elements it contains. Since
	 * the iterator examines each bucket in turn, the order in which elements
	 * are returned depends on their hash codes, so there is no guarantee as to
	 * the order in which the elements will be returned.
	 */

	/*
	 * The chief attraction of a hash table implementation for sets is the
	 * (ideally) constant-time performance for the basic operations of add,
	 * remove, contains, and size. Its main disadvantage is its iteration
	 * performance; since iterating through the table involves examining every
	 * bucket, its cost is proportional to the table size regardless of the size
	 * of the set it contains.
	 */

	/*
	 * HashSet is unsynchronized and not thread-safe; its iterators are
	 * fail-fast.
	 */
}