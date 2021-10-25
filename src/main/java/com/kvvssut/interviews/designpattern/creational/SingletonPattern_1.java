package com.kvvssut.interviews.designpattern.creational;

public class SingletonPattern_1 {

	/*
	 * Sometimes it's important to have only one instance for a class. Usually
	 * singletons are used for centralized management of internal or external
	 * resources and they provide a global point of access to themselves.
	 * 
	 * The singleton pattern is one of the simplest design patterns: it involves
	 * only one class which is responsible to instantiate itself, to make sure
	 * it creates not more than one instance; in the same time it provides a
	 * global point of access to that instance.
	 * 
	 * Intent - Ensure that only one instance of a class is created. Provide a
	 * global point of access to the object.
	 * 
	 * Implementation - The implementation involves a static member in the
	 * "Singleton" class, a private constructor and a static public method that
	 * returns a reference to the static member.
	 * 
	 * The Singleton Pattern defines a getInstance operation which exposes the
	 * unique instance which is accessed by the clients.
	 */

	private static SingletonPattern_1 instance;

	private SingletonPattern_1() {
		// initialization
	}

	public static synchronized SingletonPattern_1 getInstance() {
		if (instance == null) {
			instance = new SingletonPattern_1();
		}

		return instance;
	}

	public void doSomething() {
		// do something
	}

	/*
	 * Applicability & Examples - According to the definition the singleton
	 * pattern should be used when there must be exactly one instance of a
	 * class, and when it must be accessible to clients from a global access
	 * point.
	 * 
	 * 1. Logger Classes - The Singleton pattern is used in the design of logger
	 * classes. This classes are usually implemented as a singletons, and
	 * provides a global logging access point in all the application components
	 * without being necessary to create an object each time a logging
	 * operations is performed.
	 * 
	 * 2. Configuration Classes - The Singleton pattern is used to design the
	 * classes which provides the configuration settings for an application. By
	 * implementing configuration classes as Singleton not only that we provide
	 * a global access point, but we also keep the instance we use as a cache
	 * object. When the class is instantiated( or when a value is read ) the
	 * singleton will keep the values in its internal structure. If the values
	 * are read from the database or from files this avoids the reloading the
	 * values each time the configuration parameters are used.
	 * 
	 * 3. Factories implemented as Singletons - Let's assume that we design an
	 * application with a factory to generate new objects(Acount, Customer,
	 * Site, Address objects) with their ids, in an multithreading environment.
	 * If the factory is instantiated twice in 2 different threads then it's
	 * possible to have 2 overlapping ids for 2 different objects. If we
	 * implement the Factory as a singleton we avoid this problem.
	 */

}
