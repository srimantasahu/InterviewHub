package com.kvvssut.interviews.java.collections.comparators;

public class ComparableMain {

    /*
     * public interface Comparable<T> { public int compareTo(T o); }
     *
     * compareTo method returns a value that is negative, zero, or positive
     * depending upon whether the argument is less than, equal to, or greater
     * than the given object.
     *
     * When a class implements Comparable, the ordering specified by this
     * interface is called the natural ordering for that class.
     *
     * Typically, an object belonging to a class can only be compared with an
     * object belonging to the same class.
     */

    /*
     * Consistent with Equals - usually we require that two objects are equal if
     * and only if they compare as the same
     *
     * x.equals(y) - if and only if x.compareTo(y) == 0
     *
     * In this case, we say that the natural ordering is consistent with equals.
     * This is particularly important if we use the interfaces SortedSet and
     * SortedMap, both of which compare items using natural ordering. If two
     * items that compare as the same are added to a sorted set/map, then only
     * one will be stored, even if the two items are not equal.
     *
     * Almost every class in Java core libraries that has a natural ordering is
     * consistent with equals. An exception is java.math.BigDecimal, which
     * compares as the same, two decimals that have the same value but different
     * precisions, such as 4.0 and 4.00.
     */

    /*
     * Comparision differs from equality in that is does not accept a null
     * argument. If x is not null, x.equals(null) must return false, while
     * x.compareTo(null) must throw a NullPointerException.
     */

    public static void main(String[] args) {
        Integer int0 = 0;
        Integer int1 = 5;
        assert int0.compareTo(int1) < 0;
        System.out.println(int0.compareTo(int1));

        // Integer's compareTo definition -
        // public int compareTo(Integer that) {
        // return this.value < that.value ? -1 : this.value == that.value ? 0 :
        // 1;
        // }

        /*
         * bad implementation -- don't do it this way! - may give wrong result
         * when there is overflow (difference > Integer.MAX_VALUE).
         */
        // public int compareTo(Integer that) {
        // return this.value - that.value;
        // }

        String str0 = "zero";
        String str1 = "one";
        assert str0.compareTo(str1) > 0;
        System.out.println(str0.compareTo(str1));

        /*
         * The type parameter to the interface allows nonsensical comparisions
         * to be caught at the compile time -
         *
         * assert int0.compareTo(str0); // compile-time error
         *
         * Comparision is not supported between arbitrary numerical types, and
         * comparision is illegal because the Number class does not implement
         * the Comparable interface.
         *
         * Number m = new Integer(2); Number n = new Double(3.14);
         *
         * assert m.compareTo(n) < 0; // compile-time error
         */

    }
}
