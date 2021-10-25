package com.kvvssut.interviews.java.collections.comparators;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PermittingComparisionTest {

	abstract class Fruit implements Comparable<Fruit> {
		protected String name;
		protected int size;

		protected Fruit(String name, int size) {
			this.name = name;
			this.size = size;
		}

		public boolean equals(Object o) {
			if (o instanceof Fruit) {
				Fruit that = (Fruit) o;
				return this.name.equals(that.name) && this.size == that.size;
			}
			return false;
		}

		public int hash() {
			return name.hashCode() * 29 + size;
		}

		public String toString() {
			return name + " : " + size;
		}

		public int compareTo(Fruit that) {
			return this.size < that.size ? -1 : this.size == that.size ? 0 : 1;
		}
	}

	class Apple extends Fruit {
		public Apple(int size) {
			super("Apple", size);
		}
	}

	class Orange extends Fruit {
		public Orange(int size) {
			super("Orange", size);
		}
	}

	public static void main(String[] args) {
		PermittingComparisionTest test = new PermittingComparisionTest();

		Apple a1 = test.new Apple(1);
		Apple a2 = test.new Apple(2);

		Orange o3 = test.new Orange(3);
		Orange o4 = test.new Orange(4);

		List<Apple> apples = Arrays.asList(a1, a2);
		assert Collections.max(apples).equals(a2);
		System.out.println(Collections.max(apples));

		List<Orange> oranges = Arrays.asList(o3, o4);
		assert Collections.max(oranges).equals(o4);
		System.out.println(Collections.max(oranges));

		List<Fruit> mixed = Arrays.<Fruit> asList(a1, o3);
		assert Collections.max(mixed).equals(o3); // OK
		System.out.println(Collections.max(mixed));
	}

}
