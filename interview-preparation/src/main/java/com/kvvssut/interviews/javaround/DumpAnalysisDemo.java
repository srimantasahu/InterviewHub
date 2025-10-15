package com.kvvssut.interviews.javaround;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DumpAnalysisDemo {

    // A static cache that grows indefinitely (memory leak simulation)
    private static final Map<Integer, String> cache = new ConcurrentHashMap<>();

    // A lock object for contention simulation
    private static final Object lock = new Object();

    public static void main(String[] args) throws Exception {
        System.out.println("Starting DumpAnalysisDemo... PID = " + ProcessHandle.current().pid());

        // Thread pool
        ExecutorService executor = Executors.newFixedThreadPool(6);

        // Submit workers
        for (int i = 0; i < 5; i++) {
            executor.submit(new Worker(i));
        }

        // Submit a cache populator (memory pressure)
        executor.submit(new CachePopulator());

        // Keep running so we can attach JMC / VisualVM
        Thread.currentThread().join();
    }

    // Worker simulates contention by synchronizing on a lock
    static class Worker implements Runnable {
        private final int id;

        Worker(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    // Artificial delay inside synchronized block
                    try {
                        System.out.println("Worker " + id + " acquired lock.");
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

                // Outside lock
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    // CachePopulator keeps filling cache with Strings -> memory leak pattern
    static class CachePopulator implements Runnable {
        private final Random random = new Random();

        @Override
        public void run() {
            while (true) {
                int key = random.nextInt(Integer.MAX_VALUE);
                cache.put(key, "Object-" + key); // new String ensures duplication

                // Control speed of memory growth
                if (cache.size() % 10000 == 0) {
                    System.out.println("Cache size = " + cache.size());
                }

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
