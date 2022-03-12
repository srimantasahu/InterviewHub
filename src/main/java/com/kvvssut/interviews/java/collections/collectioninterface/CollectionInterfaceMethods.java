package com.kvvssut.interviews.java.collections.collectioninterface;

import java.util.Arrays;
import java.util.List;

public class CollectionInterfaceMethods {

    /*
     * 1. Adding Elements - boolean add(E e); boolean addAll(Collection<?
     * extends E> c);
     *
     * The boolean result returned by these methods indicates whether the
     * collection was changed by the call. It will be false for sets, which will
     * be unchanged if they are asked to add an element that is already present.
     */

    /*
     * 2. Removing Elements - boolean remove(Object o); void clear(); boolean
     * removeAll(Collection<?> c); boolean retainAll(Collection<?> c);
     *
     * If the element o is null, remove removes a null from the collection if
     * one is present. Otherwise, if an element e is present for which
     * 0.equals(e), it removes it. If not, it leaves the collection unchanged.
     * Where a method in this group returns a boolean, the value is true if the
     * collection changed as a result of applying the operation.
     */

    /*
     * 3. Querying the Contents of a Collection - boolean contains(Object o);
     * boolean containsAll(Collection<?> c); boolean isEmpty(); int size();
     */

    /*
     * 4. Making the Collection's Contents Available for Further Processing -
     * Iterator<E> iterator(); Object[] toArray(); <T> T[] toArray(T[] t);
     *
     * The second method will create a new array of Object, and the third takes
     * an array of T and returns an array of the same type containing the
     * elements of the collection.
     *
     * Collection<String> cs = ...
     *
     * String[] sa = cs.toArray(new String[0]);
     *
     * If the array passed as argument has enough room, the elements of the
     * collection are placed in it - otherwise, a new array of that type is
     * created.
     */

    /*
     * Collection Constructors - taking example of HashSet 1. public HashSet()
     * 2. public HashSet(Collection<? extends E> c)
     *
     * The first one creates an empty set, and the second a set that will
     * contain the elements of any collection of the parametric type - or one of
     * its sub-types - called as copy-constructor. The second one has the same
     * effect as creating an empty set with the default constructor, and then
     * adding the contents of a collection using addAll.
     *
     * Not all collection classes have constructors of both forms.
     */

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        // 0. Arrays.asList creates a wrapper list over the array. Operations on the list wrapper are propagated to the original array.
        String[] str = {"Srimant", "Sangita", "Smita"};
        List<String> list = Arrays.asList(str);
        // list.add(3, "Srikant");	// UnsupportedOperationException
        list.set(2, "Srikant");
        System.out.println(str.length + " Ele at 0th indesx is : " + str[2]);

        // 1. Correct way
        List<? extends Object> l = Arrays.asList("zero", "one");
        String[] a = l.toArray(new String[0]);

        // 2. run-time error
        List<? extends Object> l1 = Arrays.asList("zero", "one", 2);
        String[] a1 = l1.toArray(new String[0]); // run-time error -
        // ArrayStoreException -
        // occurs if we try to
        // assign to an array with
        // an incompatible type.

        // 3. compile-time error
        List<Integer> l2 = Arrays.asList(0, 1, 2);
        // int[] a2 = l2.toArray(new int[0]); // compile-time error - because
        // the
        // type parameter T in the method
        // call must be a reference type.
    }
}
