package com.kvvssut.interviews.java.generics.basic;

public class Printer<T> {

	private T cartridge;

	public Printer(T cartridge) {
		this.cartridge = cartridge;
	}

	@Override
	public String toString() {
		return cartridge.toString();
	}

	public <U> void printUsingCartridge(U cartridge, String msg) {
		System.out.println(cartridge.toString() + " " + msg);
	}

}
