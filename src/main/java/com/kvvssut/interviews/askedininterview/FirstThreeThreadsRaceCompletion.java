package com.kvvssut.interviews.problemsolving.askedininterview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FirstThreeThreadsRaceCompletion {

    public static void main(String[] args) throws InterruptedException {
        int numThreads = 10;
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        ExecutorCompletionService<String> completionService = new ExecutorCompletionService<>(executor);

        // Submit 10 counting tasks
        for (int i = 1; i <= numThreads; i++) {
            final int threadId = i;
            completionService.submit(() -> {
                for (int j = 1; j <= 100; j++) {
                    // Simulate work
                    Thread.sleep(10); // simulate delay per count
                }
                return "Thread-" + threadId;
            });
        }

        // Get first 3 completed threads
        List<String> firstThree = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            try {
                Future<String> result = completionService.take(); // blocks till one task completes
                String threadName = result.get();
                firstThree.add(threadName);
                System.out.println("Completed: " + threadName);
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        // Optional: shutdown the executor
        executor.shutdownNow();

        System.out.println("First 3 threads to finish: " + firstThree);
    }
}
