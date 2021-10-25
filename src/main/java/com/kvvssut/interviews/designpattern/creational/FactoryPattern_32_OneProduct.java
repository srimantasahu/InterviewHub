package com.kvvssut.interviews.designpattern.creational;

public class FactoryPattern_32_OneProduct implements FactoryPattern_31_Product {

	// Registration done inside the product classes
	static {
		FactoryPattern_3_WithClassRegistrationWithoutReflection.getInstance().registerProduct("Prod1",
				new FactoryPattern_32_OneProduct());
	}

	@Override
	public FactoryPattern_31_Product createProduct() {
		return new FactoryPattern_32_OneProduct();
	}

}