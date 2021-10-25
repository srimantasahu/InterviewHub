package com.kvvssut.interviews.designpattern.creational;

/*
 * Modularization is a big issue in today's programming. Programmers all
 * over the world are trying to avoid the idea of adding code to existing
 * classes in order to make them support encapsulating more general
 * information.
 * 
 * The Factory method works just the same way: it defines an interface for
 * creating an object, but leaves the choice of its type to the subclasses,
 * creation being deferred at run-time.
 * 
 * Intent
 * 
 * Abstract Factory offers the interface for creating a family of related
 * objects, without explicitly specifying their classes.
 * 
 */
abstract class AbstractProductA {
	public abstract void operationA1();

	public abstract void operationA2();
}

class ProductA1 extends AbstractProductA {
	ProductA1(String arg) {
		System.out.println("Hello " + arg);
	} // Implement the code here

	public void operationA1() {
	};

	public void operationA2() {
	};
}

class ProductA2 extends AbstractProductA {
	ProductA2(String arg) {
		System.out.println("Hello " + arg);
	} // Implement the code here

	public void operationA1() {
	};

	public void operationA2() {
	};
}

abstract class AbstractProductB {
	// public abstract void operationB1();
	// public abstract void operationB2();
}

class ProductB1 extends AbstractProductB {
	ProductB1(String arg) {
		System.out.println("Hello " + arg);
	} // Implement the code here
}

class ProductB2 extends AbstractProductB {
	ProductB2(String arg) {
		System.out.println("Hello " + arg);
	} // Implement the code here
}

abstract class AbstractFactory {
	abstract AbstractProductA createProductA();

	abstract AbstractProductB createProductB();
}

class ConcreteFactory1 extends AbstractFactory {
	AbstractProductA createProductA() {
		return new ProductA1("ProductA1");
	}

	AbstractProductB createProductB() {
		return new ProductB1("ProductB1");
	}
}

class ConcreteFactory2 extends AbstractFactory {
	AbstractProductA createProductA() {
		return new ProductA2("ProductA2");
	}

	AbstractProductB createProductB() {
		return new ProductB2("ProductB2");
	}
}

// Factory creator - an indirect way of instantiating the factories
class FactoryMaker {
	private static AbstractFactory pf = null;

	static AbstractFactory getFactory(String choice) {
		if (choice.equals("a")) {
			pf = new ConcreteFactory1();
		} else if (choice.equals("b")) {
			pf = new ConcreteFactory2();
		}
		return pf;
	}
}

// Client
public class AbstractFactoryPattern {
	public static void main(String args[]) {
		AbstractFactory pf = FactoryMaker.getFactory("a");
		AbstractProductA product = pf.createProductA();
		// more function calls on product
	}
}

/*
 * The AbstractFactory class is the one that determines the actual type of the
 * concrete object and creates it, but it returns an abstract pointer to the
 * concrete object just created. This determines the behavior of the client that
 * asks the factory to create an object of a certain abstract type and to return
 * the abstract pointer to it, keeping the client from knowing anything about
 * the actual creation of the object.
 * 
 * The fact that the factory returns an abstract pointer to the created object
 * means that the client doesn't have knowledge of the object's type. This
 * implies that there is no need for including any class declarations relating
 * to the concrete type, the client dealing at all times with the abstract type.
 * The objects of the concrete type, created by the factory, are accessed by the
 * client only through the abstract interface.
 * 
 * The second implication of this way of creating objects is that when the
 * adding new concrete types is needed, all we have to do is modify the client
 * code and make it use a different factory, which is far easier than
 * instantiating a new type, which requires changing the code wherever a new
 * object is created.
 */
