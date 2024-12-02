package com.kvvssut.interviews.problemsolving.java;

class Sample {

    public void methodA() {
        System.out.println("Print A");
    }

    public void methodB() {
        System.out.println("Print B");
    }

    public void methodC() {
        System.out.println("Print C");
    }

}

public class SequentialExecutionOfThreadsUsingJoin {

    public static void main(String[] args) throws InterruptedException {
        Sample obj = new Sample();

        Thread t1 = new Thread(obj::methodA);
        Thread t2 = new Thread(obj::methodB);
        Thread t3 = new Thread(obj::methodC);

        t1.start();
        t1.join();

        t2.start();
        t2.join();

        t3.start();
        t3.join(2000); // means wait at most 2000 ms for t3 to finish,
        // else continue processing further instructions
    }

}
