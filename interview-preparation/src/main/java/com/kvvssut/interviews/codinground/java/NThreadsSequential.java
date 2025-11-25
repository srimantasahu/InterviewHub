package com.kvvssut.interviews.codinground.java;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Demonstrates N threads printing numbers sequentially in round-robin order.
 * Example: 4 threads → Thread-0 prints 1, Thread-1 prints 2, Thread-2 prints 3, Thread-3 prints 4, then repeat.
 */
public class NThreadsSequential {
    public static void main(String[] args) throws InterruptedException {
        int numThreads = 4;                 // Number of threads to run
        int maxCount = numThreads * 10;     // Total numbers to print (each thread prints 10 times)

        PrintTask task = new PrintTask(numThreads, maxCount);

        Thread[] threads = new Thread[numThreads];

        // Create and start threads
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(task, "Thread-" + i);
            threads[i].start();
        }

        // Wait for all threads to complete
        for (Thread t : threads) {
            t.join();
        }

        System.out.println("All threads completed successfully.");
    }
}

/**
 * Shared runnable that coordinates threads to print numbers sequentially using a ReentrantLock and Condition.
 */
class PrintTask implements Runnable {

    private final ReentrantLock lock = new ReentrantLock();   // Explicit lock (better control than synchronized)
    private final Condition condition = lock.newCondition();  // Used to coordinate turn-based printing

    private final int numThreads;             // Total number of threads
    private final int maxCount;               // Maximum number to print
    private final AtomicInteger counter = new AtomicInteger(0);  // Shared atomic counter

    public PrintTask(int numThreads, int maxCount) {
        this.numThreads = numThreads;
        this.maxCount = maxCount;
    }

    @Override
    public void run() {
        // Extract numeric ID from thread name: e.g., Thread-2 → 2
        int threadId = Integer.parseInt(Thread.currentThread().getName().split("-")[1]);

        while (true) {
            lock.lock();  // Acquire lock before checking/updating shared state
            try {
                // Wait while it's not this thread's turn AND work is not done
                while (counter.get() < maxCount && counter.get() % numThreads != threadId) {
                    condition.await();  // Release lock and wait to be signaled
                }

                // Exit condition: once maxCount is reached, wake up others and break
                if (counter.get() >= maxCount) {
                    condition.signalAll(); // Wake up any waiting threads to let them exit
                    break;
                }

                // Increment counter and print
                int value = counter.incrementAndGet();
                System.out.println(Thread.currentThread().getName() + " prints: " + value);

                // Signal all other waiting threads that state has changed
                condition.signalAll();

            } catch (InterruptedException e) {
                // Handle thread interruption gracefully
                Thread.currentThread().interrupt();
                break;
            } finally {
                lock.unlock();  // Always release lock in finally block
            }
        }
    }
}
