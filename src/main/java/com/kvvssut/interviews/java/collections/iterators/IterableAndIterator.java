package com.kvvssut.interviews.java.collections.iterators;

import java.util.Iterator;

public class IterableAndIterator {

	/*
	 * public interface Iterator<E> { boolean hasNext(); E next(); void
	 * remove(); }
	 */

	/*
	 * public interface Iterable<T> { Iterator<T> iterator(); }
	 */

	/* public interface Collection<E> extends Iterable<E> {} */

	class Counter implements Iterable<Integer> {
		private int count;

		public Counter(int count) {
			this.count = count;
		}

		@Override
		public Iterator<Integer> iterator() {
			return new Iterator<Integer>() {
				private int i = 0;

				@Override
				public boolean hasNext() {
					return (i < count);
				}

				@Override
				public Integer next() {
					i++;
					return i;
				}

				/*
				 * default void remove() { throw new
				 * UnsupportedOperationException("remove"); }
				 */

				@Override
				public void remove() {
					throw new UnsupportedOperationException();
				}

			};
		}

	}

	/*
	 * The general purpose collection framework Iterators are fail-fast
	 * iterators, they throw ConcurrentModificationException whenever they
	 * detect that the collection from which they were derived has been
	 * structurally changed i.e., elements have been added or removed.
	 */

	public static void main(String[] args) {
		System.out.println("Obsolete way - Used prior to Java 5");
		for (Iterator<Integer> iterator = new IterableAndIterator().new Counter(
				3).iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
		}

		System.out.println("\nUsing for-each loop");
		for (Integer num : new IterableAndIterator().new Counter(3)) {
			System.out.println(num);
		}
	}

	/*
	 * Copy-on-write collections have snapshot iterators. These collections are
	 * backed by arrays which, once created, are never changed; if a value in
	 * the collection needs to be changed, a new array is created. So an
	 * iterator can read the values in one of these arrays (but never modify
	 * them) without the danger of them being changed by another thread.
	 * Snapshot iterators do not throw ConcurrentModificationException.
	 */

	/*
	 * Collections which rely on compare-and-swap have weakly consistent
	 * iterators, which reflect some but not necessarily all of the changes that
	 * have been made to their backing collection since they were created. For
	 * example, if the elements in the collection have been modified or removed
	 * before the iterator reaches them, it definitely will reflect these
	 * changes, but no such guarantee is made for insertions. Weakly consistent
	 * iterators do not throw ConcurrentModificationException.
	 */

}
