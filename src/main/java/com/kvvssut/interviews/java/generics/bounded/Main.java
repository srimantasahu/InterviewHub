package com.kvvssut.interviews.java.generics.bounded;

public class Main {

	public static void main(String[] args) {
		Printer<BlackAndWhiteCartridge> printer = new Printer<BlackAndWhiteCartridge>(
				new BlackAndWhiteCartridge());
		System.out.println(printer.toString()); // // Generic bounded class
												// example With additional
												// interface method call
		printer.printUsingCartridge(new ColorCartridge(), "Hi!"); // Generic
																	// bounded
																	// method
																	// example
																	// With
																	// additional
																	// interface
																	// method
																	// call
		// printer.printUsingCatridge(5, "OMG!"); // Compilation error because
		// type is bounded
	}

}
