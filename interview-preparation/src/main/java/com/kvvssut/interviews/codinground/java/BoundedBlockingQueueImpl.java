package com.kvvssut.interviews.codinground.java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class BoundedBlockingQueueImpl {
    public static void main(String[] args) throws InterruptedException {

        // Shared blocking queue
        BoundedBlockingQueue<Integer> queue = new BoundedBlockingQueue<>(3);

        int producerCount = 3;
        int consumerCount = 3;

        AtomicInteger counter = new AtomicInteger();

        Thread[] producers = new Thread[producerCount];
        Thread[] consumers = new Thread[consumerCount];

        // Create producers
        for (int i = 0; i < producerCount; i++) {
            producers[i] = new Thread(
                    new Producer(queue, counter, 10),
                    "Producer-" + i
            );
            producers[i].start();
        }

        // Create consumers
        for (int i = 0; i < consumerCount; i++) {
            consumers[i] = new Thread(
                    new Consumer(queue, 10),
                    "Consumer-" + i
            );
            consumers[i].start();
        }

        // Wait for all to finish
        for (Thread t : producers) t.join();
        for (Thread t : consumers) t.join();

        System.out.println("Processing completed!");
    }
}

class BoundedBlockingQueue<T> {

    private final Queue<T> queue = new LinkedList<>();
    private final int capacity;

    private final Lock lock = new ReentrantLock(true);
    private final Condition notEmpty = lock.newCondition();
    private final Condition notFull = lock.newCondition();

    public BoundedBlockingQueue(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException("Capacity must be > 0");
        this.capacity = capacity;
    }

    public void enqueue(T obj) {
        lock.lock();
        try {
            while (queue.size() == capacity) {
                log("Queue full — waiting");
                notFull.await();
            }

            queue.offer(obj);
            log("Enqueued: " + obj);

            // Wake up consumers
            notEmpty.signalAll();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);

        } finally {
            lock.unlock();
        }
    }

    public T dequeue() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                log("Queue empty — waiting");
                notEmpty.await();
            }

            T obj = queue.poll();
            log("Dequeued: " + obj);

            // Wake up producers
            notFull.signalAll();

            return obj;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);

        } finally {
            lock.unlock();
        }
    }

    public int size() {
        lock.lock();
        try {
            return queue.size();
        } finally {
            lock.unlock();
        }
    }

    private void log(String msg) {
        System.out.println(Thread.currentThread().getName() + " | " + msg);
    }
}


class Producer implements Runnable {

    private final BoundedBlockingQueue<Integer> queue;
    private final AtomicInteger counter;
    private final int iterations;

    public Producer(BoundedBlockingQueue<Integer> queue, AtomicInteger counter, int iterations) {
        this.queue = queue;
        this.counter = counter;
        this.iterations = iterations;
    }

    @Override
    public void run() {
        IntStream.rangeClosed(1, iterations)
                .forEach(i -> queue.enqueue(counter.incrementAndGet()));
    }
}

class Consumer implements Runnable {

    private final BoundedBlockingQueue<Integer> queue;
    private final int iterations;

    public Consumer(BoundedBlockingQueue<Integer> queue, int iterations) {
        this.queue = queue;
        this.iterations = iterations;
    }

    @Override
    public void run() {
        IntStream.rangeClosed(1, iterations)
                .forEach(i -> queue.dequeue());
    }
}