package com.kvvssut.interviews.designpattern.creational;

public class SingletonPattern_3_WithEarlyInitialization {

	/*
	 * Early instantiation using implementation with static field
	 * 
	 * In the following implementation the singleton object is instantiated when
	 * the class is loaded and not when it is first used, due to the fact that
	 * the instance member is declared static. This is why we don't need to
	 * synchronize any portion of the code in this case. The class is loaded
	 * once this guarantee the uniqueness of the object.
	 */

	private static SingletonPattern_3_WithEarlyInitialization instance = new SingletonPattern_3_WithEarlyInitialization();

	private SingletonPattern_3_WithEarlyInitialization() {
		// initialization
	}

	public static SingletonPattern_3_WithEarlyInitialization getInstance() {
		return instance;
	}

	public void doSomething() {
		// do something
	}

}
