package com.kvvssut.interviews.designpattern.creational;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class FactoryPattern_2_WithClassRegistrationUsingReflection {

	/*
	 * The standard implementation is the most simple and intuitive (Let's call
	 * it noob implementation). The problem here is that once we add a new
	 * concrete product call we should modify the Factory class. It is not very
	 * flexible and it violates open close principle. Of course we can subclass
	 * the factory class, but let's not forget that the factory class is usually
	 * used as a singleton. Sub-classing it means replacing all the factory
	 * class references everywhere through the code.
	 * 
	 * Class Registration - using reflection -
	 * 
	 * If we can use reflection, we can register new product classes to the
	 * factory without even changing the factory itself. For creating objects
	 * inside the factory class without knowing the object type we keep a map
	 * between the productID and the class type of the product. In this case
	 * when a new product is added to the application it has to be registered to
	 * the factory. This operation doesn't require any change in the factory
	 * class code.
	 * 
	 */

	private static FactoryPattern_2_WithClassRegistrationUsingReflection instance = new FactoryPattern_2_WithClassRegistrationUsingReflection();

	private Map<String, Class<? extends FactoryPattern_21_Product>> m_RegisteredProducts = new HashMap<String, Class<? extends FactoryPattern_21_Product>>();

	public void registerProduct(String productID, Class productClass) {
		m_RegisteredProducts.put(productID, productClass);
	}

	public FactoryPattern_21_Product createProduct(String productID) {
		Class productClass = (Class) m_RegisteredProducts.get(productID);
		Constructor productConstructor = null;
		try {
			productConstructor = productClass.getDeclaredConstructor(new Class[] { String.class });
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		try {
			return (FactoryPattern_21_Product) productConstructor.newInstance(new Object[] {});
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static FactoryPattern_2_WithClassRegistrationUsingReflection getInstance() {
		return instance;
	}

	/*
	 * We can put the registration code anywhere in our code, but a convenient
	 * place is inside the product class in a static constructor
	 */

	// Registration done outside of product classes
	public static void main(String[] args) {
		FactoryPattern_2_WithClassRegistrationUsingReflection.getInstance().registerProduct("Prod1",
				FactoryPattern_22_OneProduct.class);
	}

}
