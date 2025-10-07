package com.kvvssut.interviews.codinground.java;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadNamingExamples {

    public static void main(String[] args) throws Exception {

        System.out.println("=== 1. Manual Thread with Constructor Name ===");
        Thread t1 = new Thread(() -> System.out.println(Thread.currentThread().getName()), "ManualThread-1");
        t1.start();
        t1.join();


        System.out.println("\n=== 2. Manual Thread using setName() ===");
        Thread t2 = new Thread(() -> System.out.println(Thread.currentThread().getName()));
        t2.setName("ManualThread-2");
        t2.start();
        t2.join();


        System.out.println("\n=== 3. ExecutorService with Custom ThreadFactory ===");

        AtomicInteger poolCount = new AtomicInteger(1);

        ThreadFactory namedFactory = r -> {
            Thread t = new Thread(r);
            t.setName("custom-exec-thread-" + poolCount.getAndIncrement());
            return t;
        };

        ExecutorService executor = Executors.newFixedThreadPool(2, namedFactory);
        executor.submit(() -> System.out.println(Thread.currentThread().getName()));
        executor.submit(() -> System.out.println(Thread.currentThread().getName()));
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.SECONDS);


        System.out.println("\n=== 4. ThreadPoolExecutor with Custom ThreadFactory ===");

        ThreadFactory tpeFactory = r -> {
            Thread t = new Thread(r);
            t.setName("tpe-thread-" + System.nanoTime());
            return t;
        };

        ExecutorService tpe = new ThreadPoolExecutor(
                1, 2,
                30, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),
                tpeFactory
        );

        tpe.submit(() -> System.out.println(Thread.currentThread().getName()));
        tpe.shutdown();
        tpe.awaitTermination(1, TimeUnit.SECONDS);


        System.out.println("\n=== 5. ForkJoinPool with Custom Naming ===");

        ForkJoinPool forkJoinPool = new ForkJoinPool(
                2,
                pool -> {
                    ForkJoinWorkerThread thread = ForkJoinPool.defaultForkJoinWorkerThreadFactory.newThread(pool);
                    thread.setName("fj-thread-" + thread.getPoolIndex());
                    return thread;
                },
                null,
                false
        );

        forkJoinPool.submit(() -> System.out.println(Thread.currentThread().getName())).get();
        forkJoinPool.shutdown();


        System.out.println("\n=== 6. Virtual Thread with Named Builder (Java 21+) ===");

        Thread vThread = Thread.ofVirtual().name("vthread-", 0).start(() ->
                System.out.println(Thread.currentThread().getName())
        );
        vThread.join();


        System.out.println("\nAll thread naming styles demonstrated!");
    }
}
