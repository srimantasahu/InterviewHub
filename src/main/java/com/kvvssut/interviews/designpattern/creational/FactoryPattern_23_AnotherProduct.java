package com.kvvssut.interviews.designpattern.creational;

public class FactoryPattern_23_AnotherProduct implements FactoryPattern_21_Product {

	// Registration done inside the product classes
	static {
		FactoryPattern_2_WithClassRegistrationUsingReflection.getInstance().registerProduct("Prod2",
				FactoryPattern_23_AnotherProduct.class);
	}

}