package com.kvvssut.interviews.designpattern.creational;

/*
 * Today’s programming is all about costs. Saving is a big issue when it
 * comes to using computer resources, so programmers are doing their best to
 * find ways of improving the performance When we talk about object creation
 * we can find a better way to have new objects: cloning. If the cost of
 * creating a new object is large and creation is resource intensive, we
 * clone the object.
 * 
 * The Prototype design pattern allows an object to create customized
 * objects without knowing their class or any details of how to create them.
 * 
 * Intent
 * 
 * 1. specifying the kind of objects to create using a prototypical instance
 * 2. creating new objects by copying this prototype
 */

interface Prototype extends Cloneable {
	public abstract Object clone() throws CloneNotSupportedException;
}

class ConcretePrototype implements Prototype {
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

public class PrototypePattern {

	public static void main(String arg[]) throws CloneNotSupportedException {
		ConcretePrototype obj1 = new ConcretePrototype();
		ConcretePrototype obj2 = (ConcretePrototype) obj1.clone();
	}

}

/*
 * Deep Clones vs. Shallow Clones – when we clone complex objects which contains
 * other objects, we should take care how they are cloned. We can clone
 * contained objects also (deep cloning) or we can use the same reference for them,
 * and to share them between cloned container objects.
 */
