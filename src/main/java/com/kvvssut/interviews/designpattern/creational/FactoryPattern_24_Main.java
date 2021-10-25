package com.kvvssut.interviews.designpattern.creational;

class FactoryPattern_24_Main {

	/*
	 * We have to make sure that the concrete product classes are loaded before
	 * they are required by the factory for registration(if they are not loaded
	 * they will not be registered in the factory and createProduct will return
	 * null). To ensure it we are going to use the Class.forName method right in
	 * the static section of the main class. This section is executed right
	 * after the main class is loaded. Class.forName is supposed to return a
	 * Class instance of the indicated class. If the class is not loaded by the
	 * compiler yet, it will be loaded when the Class.forName is invoked.
	 * Consequently the static block in each class will be executed when each
	 * class is loaded.
	 */

	static {
		try {
			Class.forName("OneProduct");
			Class.forName("AnotherProduct");
		} catch (ClassNotFoundException any) {
			any.printStackTrace();
		}
	}

	public static void main(String args[]) {
		// do something
	}

	/*
	 * This reflection implementation has its own drawbacks. The main one is
	 * performance. When the reflection is used the performance on code
	 * involving reflection can decrease even to 10% of the performance of a non
	 * reflection code. Another issue is that not all the programming languages
	 * provide reflection mechanism.
	 */
}