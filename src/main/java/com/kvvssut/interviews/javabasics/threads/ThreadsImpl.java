package com.kvvssut.interviews.javabasics.threads;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadsImpl {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // 1. thread vs runnable
        System.out.println("Current thread: " + Thread.currentThread().getName());
        // Current thread: main

        MyThread t1 = new MyThread();
        t1.start(); // Starts a new thread
        // MyThread's thread: Thread-0

        Thread t2 = new Thread(new MyRunnable());
        t2.start(); // Starts a new thread
        // MyRunnable's thread: Thread-1

        // 2. synchronized
        SharedResource resource = new SharedResource();
        new Thread(resource::incrementUsingSynchronizedMethod).start();
        new Thread(resource::incrementUsingSynchronizedBlock).start();
        new Thread(resource::incrementUsingSynchronizedLockObject).start();

        // [Synchronized Method] Thread-2: 1
        // [Synchronized Lock Object] Thread-4: 2
        // [Synchronized Method] Thread-2: 3
        // [Synchronized Lock Object] Thread-4: 4
        // [Synchronized Method] Thread-2: 5
        // [Synchronized Lock Object] Thread-4: 6
        // [Synchronized Block] Thread-3: 7
        // [Synchronized Block] Thread-3: 8
        // [Synchronized Block] Thread-3: 9

        // 3. wait, notify, join
        SimpleProducerConsumer simpleProducerConsumer = new SimpleProducerConsumer();

        Thread producer = new Thread(() -> {
            try {
                Thread.sleep(1000); // Simulate delay of 1000 ms
                simpleProducerConsumer.produce(19);
            } catch (InterruptedException e) { /* handle it */ }
        });

        Thread consumer = new Thread(() -> {
            try {
                int received = simpleProducerConsumer.consume();
            } catch (InterruptedException e) { /* handle it */ }
        });

        producer.start(); // Starts Producer thread
        consumer.start(); // Starts Consumer thread

        // Use join() to wait for both threads to finish
        producer.join(); // Main thread waits for producer to finish
        consumer.join(); // Main thread waits for consumer to finish

        System.out.println("Main thread: Producer and Consumer finished.");

        // Consumer: Waiting for data...
        // Producer: Producing data...
        // Producer: Data produced and notified.
        // Consumer: Data received = 19
        // Main thread: Producer and Consumer finished.

        // 4. volatile
        Worker worker = new Worker();
        Thread t3 = new Thread(worker::run);
        t3.start();

        // let the thread t3 run for 2 seconds
        Thread.sleep(2000);

        System.out.println("Main thread: stopping worker...");
        worker.stopRunning();

        // wait for the worker to finish
        t3.join();
        System.out.println("Main thread: worker has stopped.");

        // Thread-5: started.
        // Main thread: stopping worker...
        // Thread-5: stopped.
        // Main thread: worker has stopped.

        // 5. atomic data types
        AtomicInteger counter = new AtomicInteger(0);
        AtomicBoolean printed = new AtomicBoolean(false);

        Runnable task = () -> {
            for (int i = 0; i < 2; i++) {
                int current = counter.incrementAndGet();
                System.out.println(Thread.currentThread().getName() + ": Count = " + current);

                // Only one thread prints this when count reaches 1
                if (current >= 1 && printed.compareAndSet(false, true))
                    System.out.println(Thread.currentThread().getName() + ": Count reached 1! (printed only once)");

                // Simulate delay
                try { Thread.sleep(100); } catch (InterruptedException e) { /* handle it */ }
            }
        };

        Thread t4 = new Thread(task, "Thread-1");
        Thread t5 = new Thread(task, "Thread-2");

        t4.start(); t5.start();
        t4.join(); t5.join();

        System.out.println("Main thread: Final Count = " + counter.get());

        // Thread-2: Count = 2
        // Thread-1: Count = 1
        // Thread-2: Count reached 1! (printed only once)
        // Thread-1: Count = 3
        // Thread-2: Count = 4
        // Main thread: Final Count = 4

        // 6. ReentrantLock
        SimplePrinterQueue printer = new SimplePrinterQueue();

        Runnable colorTask = () -> printer.printJob("color");
        Runnable bwTask = () -> printer.printJob("bw");

        for (int i = 0; i < 2; i++) {
            new Thread(colorTask, "ColorThread-" + i).start();
            new Thread(bwTask, "BWThread-" + i).start();
        }

        // ColorThread-0: Printing a color job...
        // ColorThread-0: Finished printing.
        // BWThread-0: Printing a bw job...
        // BWThread-1: Could not acquire lock. Skipping bw job.
        // ColorThread-1: Could not acquire lock. Skipping color job.
        // BWThread-0: Finished printing.

        // 7. ConcurrentHashMap
        ConcurrentHashMap<String, Integer> counter1 = new ConcurrentHashMap<>();

        Runnable task1 = () -> {
            for (int i = 0; i < 1000; i++) {
                counter1.merge("count", 1, (oldVal, newVal) -> oldVal + newVal);
            }
        };

        Thread t6 = new Thread(task1);
        Thread t7 = new Thread(task1);

        t6.start(); t7.start();
        t6.join(); t7.join();

        System.out.println("Thread-safe total count: " + counter1.get("count"));

        // Thread-safe total count: 2000

        // 8. Fork/Join Framework
        int[] array = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        try (ForkJoinPool pool = ForkJoinPool.commonPool()) {
            SumTask sumTask = new SumTask(array, 0, array.length);

            long result = pool.invoke(sumTask);
            System.out.println("Sum of [1..10] = " + result);
        }

        // Sum of [1..10] = 55

        // 9. Executor Framework
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> System.out.println("Running in background"));
        ((ExecutorService) executor).shutdown();    // Hack to shut down the executor

        // Running in background

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> future = executorService.submit(new MyCallable());
        System.out.println("Task done: " + future.isDone());    // false
        System.out.println("Future result: " + future.get());   // blocks until the task is done, then prints 1
        executorService.shutdown();

        // Task done: false
        // Future result: 1

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.schedule(() -> System.out.println("Delayed task"), 1, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(() -> System.out.println("Fixed-Rate scheduled task"), 1, 1, TimeUnit.SECONDS);
        scheduler.scheduleWithFixedDelay(() -> System.out.println("Fixed-Delay scheduled task"), 1, 2, TimeUnit.SECONDS);

        Thread.sleep(3000); // Main thread sleeps for 3 seconds, so that scheduler can run a few iterations

        scheduler.shutdown();
        boolean terminated = scheduler.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("Scheduler terminated: " + terminated);

        // Delayed task
        // Fixed-Rate scheduled task
        // Fixed-Delay scheduled task
        // Fixed-Rate scheduled task
        // Fixed-Rate scheduled task
        // Fixed-Delay scheduled task
        // Scheduler terminated: true

        // Custom ThreadPoolExecutor
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(
                2,  // Core threads
                3, // Max threads
                60, // Keep-alive
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5),  // Bounded queue
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy()   // Fallback
        );

        // Submit tasks
        for (int i = 0; i < 10; i++) {
            tpe.execute(() -> {
                System.out.printf("Task running in %s [Active threads: %d, Queue size: %d, Completed tasks: %d]%n",
                        Thread.currentThread().getName(), tpe.getActiveCount(), tpe.getQueue().size(), tpe.getCompletedTaskCount());
            });
        }

        tpe.shutdown(); // Graceful shutdown

        // Task running in pool-4-thread-1 [Active threads: 2, Queue size: 0, Completed tasks: 0]
        // Task running in pool-4-thread-2 [Active threads: 2, Queue size: 5, Completed tasks: 0]
        // Task running in main [Active threads: 3, Queue size: 5, Completed tasks: 0]
        // Task running in pool-4-thread-3 [Active threads: 3, Queue size: 5, Completed tasks: 0]
        // Task running in pool-4-thread-3 [Active threads: 3, Queue size: 3, Completed tasks: 3]
        // Task running in pool-4-thread-3 [Active threads: 3, Queue size: 2, Completed tasks: 4]
        // Task running in pool-4-thread-1 [Active threads: 3, Queue size: 4, Completed tasks: 1]
        // Task running in pool-4-thread-2 [Active threads: 3, Queue size: 3, Completed tasks: 2]
        // Task running in pool-4-thread-3 [Active threads: 3, Queue size: 1, Completed tasks: 5]
        // Task running in pool-4-thread-1 [Active threads: 3, Queue size: 0, Completed tasks: 6]

    }

    static class MyThread extends Thread {
        public void run() {
            System.out.println("MyThread's thread: " + Thread.currentThread().getName());
        }
    }

    static class MyRunnable implements Runnable {
        public void run() {
            System.out.println("MyRunnable's thread: " + Thread.currentThread().getName());
        }
    }

    static class SharedResource {
        private final Object lock = new Object();
        private int count = 1;

        public synchronized void incrementUsingSynchronizedMethod() {
            for (int i = 1; i <= 3; i++) {
                System.out.println("[Synchronized Method] " + Thread.currentThread().getName() + ": " + count++);
            }
        }

        public void incrementUsingSynchronizedBlock() {
            synchronized (this) {
                for (int i = 1; i <= 3; i++) {
                    System.out.println("[Synchronized Block] " + Thread.currentThread().getName() + ": " + count++);
                }
            }
        }

        public void incrementUsingSynchronizedLockObject() {
            synchronized (lock) {
                for (int i = 1; i <= 3; i++) {
                    System.out.println("[Synchronized Lock Object] " + Thread.currentThread().getName() + ": " + count++);
                }
            }
        }
    }

    static class SimpleProducerConsumer {
        private int data;
        private boolean ready = false;

        public synchronized void produce(int value) {
            System.out.println("Producer: Producing data = " + value);
            data = value;
            ready = true;
            notify(); // Notify the waiting consumer
            System.out.println("Producer: Data produced and notified.");
        }

        public synchronized int consume() throws InterruptedException {
            while (!ready) {
                System.out.println("Consumer: Waiting for data...");
                wait(); // Wait until data is produced
            }
            System.out.println("Consumer: Data received = " + data);
            return data;
        }
    }

    static class Worker {
        private volatile boolean running = true;  // visible across threads

        public void run() {
            System.out.println(Thread.currentThread().getName() + ": started.");
            while (running) { /* simulate some work */ }
            // stops when running=false (reads from main memory)
            System.out.println(Thread.currentThread().getName() + ": stopped.");
        }

        public void stopRunning() {
            running = false;
        }
    }

    static class SimpleAtomicExample {
        static AtomicInteger counter = new AtomicInteger(0);
        static AtomicBoolean printed = new AtomicBoolean(false);

        public static void main(String[] args) throws InterruptedException {
            Runnable task = () -> {
                for (int i = 0; i < 3; i++) {
                    int current = counter.incrementAndGet();
                    System.out.println(Thread.currentThread().getName() + ": Count = " + current);

                    // Only one thread prints this when count reaches 5
                    if (current >= 3 && printed.compareAndSet(false, true))
                        System.out.println(Thread.currentThread().getName() + ": Count reached 3! (printed only once)");

                    // Simulate delay
                    try { Thread.sleep(100); } catch (InterruptedException e) { /* handle it */ }
                }
            };

            Thread t1 = new Thread(task, "Thread-1");
            Thread t2 = new Thread(task, "Thread-2");

            t1.start();
            t2.start();

            t1.join();
            t2.join();

            System.out.println("Final count: " + counter.get());
        }
    }

    static class SimplePrinterQueue {

        private final ReentrantLock lock = new ReentrantLock(true); // fair lock
        private final Condition colorQueue = lock.newCondition();
        private final Condition bwQueue = lock.newCondition();
        private boolean printerBusy = false;

        public void printJob(String jobType) {
            boolean acquired = false;
            try {
                // Try to acquire lock with timeout
                acquired = lock.tryLock(1, TimeUnit.SECONDS);
                if (!acquired) {
                    System.out.println(Thread.currentThread().getName() + ": Could not acquire lock. Skipping " + jobType + " job.");
                    return;
                }

                Condition currentCondition = jobType.equals("color") ? colorQueue : bwQueue;

                // Wait if printer is busy
                while (printerBusy) {
                    System.out.println(Thread.currentThread().getName() + ": Waiting in " + jobType + " queue.");
                    currentCondition.await(); // wait until printer is busy
                }

                // Proceed to print
                printerBusy = true;
                System.out.println(Thread.currentThread().getName() + ": Printing a " + jobType + " job...");
                Thread.sleep(500); // simulate print time

                printerBusy = false;
                System.out.println(Thread.currentThread().getName() + ": Finished printing.");

                // Notify all waiting threads
                colorQueue.signal();
                bwQueue.signal();

            } catch (InterruptedException e) {
                // handle it
            } finally {
                if (acquired) {
                    lock.unlock();
                }
            }
        }
    }

    static class SumTask extends RecursiveTask<Long> {
        private static final int THRESHOLD = 3;
        private final int[] arr;
        private final int start, end;

        public SumTask(int[] arr, int start, int end) {
            this.arr = arr;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            if (end - start <= THRESHOLD) {
                // Base case: sum directly
                long sum = 0;
                for (int i = start; i < end; i++) sum += arr[i];
                return sum;
            } else {
                // Fork
                int mid = (start + end) / 2;
                SumTask left = new SumTask(arr, start, mid);
                SumTask right = new SumTask(arr, mid, end);

                left.fork();    // run left asynchronously
                long rightResult = right.compute(); // compute right directly
                long leftResult = left.join();  // wait for left

                return leftResult + rightResult;
            }
        }
    }

    static class MyCallable implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            Thread.sleep(1000); // sleeps for a second
            return 1;
        }
    }

}
