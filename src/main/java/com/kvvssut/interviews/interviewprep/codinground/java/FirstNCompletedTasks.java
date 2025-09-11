package com.kvvssut.interviews.interviewprep.codinground.java;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class FirstNCompletedTasks {

    public static void main(String[] args) throws InterruptedException {
        int numTasks = 10;
        int firstN = 3;

        // Custom thread factory to name threads as thread-1, thread-2, ...
        AtomicInteger threadId = new AtomicInteger(1);
        ExecutorService executor = Executors.newFixedThreadPool(numTasks, runnable -> {
            Thread t = new Thread(runnable);
            t.setName("thread-" + threadId.getAndIncrement());
            return t;
        });

        CompletionService<String> completionService = new ExecutorCompletionService<>(executor);

        // Submit 10 tasks with varying sleep times
        for (int i = 1; i <= numTasks; i++) {
            final int taskId = i;
            completionService.submit(() -> {
                // Random sleep between 100 and 500 ms to simulate actual processing
                int sleepTime = new Random().nextInt(400) + 100;
                Thread.sleep(sleepTime);
                return "Task " + taskId + " completed by " + Thread.currentThread().getName();
            });
        }

        // Get first N completed tasks
        for (int i = 1; i <= firstN; i++) {
            try {
                Future<String> future = completionService.take();
                System.out.println("Completed: " + future.get());
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
    }
}
