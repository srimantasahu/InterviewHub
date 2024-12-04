package com.kvvssut.interviews.java.versions.java21.recordpatterns;

/*
In Java 14, the introduction of records provided a streamlined way to create data-centric classes, focusing solely on carrying data without the need for boilerplate code.
This was a significant step forward, simplifying code and enhancing readability.

Now, with the advancements in Java 21, record patterns and type patterns can be nested, offering a more declarative and composable approach to data manipulation.
This means developers can navigate and process data in a more intuitive and concise manner.

Before Java 21, accessing individual values from a record required deconstructing the entire record, which could lead to verbose code.
However, with the introduction of record patterns and type patterns, this process has become much simpler and more efficient.
 */
public class RecordPatterns {

    /*
        Prior to Java 21, accessing the city required first checking if the object is an instance of Address,
        then retrieving the city using the accessor method. This approach works but can be verbose and less intuitive.
     */
    public static void printCityWithoutPatternMatching(Object obj) {
        if (obj instanceof Address(String city, String apartment)) {
            System.out.println(city);
            System.out.println(apartment);
        }
    }

    /*
        Below method demonstrates the power of pattern matching introduced in Java 21.
        Here, the instanceof check is combined with pattern matching directly in the conditional statement.
        This results in cleaner and more concise code, where the city is extracted directly from the object without the need for explicit accessor methods.
     */
    public static void printCityWithPatternMatching(Object obj) {
        if (obj instanceof Address(String city, String apartment)) {
            System.out.println(city);
            System.out.println(apartment);
        }
    }

    public static void main(String[] args) {
        Address a = new Address("Bangalore", "SDA");
        printCityWithoutPatternMatching(a);
        printCityWithPatternMatching(a);
    }

    public record Address(String city, String apartment) {
    }

}
