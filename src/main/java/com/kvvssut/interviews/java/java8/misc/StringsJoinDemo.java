package com.kvvssut.interviews.java.java8.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class StringsJoinDemo {

	public static void main(String[] args) {
		/************** String.join() Demo **************/
		String friends = String.join(" and ", "Amit", "Sourav", "Ram");
		System.out.println("Result of joining varargs is : " + friends);

		String[] places = { "Bangalore", "Goa", "Bhubaneswar" };
		String favPlaces = String.join(", ", places);
		System.out.println("\nResult of joining array is : " + favPlaces);

		List<String> people = new ArrayList<String>();
		people.add("Sam");
		people.add("Joe");
		people.add("Mike");
		String persons = String.join(" & ", people);
		System.out.println("\nResult of joining list is : " + persons);

		/************** StringJoiner Demo **************/
		StringJoiner sj = new StringJoiner(", ", "{ ", " }");
		sj.setEmptyValue("No friends yet!");
		System.out.println("\n\nInitially friends are : " + sj);

		sj.add("Amit").add("Sourav").add("Ram");
		System.out.println("\nGood friends are : " + sj);

		StringJoiner sj2 = new StringJoiner(",");
		sj2.add("Sipak").add("Deb");

		sj.merge(sj2);
		System.out.println("\nAll friends are : " + sj);

		StringJoiner sj3 = new StringJoiner(" and ");
		people.forEach(person -> sj3.add(person));
		System.out.println("\n\nAll Persons in list are : " + sj3);

	}

}