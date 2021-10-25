package com.kvvssut.interviews.java.java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

import com.kvvssut.interviews.java.java8.lambdas.Person;

public class SumAndAverage {

	public static void main(String[] args) {
		List<Person> people = new ArrayList<Person>();
		people.add(new Person("Sam", 26));
		people.add(new Person("Joe", 70));
		people.add(new Person("Mike", 42));

		int sum = people.stream().mapToInt(p -> p.getAge()).sum();
		System.out.println("Sum of ages is : " + sum);

		OptionalDouble avg = people.stream().mapToInt(p -> p.getAge()).average();

		if (avg.isPresent()) {
			System.out.println("\nAverage of ages is : " + avg);
			System.out.println("Average of ages in double value is : " + avg.getAsDouble());
		} else {
			System.out.println("\nAverage cannot be computed!");
		}

	}

}