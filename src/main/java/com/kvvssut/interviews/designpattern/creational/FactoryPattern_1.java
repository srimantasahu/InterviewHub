package com.kvvssut.interviews.designpattern.creational;

public class FactoryPattern_1 {

	/*
	 * Intent - creates objects without exposing the instantiation logic to the
	 * client. Refers to the newly created object through a common interface.
	 * 
	 * The implementation is really simple - The client needs a product, but
	 * instead of creating it directly using the new operator, it asks the
	 * factory object for a new product, providing the information about the
	 * type of object it needs. The factory instantiates a new concrete product
	 * and then returns to the client the newly created product(casted to
	 * abstract product class). The client uses the products as abstract
	 * products without being aware about their concrete implementation.
	 */

	public class ProductFactory {

		public Product createProduct(String productId) {
			if (productId.equals("prod1")) {
				return new OneProduct();
			} else if (productId.equals("prod2")) {
				return new AnotherProduct();
			}
			// so on for the other Ids

			return null; // if the id doesn't have any of the expected values
		}

	}

	public interface Product {
		public String getProductId();
	}

	public class OneProduct implements Product {

		public String getProductId() {
			return "prod1";
		}

	}

	public class AnotherProduct implements Product {

		public String getProductId() {
			return "prod2";
		}

	}

	/*
	 * Applicability & Examples - For example a graphical application works with
	 * shapes. In our implementation the drawing framework is the client and the
	 * shapes are the products. All the shapes are derived from an abstract
	 * shape class (or interface). The Shape class defines the draw and move
	 * operations which must be implemented by the concrete shapes. Let's assume
	 * a command is selected from the menu to create a new Circle. The framework
	 * receives the shape type as a string parameter, it asks the factory to
	 * create a new shape sending the parameter received from menu. The factory
	 * creates a new circle and returns it to the framework, casted to an
	 * abstract shape. Then the framework uses the object as casted to the
	 * abstract class without being aware of the concrete object type.
	 * 
	 * The advantage is obvious: New shapes can be added without changing a
	 * single line of code in the framework(the client code that uses the shapes
	 * from the factory).
	 * 
	 */

}
