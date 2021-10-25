package com.kvvssut.interviews.java.threads;

public class TwoThreadsPrintingAlternateOddEvenNumbers {

	public static void main(String[] args) throws InterruptedException {
		Object lock = new Object();

		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 1; i < 100;) {
					synchronized (lock) {
						try {
							System.out.println(Thread.currentThread().getName() + " printed - " + i);
							lock.notify();
							lock.wait(); // wait has to be below notify - else will result in deadlock
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					i += 2;
				}
			}
		}, "Thread1").start();

		Thread.sleep(1000);

		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 2; i <= 100;) {
					synchronized (lock) {
						try {
							System.out.println(Thread.currentThread().getName() + " printed - " + i);
							lock.notify();
							lock.wait(); // wait has to be below notify - else will result in deadlock
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					i += 2;
				}

			}
		}, "Thread2").start();
	}

}
