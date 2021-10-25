package com.kvvssut.interviews.designpattern.creational;

public class FactoryPattern_22_OneProduct implements FactoryPattern_21_Product {

	// Registration done inside the product classes
	static {
		FactoryPattern_2_WithClassRegistrationUsingReflection.getInstance().registerProduct("Prod1",
				FactoryPattern_22_OneProduct.class);
	}

}