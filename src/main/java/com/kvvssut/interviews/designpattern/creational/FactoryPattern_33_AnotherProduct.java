package com.kvvssut.interviews.designpattern.creational;

public class FactoryPattern_33_AnotherProduct implements FactoryPattern_31_Product {

	// Registration done inside the product classes
	static {
		FactoryPattern_3_WithClassRegistrationWithoutReflection.getInstance().registerProduct("Prod2",
				new FactoryPattern_33_AnotherProduct());
	}

	@Override
	public FactoryPattern_31_Product createProduct() {
		return new FactoryPattern_33_AnotherProduct();
	}

}