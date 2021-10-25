package com.kvvssut.interviews.java.java8.streams;

import java.util.Arrays;
import java.util.stream.Stream;

import com.kvvssut.interviews.java.java8.lambdas.Person;

public class ArrayToStream {

	public static void main(String[] args) {
		Person[] people = { new Person("Sam", 26), new Person("Joe", 70), new Person("Mike", 42) };

		System.out.println("Printing Person info using Stream.of() method -");
		Stream<Person> stream1 = Stream.of(people);
		stream1.forEach(p -> System.out.println(p));

		System.out.println("\nPrinitng Person info using Arrays.stream() method -");
		Stream<Person> stream2 = Arrays.stream(people);
		stream2.forEach(p -> System.out.println(p));

	}

}
