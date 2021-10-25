package com.kvvssut.interviews.java.generics.wildcards;

public class Main {

	public static void main(String[] args) {
		Printer<BlackAndWhiteCartridge> printer = new Printer<BlackAndWhiteCartridge>(
				new BlackAndWhiteCartridge());
		print(printer); // Error without wildcard (i.e., Printer<ICartridge>
						// printer) - The method print(Printer<ICartridge>) in
						// the type Main is not applicable for the arguments
						// (Printer<BlackAndWhiteCartridge>)
	}

	public static void print(Printer<? extends ICartridge> printer) { // Wildcards
																		// are
																		// used
																		// when
																		// we
																		// cannot
																		// modify
																		// the
																		// existing
																		// source
																		// code
		int fillPercentage = printer.getCartridge().getFillPercentage(); // Error
																			// without
																			// generics
																			// (i.e.,
																			// Printer
																			// printer)
																			// -
																			// The
																			// method
																			// getFillPercentage()
																			// is
																			// undefined
																			// for
																			// the
																			// type
																			// Object
		System.out.println("Fill percentage is : " + fillPercentage);
	}

}
