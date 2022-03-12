package com.kvvssut.interviews.java.threads;

public class DeadlockWithLockObjects {

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public static void main(String[] args) {
        final DeadlockWithLockObjects object = new DeadlockWithLockObjects();

        new Thread(new Runnable() {

            @Override
            public void run() {
                object.method1();
            }
        }, "Thread1").start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                object.method2();
            }
        }, "Thread2").start();
    }

    public void method1() {
        synchronized (lock1) {
            System.out.println("Executing method1 for : " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Synchronizing on lock2 from method1 for : " + Thread.currentThread().getName());
            synchronized (lock2) {
                System.out
                        .println("Synchronized on lock2 from method1 for : " + Thread.currentThread().getName());
            }
            System.out.println("Exiting method1 for thread: " + Thread.currentThread().getName());
        }
    }

    public void method2() {
        synchronized (lock2) {
            System.out.println("Executing method2 for : " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Synchronizing on lock1 from method1 for : " + Thread.currentThread().getName());
            synchronized (lock1) {
                System.out
                        .println("Synchronized on lock1 from method2 for : " + Thread.currentThread().getName());
            }
            System.out.println("Exiting method2 for thread: " + Thread.currentThread().getName());
        }
    }

}
