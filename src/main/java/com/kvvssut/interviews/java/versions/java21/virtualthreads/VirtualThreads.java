package com.kvvssut.interviews.java.versions.java21.virtualthreads;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/*
In previous threading model, Java’s threads directly correspond to operating system (OS) threads, resulting in limitations on the number of threads that can be created due to OS constraints.
In the traditional threading model, excessive thread creation can strain the OS and incur high costs, particularly for short-lived threads.

Java 21 introduces virtual threads, offering mapping between virtual threads and OS threads, allowing for theoretically unlimited virtual thread creation.
This innovation addresses the limitations of traditional threading models, enabling the creation of numerous threads to meet the demands of high-throughput server applications.
With virtual threads, the previous constraint on thread creation is eliminated, enabling the continuation of the thread-per-request style commonly used in server applications.

 */
public class VirtualThreads {

    /*

     */

    public static void main(String[] args) {

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.range(0, 500_000).forEach(i -> {
                executor.submit(() -> {
                    Thread.sleep(Duration.ofSeconds(1));
                    System.out.println(Thread.currentThread() + " : " + i);
                        /*
                            Output:
                            VirtualThread[#500030]/runnable@ForkJoinPool-1-worker-7 : 499992
                            VirtualThread[#500027]/runnable@ForkJoinPool-1-worker-2 : 499989
                            VirtualThread[#499479]/runnable@ForkJoinPool-1-worker-1 : 499441
                            VirtualThread[#500033]/runnable@ForkJoinPool-1-worker-7 : 499995
                            VirtualThread[#499762]/runnable@ForkJoinPool-1-worker-8 : 499724
                        */
                    return i;
                });
            });
        }   // executor.close() is called implicitly, and waits

    }

}
