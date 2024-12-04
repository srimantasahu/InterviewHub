package com.kvvssut.interviews.java.versions.java16.records;

import java.util.Objects;

/*
Java 14 introduces a new class type record as preview feature to facilitate creation of immutable data objects.
Java 15 enhances record type further.
With Java 16, record is now a standard feature of JDK.
Defining a record is a concise way of defining an immutable data holding object.
 */
public class RecordClasses {

    // With using record
    public record AnyBook(String title, String author, String isbn) {
    }

    // Without using record
    public final class Book {
        private final String title;
        private final String author;
        private final String isbn;

        public Book(String title, String author, String isbn) {
            this.title = title;
            this.author = author;
            this.isbn = isbn;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public String getIsbn() {
            return isbn;
        }

        @Override
        public boolean equals(Object o) {
            Book other = (Book) o;
            return Objects.equals(this.isbn, other.isbn);
        }

        @Override
        public int hashCode() {
            return Objects.hash(title, author, isbn);
        }
    }

}
