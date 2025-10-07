package com.kvvssut.interviews.codinground.java;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Example program where multiple threads print numbers alternately.
 * Each thread takes its turn based on thread ID.
 */
public class NThreadsSequential {
    public static void main(String[] args) throws InterruptedException {
        int numThreads = 4;  // Number of threads
        int maxCount = numThreads * 10;   // Total numbers to print across all threads

        // Shared task across all threads
        PrintTask task = new PrintTask(numThreads, maxCount);

        // Create and start threads
        Thread[] threads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(task, "Thread-" + i);
            threads[i].start();
        }

        // Wait for all threads to complete
        for (Thread t : threads) {
            t.join();
        }
    }
}

/**
 * Runnable task that ensures threads print numbers alternately.
 */
class PrintTask implements Runnable {
    private final Object lock = new Object(); // Common lock for synchronization
    private final int numThreads;             // Total number of threads
    private final int maxCount;               // Maximum number to print
    private final AtomicInteger counter = new AtomicInteger(0); // Shared counter

    public PrintTask(int numThreads, int maxCount) {
        this.numThreads = numThreads;
        this.maxCount = maxCount;
    }

    @Override
    public void run() {
        // Extract thread ID from its name (Thread-0 → 0, Thread-1 → 1, etc.)
        int threadId = Integer.parseInt(Thread.currentThread().getName().split("-")[1]);

        while (true) {
            synchronized (lock) {
                // Wait until it's this thread's turn OR counter has reached the limit
                while (counter.get() < maxCount && counter.get() % numThreads != threadId) {
                    try {
                        lock.wait(); // Release lock and wait for notification
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt(); // Restore interrupt flag
                        return; // Exit gracefully
                    }
                }

                // If max count is reached, wake up others and exit
                if (counter.get() >= maxCount) {
                    lock.notifyAll();
                    break;
                }

                // Increment and print the number
                int value = counter.incrementAndGet();
                System.out.println(Thread.currentThread().getName() + " prints: " + value);

                // Notify other waiting threads
                lock.notifyAll();
            }
        }
    }
}
