package com.kvvssut.interviews.java.threads;

import java.util.concurrent.*;

class NewTask implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " - Measuring the end to end latency of client code");
    }
}

public class ExecutorsDemo {

    public static void main(String[] args) throws InterruptedException {

        exectuingMultipleThreadsWithExecutorService();

        exectuingMultipleThreadsWithThreadPoolExecutor();
    }

    private static void exectuingMultipleThreadsWithExecutorService() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(20);    // internally returns new ThreadPoolExecutor(20, 20, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        for (int i = 0; i < 100; i++) {
            executor.submit(new NewTask());
        }
        executor.shutdown();
        executor.awaitTermination(1l, TimeUnit.MINUTES);// Blocks until all tasks have completed execution after a shutdown request, or the timeout occurs, or the current thread is interrupted, whichever happens first.
    }

    private static void exectuingMultipleThreadsWithThreadPoolExecutor() throws InterruptedException {
        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<Runnable>(100);    // with ThreadPoolExecutor we can choose our implementation of the blocking queue and specify the keepAliveTime as convenient
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(20, 50, 1l, TimeUnit.MINUTES, blockingQueue);
        threadPoolExecutor.prestartAllCoreThreads();
        for (int i = 0; i < 100; i++) {
            threadPoolExecutor.execute(new NewTask());
        }
        threadPoolExecutor.shutdown();
        threadPoolExecutor.awaitTermination(1l, TimeUnit.MINUTES);    // Blocks until all tasks have completed execution after a shutdown request, or the timeout occurs, or the current thread is interrupted, whichever happens first.
    }

}
