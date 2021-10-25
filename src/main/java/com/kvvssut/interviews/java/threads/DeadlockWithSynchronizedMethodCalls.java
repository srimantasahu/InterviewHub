package com.kvvssut.interviews.java.threads;

public class DeadlockWithSynchronizedMethodCalls {

	public static void main(String[] args) {
		DeadlockWithSynchronizedMethodCalls obj1 = new DeadlockWithSynchronizedMethodCalls();
		DeadlockWithSynchronizedMethodCalls obj2 = new DeadlockWithSynchronizedMethodCalls();

		Runnable runnable1 = new Runnable() {

			@Override
			public void run() {
				obj1.checkOther(obj2);

			}
		};
		Runnable runnable2 = new Runnable() {

			@Override
			public void run() {
				obj2.checkOther(obj1);

			}
		};

		Thread t1 = new Thread(runnable1, "Thread1");
		Thread t2 = new Thread(runnable2, "Thread2");

		t1.start();
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();
	}

	public synchronized void checkOther(DeadlockWithSynchronizedMethodCalls other) {
		System.out.println("Inside method for : " + Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Before performing action for : " + Thread.currentThread().getName());
		other.performAction(); // waits infinitely for the other to release lock
		System.out.println("After performing action for : " + Thread.currentThread().getName());
	}

	public synchronized void performAction() { // never reaches to this point as both wait for the other to get released
		System.out.println("Performed action for : " + Thread.currentThread().getName());
	}

}
