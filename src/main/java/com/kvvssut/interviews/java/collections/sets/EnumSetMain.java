package com.kvvssut.interviews.java.collections.sets;

import java.util.EnumSet;

public class EnumSetMain {

	/*
	 * EnumSet class exists to take advantage of the efficient implementations
	 * that are possible when the number of possible elements is fixed and a
	 * unique index can be assigned to each. These two conditions hold for a set
	 * of elements of the same Enum; the number of keys is fixed by the
	 * constants of the enumerated type, and the ordinal method returns values
	 * that are guaranteed to be unique to each constant. In addition, the
	 * values that ordinal returns form a compact range, starting from zero -
	 * ideal, in fact, for use as array indices or, in the standard
	 * implementation, indices of a bit vector. So add, remove, and contains are
	 * implemented as bit manipulations, with constant-time performance. Bit
	 * manipulation on a single word is extremely fast, and a long value can be
	 * used to represent EnumSets over enum types with up to 64 values. Larger
	 * enums can be treated in a similar way, with some overhead, using more
	 * than one word for the representation.
	 */

	/*
	 * EnumSet is an abstract class that implements these different
	 * representations by means of different package-private subclasses. It
	 * hides the concrete implementation from the programmer, instead exposing
	 * factory methods that call the constructor for the appropriate subclass.
	 */

	/*
	 * EnumSet constructors -
	 * 
	 * <E extends Enum<E>> EnumSet<E> of(E first, E... rest)
	 * 
	 * <E extends Enum<E>> EnumSet<E> range(E from, E to)
	 * 
	 * <E extends Enum<E>> EnumSet<E> allOf(Class<E> elementType)
	 * 
	 * <E extends Enum<E>> EnumSet<E> noneOf(Class<E> elementType)
	 * 
	 * The method of and range receive at least one enum argument, which can be
	 * queried for its declaring class (that is, Enum that it belongs to). For
	 * allOf and noneOf, which have no arguments, a class token is supplied
	 * instead.
	 * 
	 * <E extends Enum<E>> EnumSet<E> copyOf(EnumSet<E> s)
	 * 
	 * <E extends Enum<E>> EnumSet<E> copyOf(Collection<E> c)
	 * 
	 * <E extends Enum<E>> EnumSet<E> complementOf(EnumSet<E> s)
	 * 
	 * The collection supplied as the argument to the second version of copyOf
	 * must be non-empty so that the element type can be determined.
	 */

	/*
	 * EnumSet obeys the contract for Set, with the added specification that its
	 * iterators will return their elements in their natural order (the order in
	 * which the enum constants are declared). It is not thread-safe, but unlike
	 * the unsynchronized general-purpose collections, its iterators are not
	 * fail-fast. They may be either snapshot or (mostly) weakly consistent
	 * iterators.
	 */

	interface GradesInterface {
		String O = "Outstanding";
		String E = "Excellent";
		String A = "Very Good";
		String B = "Good";
		String C = "Bad";
		String D = "Very Bad";
		String F = "Failed";
	}

	enum GradesEnum {
		O(GradesInterface.O), E(GradesInterface.E), A(GradesInterface.A), B(
				GradesInterface.B), C(GradesInterface.C), D(GradesInterface.D), F(
				GradesInterface.F);

		String gradeDesc;

		private GradesEnum(String desc) {
			this.gradeDesc = desc;
		}

		public String getGradeDesc() {
			return this.gradeDesc;
		}
	}

	public static void main(String[] args) {
		EnumSet<GradesEnum> goodGrades = EnumSet.range(GradesEnum.O,
				GradesEnum.A);
		System.out.println("Good grades are - ");
		for (GradesEnum grade : goodGrades) {
			System.out.println(grade.name() + " - " + grade.getGradeDesc());
		}

		EnumSet<GradesEnum> badGrades = EnumSet.complementOf(goodGrades);
		System.out.println("Bad grades are -");
		for (GradesEnum grade : badGrades) {
			System.out.println(grade.name() + " - " + grade.getGradeDesc());
		}
	}

}
