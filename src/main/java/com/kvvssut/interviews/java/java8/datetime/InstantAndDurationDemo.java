package com.kvvssut.interviews.java.java8.datetime;

import java.time.Duration;
import java.time.Instant;

public class InstantAndDurationDemo {

	public static void main(String[] args) throws InterruptedException {
		Instant start = Instant.now();
		System.out.println("Start time is : " + start);

		Thread.sleep(1000);

		Instant end = Instant.now();
		System.out.println("\nEnd time is : " + end);

		Duration elapsed = Duration.between(start, end);
		System.out.println("\nElapsed duration is : " + elapsed);
		System.out.println("Elapsed duration in milliseconds is : " + elapsed.toMillis() + " ms");

	}

}