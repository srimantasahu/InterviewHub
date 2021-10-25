package com.kvvssut.interviews.java.iterable;

import java.util.Iterator;

class MyClass implements Iterable<String> {
	public String[] a = null;

	public MyClass(String[] arr) {
		a = arr;
	}

	public MyClassIterator iterator() {
		return new MyClassIterator(this);
	}

	public class MyClassIterator implements Iterator<String> {
		private MyClass myclass = null;
		private int count = 0;

		public MyClassIterator(MyClass m) {
			myclass = m;
		}

		public boolean hasNext() {
			if (count < myclass.a.length) {
				return true;
			} else {
				return false;

			}
		}

		public String next() {
			int t = count;
			count++;
			return myclass.a[t];
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}