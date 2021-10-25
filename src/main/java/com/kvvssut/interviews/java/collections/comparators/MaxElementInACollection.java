package com.kvvssut.interviews.java.collections.comparators;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class MaxElementInACollection {

	public static void main(String[] args) {
		List<String> strLists = Arrays.asList("zero", "one", "two", "three");

		assert Collections.max(strLists).equals("zero");
		System.out.println(Collections.max(strLists));

		Comparator<String> sizeOrder = new Comparator<String>() {

			@Override
			public int compare(String str1, String str2) {
				return str1.length() < str2.length() ? -1
						: str1.length() > str2.length() ? 1 : str1
								.compareTo(str2);
			}
		};
		assert Collections.max(strLists, sizeOrder).equals("three");
		System.out.println(Collections.max(strLists, sizeOrder));

	}

	/*
	 * Collections class apis for finding max element in a collection -
	 */

	/*
	 * Returns the maximum element of the given collection, according to the
	 * natural ordering of its elements.
	 */
	public static <T extends Object & Comparable<? super T>> T max(
			Collection<? extends T> coll) {
		Iterator<? extends T> i = coll.iterator();
		T candidate = i.next();

		while (i.hasNext()) {
			T next = i.next();
			if (next.compareTo(candidate) > 0)
				candidate = next;
		}
		return candidate;
	}

	/*
	 * Returns the maximum element of the given collection, according to the
	 * order induced by the specified comparator.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> T max(Collection<? extends T> coll,
			Comparator<? super T> comp) {
		if (comp == null)
			return (T) max((Collection) coll);

		Iterator<? extends T> i = coll.iterator();
		T candidate = i.next();

		while (i.hasNext()) {
			T next = i.next();
			if (comp.compare(next, candidate) > 0)
				candidate = next;
		}
		return candidate;
	}
}
