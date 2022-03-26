package com.kvvssut.interviews.problemsolving.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

class DataPartitions {

    private final Integer[] data;
    private final Map<Integer, Lock> locks;

    private final int dataSize;
    private final int partitions;
    private final int itemsPerPartitions;

    public DataPartitions(int dataSize, int partitions) {
        this.dataSize = dataSize;
        this.partitions = partitions;
        this.itemsPerPartitions = (dataSize % partitions == 0) ? (dataSize / partitions) : (1 + dataSize / partitions);
        this.data = new Integer[dataSize];
        this.locks = new HashMap<>();

        IntStream.range(0, partitions).forEach(i -> {
            locks.put(i, new ReentrantLock(true));
        });
    }

    public void addData() {
        while (true) {
            for (int i = 0; i < partitions; i++) {
                Lock lock = locks.get(i);
                try {
                    if (lock.tryLock(100, TimeUnit.MILLISECONDS)) {
                        System.out.println("\n" + Thread.currentThread().getName() + " - acquired lock for partition: " + i);
                        try {
                            for (int j = 0; j < itemsPerPartitions; j++) {
                                int index = i * itemsPerPartitions + j;
                                if (index < dataSize) {
                                    if (data[index] == null) {
                                        data[index] = new Random().nextInt();
                                        System.out.println(Thread.currentThread().getName() + " - added data at index: " + index);
                                    }
                                }
                            }
                        } finally {
                            lock.unlock();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public void removeData() {
        while (true) {
            for (int i = 0; i < partitions; i++) {
                Lock lock = locks.get(i);
                try {
                    if (lock.tryLock(100, TimeUnit.MILLISECONDS)) {
                        System.out.println("\n" + Thread.currentThread().getName() + " - acquired lock for partition: " + i);
                        try {
                            for (int j = 0; j < itemsPerPartitions; j++) {
                                int index = i * itemsPerPartitions + j;
                                if (index < dataSize) {
                                    if (data[index] != null) {
                                        data[index] = null;
                                        System.out.println(Thread.currentThread().getName() + " - removed data from index: " + index);
                                    }
                                }
                            }
                        } finally {
                            lock.unlock();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

public class AdvancedProducerConsumerForPartitions {

    public static void main(String[] args) {
        DataPartitions dataPartitions = new DataPartitions(5, 2);

        Thread t1 = new Thread(dataPartitions::addData, "Thread 1");
        Thread t2 = new Thread(dataPartitions::removeData, "Thread 2");

        t1.start();
        t2.start();
    }

}
