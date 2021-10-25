package com.kvvssut.interviews.java.generics.basic;

public class Main {

	public static void main(String[] args) {
		Printer<BlackAndWhiteCartridge> printer = new Printer<BlackAndWhiteCartridge>(
				new BlackAndWhiteCartridge());
		System.out.println(printer.toString()); // Generic class example
		printer.printUsingCartridge(new ColorCartridge(), "Hi!"); // Generic
																	// method
																	// example
		printer.printUsingCartridge(5, "OMG!"); // Unbounded generic issue
	}

}
