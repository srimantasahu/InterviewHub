package com.kvvssut.interviews.java.strings;

public class Strings {

    public static void main(String[] args) {
        String s1 = "ab".concat("cd");
        String s2 = "ab" + "cd";    // + operator overloading

        /*
         * private final char value[];	 // The value is used for character storage.
         *
         * private int hash;	// Cache the hash code for the string
         */
        String string;

        /*
         * char[] value;  in AbstractStringBuilder defined as StringBuilder() { super(16); }	or 	StringBuilder(String str) { super(str.length() + 16); append(str); }
         *  int count;	in AbstractStringBuilder counts the number of characters used.
         */
        StringBuilder stringBuilder;

		/*
		  void expandCapacity(int minimumCapacity) {	// in AbstractStringBuilder
	        int newCapacity = value.length * 2 + 2;
	        if (newCapacity - minimumCapacity < 0)
	            newCapacity = minimumCapacity;
	        if (newCapacity < 0) {
	            if (minimumCapacity < 0) // overflow
	                throw new OutOfMemoryError();
	            newCapacity = Integer.MAX_VALUE;  
	        }
	        value = Arrays.copyOf(value, newCapacity);
	      }
		 */
		
		/*
		 	append() overloaded to take all base type
		 	toString() returns a concatenated 
		 */

        /*
         * char[] value;  in AbstractStringBuilder	defined as StringBuilder() { super(16); }	or 	StringBuilder(String str) { super(str.length() + 16); append(str); }
         * int count;	in AbstractStringBuilder counts the number of characters used.
         */
        StringBuffer stringBuffer;    // synchronized
    }

}
