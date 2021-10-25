package com.kvvssut.interviews.java.collections;

import java.util.ArrayList;
import java.util.List;

public class Lists {

	public static void main(String[] args) {
		List<String> list;		// public interface List<E> extends Collection<E>
		
		// public interface Collection<E> extends Iterable<E>
		
//		Collection<String> collection = new ArrayList<String>();
//		collection.   can only use- int size(); / boolean isEmpty(); / Object[] toArray(); / <T> T[] toArray(T[] a); / Iterator<E> iterator();  
									// boolean add(E e); / boolean remove(Object o); / boolean containsAll(Collection<?> c); / boolean removeAll(Collection<?> c); / void clear(); 
									//  boolean retainAll(Collection<?> c);  / boolean contains(Object o); /  boolean equals(Object o); /  int hashCode();
		
//		List<String> list2 = new ArrayList<String>();	// extends Collection<String>
//		list.		its own interface ()-  E get(int index); / E set(int index, E element); / void add(int index, E element); / E remove(int index);
										// int indexOf(Object o); / int lastIndexOf(Object o); / List<E> subList(int fromIndex, int toIndex); / ListIterator<E> listIterator(); /  ListIterator<E> listIterator(int index);

		
		List<String> list3 = new ArrayList<String>();	// public class ArrayList<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable
		
		
		
	}

}
