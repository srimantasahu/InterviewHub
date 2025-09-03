package com.kvvssut.interviews.mustb4interview;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Classic Producer-Consumer problem using wait() / notifyAll().
 * <p>
 * - One Producer thread produces items until the queue is full.
 * - One Consumer thread consumes items until the queue is empty.
 * - Synchronization is achieved using the monitor lock on the shared list.
 */
public class ProducerConsumer {

    public static void main(String[] args) throws InterruptedException {
        final int capacity = 5;
        final List<Integer> items = new LinkedList<>(); // Queue-like behavior

        Producer producer = new Producer(capacity, items);
        Consumer consumer = new Consumer(items);

        Thread producerThread = new Thread(() -> {
            for (int i = 0; i <= 20; i++) {
                try {
                    producer.produce(i);
                    System.out.println("Produced item: " + i);
                    Thread.sleep(new Random().nextInt(300)); // Simulate variable work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread consumerThread = new Thread(() -> {
            for (int i = 0; i <= 20; i++) {
                try {
                    int val = consumer.consume();
                    System.out.println("Consumed item: " + val);
                    Thread.sleep(new Random().nextInt(500)); // Simulate variable work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();
    }
}

/**
 * Producer: Produces integers until the shared queue is full.
 */
class Producer {
    private final int capacity;
    private final List<Integer> items;

    public Producer(int capacity, List<Integer> items) {
        this.capacity = capacity;
        this.items = items;
    }

    public void produce(int value) throws InterruptedException {
        synchronized (items) {
            // Use while (not if) to handle spurious wakeups
            while (items.size() == capacity) {
                System.out.println("Queue full, producer waiting...");
                items.wait(); // wait until consumer consumes
            }
            items.add(value);
            items.notifyAll(); // wake up waiting consumers
        }
    }
}

/**
 * Consumer: Consumes integers until the shared queue is empty.
 */
class Consumer {
    private final List<Integer> items;

    public Consumer(List<Integer> items) {
        this.items = items;
    }

    public int consume() throws InterruptedException {
        synchronized (items) {
            // Use while (not if) to handle spurious wakeups
            while (items.isEmpty()) {
                System.out.println("Queue empty, consumer waiting...");
                items.wait(); // wait until producer produces
            }
            int val = items.removeFirst(); // remove first element
            items.notifyAll(); // wake up waiting producers
            return val;
        }
    }
}
