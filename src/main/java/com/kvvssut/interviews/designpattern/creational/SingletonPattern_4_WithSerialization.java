package com.kvvssut.interviews.designpattern.creational;

import java.io.Serializable;

public class SingletonPattern_4_WithSerialization implements Serializable {

	/*
	 * If the Singleton class implements the java.io.Serializable interface,
	 * when a singleton is serialized and then deserialized more than once,
	 * there will be multiple instances of Singleton created. In order to avoid
	 * this the readResolve method should be implemented.
	 */

	private static final long serialVersionUID = -3082928116874914764L;
	private static SingletonPattern_4_WithSerialization instance;

	private SingletonPattern_4_WithSerialization() {
		// initialization
	}

	public static synchronized SingletonPattern_4_WithSerialization getInstance() {
		if (instance == null) {
			instance = new SingletonPattern_4_WithSerialization();
		}

		return instance;
	}

	public void doSomething() {
		// do something
	}

	/*
	 * This method is called immediately after an object of this class is
	 * deserialized. This method returns the singleton instance.
	 */
	protected Object readResolve() {
		return getInstance();
	}

}
