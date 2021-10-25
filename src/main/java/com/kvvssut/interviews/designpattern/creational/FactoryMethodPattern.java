package com.kvvssut.interviews.designpattern.creational;

/*
 * Also known as Virtual Constructor, the Factory Method is related to the
 * idea on which libraries work: a library uses abstract classes for
 * defining and maintaining relations between objects. One type of
 * responsibility is creating such objects. The library knows when an object
 * needs to be created, but not what kind of object it should create, this
 * being specific to the application using the library.
 * 
 * The Factory method works just the same way: it defines an interface for
 * creating an object, but leaves the choice of its type to the subclasses,
 * creation being deferred at run-time.
 * 
 * Intent
 * 
 * 1. Defines an interface for creating objects, but let subclasses to
 * decide which class to instantiate
 * 
 * 2. Refers to the newly created object through a common interface
 */

interface Product {
}

abstract class Creator {
	public void anOperation() {
		Product product = factoryMethod();
	}

	protected abstract Product factoryMethod();
}

class ConcreteProduct implements Product {
}

class ConcreteCreator extends Creator {
	protected Product factoryMethod() {
		return new ConcreteProduct();
	}
}

public class FactoryMethodPattern {
	public static void main(String arg[]) {
		Creator creator = new ConcreteCreator();
		creator.anOperation();
	}

}

/*
 * The main reason for which the factory pattern is used is that it introduces a
 * separation between the application and a family of classes (it introduces
 * weak coupling instead of tight coupling hiding concrete classes from the
 * application). It provides a simple way of extending the family of products
 * with minor changes in application code.
 * 
 * When you design an application just think if you really need it a factory to
 * create objects. Maybe using it will bring unnecessary complexity in your
 * application. Anyway if you have many object of the same base type and you
 * manipulate them mostly as abstract objects, then you need a factory. Else
 * you're code should have a lot of code like the following, reconsider it.
 * 
 * if (genericProduct typeof ConcreteProduct)
 * 	((ConcreteProduct)genericProduct).doSomeConcreteOperation();
 */
