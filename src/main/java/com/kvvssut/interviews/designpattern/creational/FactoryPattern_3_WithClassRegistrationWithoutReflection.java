package com.kvvssut.interviews.designpattern.creational;

import java.util.HashMap;
import java.util.Map;

public class FactoryPattern_3_WithClassRegistrationWithoutReflection {

	/*
	 * As we saw in the previous paragraph the factory object uses internally a
	 * HashMap to keep the mapping between parameters (in our case Strings) and
	 * concrete products class. The registration is made from outside of the
	 * factory and because the objects are created using reflection the factory
	 * is not aware of the objects types.
	 * 
	 * We don't want to use reflection but in the same time we want to have a
	 * reduced coupling between the factory and concrete products. Since the
	 * factory should be unaware of products we have to move the creation of
	 * objects outside of the factory to an object aware of the concrete
	 * products classes. That would be the concrete class itself.
	 * 
	 * We add a new abstract method in the product abstract class. Each concrete
	 * class will implement this method to create a new object of the same type
	 * as itself. We also have to change the registration method such that we'll
	 * register concrete product objects instead of Class objects.
	 */

	private static FactoryPattern_3_WithClassRegistrationWithoutReflection instance = new FactoryPattern_3_WithClassRegistrationWithoutReflection();

	private Map<String, FactoryPattern_31_Product> m_RegisteredProducts = new HashMap<String, FactoryPattern_31_Product>();

	public void registerProduct(String productID, FactoryPattern_31_Product p) {
		m_RegisteredProducts.put(productID, p);
	}

	public FactoryPattern_31_Product createProduct(String productID) {
		return ((FactoryPattern_31_Product) m_RegisteredProducts.get(productID)).createProduct();
	}

	public static FactoryPattern_3_WithClassRegistrationWithoutReflection getInstance() {
		return instance;
	}

	/*
	 * A more advanced solution - Factory design pattern with
	 * abstractions(Factory Method)
	 * 
	 * This implementation represents an alternative for the class registration
	 * implementation. Let's assume we need to add a new product to the
	 * application. For the procedural switch-case implementation we need to
	 * change the Factory class, while in the class registration implementation
	 * all we need is to register the class to the factory without actually
	 * modifying the factory class. For sure this is a flexible solution.
	 * 
	 * The procedural implementation is the classical bad example for the
	 * Open-Close Principle. As we can see there the most intuitive solution to
	 * avoid modifying the Factory class is to extend it.
	 * 
	 * This is the classic implementation of the factory method pattern. There
	 * are some drawbacks over the class registration implementation and not so
	 * many advantages:
	 * 
	 * + The derived factory method can be changed to perform additional
	 * operations when the objects are created (maybe some initialization based
	 * on some global parameters ...).
	 * 
	 * - The factory can not be used as a singleton.
	 * 
	 * - Each factory has to be initialized before using it.
	 * 
	 * - If a new object has to be added a new factory has to be created.
	 */

}
