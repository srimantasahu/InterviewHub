package com.kvvssut.interviews.designpattern.creational;

public class SingletonPattern_2_WithLazyInitialization {

	/*
	 * Lazy instantiation using double locking mechanism.
	 * 
	 * The standard implementation shown in the above code is a thread safe
	 * implementation, but it's not the best thread-safe implementation because
	 * synchronization is very expensive when we are talking about the
	 * performance. We can see that the synchronized method getInstance does not
	 * need to be checked for synchronization after the object is initialized.
	 * If we see that the singleton object is already created we just have to
	 * return it without using any synchronized block. This optimization consist
	 * in checking in an unsynchronized block if the object is null and if not
	 * to check again and create it in an synchronized block. This is called
	 * double locking mechanism.
	 * 
	 * In this case case the singleton instance is created when the
	 * getInstance() method is called for the first time. This is called lazy
	 * instantiation and it ensures that the singleton instance is created only
	 * when it is needed.
	 */

	private static SingletonPattern_2_WithLazyInitialization instance;

	private SingletonPattern_2_WithLazyInitialization() {
		// initialization
	}

	public static SingletonPattern_2_WithLazyInitialization getInstance2() {
		if (instance == null) {
			synchronized (SingletonPattern_2_WithLazyInitialization.class) {
				if (instance == null) {
					System.out.println("getInstance(): First time getInstance was invoked!");
					instance = new SingletonPattern_2_WithLazyInitialization();
				}
			}
		}

		return instance;
	}

	public void doSomething() {
		// do something
	}

}
