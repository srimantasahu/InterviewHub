package com.kvvssut.interviews.codinground.design;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class DesignRateLimiter {

    private static final int MILLIS_PER_MINUTE = 60 * 1000;

    // Tier package for clients
    public enum ClientPackage {
        SILVER(1_000),
        GOLD(5_000),
        PLATINUM(10_000);

        private final int requestLimit;

        ClientPackage(int requestLimit) {
            this.requestLimit = requestLimit;
        }

        public int getRequestLimit() {
            return requestLimit;
        }
    }

    // Inner class to manage individual client rate limiting
    public static class RateLimiter {
        private final int limit;
        private final AtomicInteger requestCount = new AtomicInteger(0);
        private long windowStart;

        public RateLimiter(int limit) {
            this.limit = limit;
            this.windowStart = System.currentTimeMillis();
        }

        public synchronized boolean isAllowed() {
            long now = System.currentTimeMillis();

            if (now - windowStart >= MILLIS_PER_MINUTE) {
                // Reset the window
                windowStart = now;
                requestCount.set(0);
            }

            if (requestCount.get() < limit) {
                requestCount.incrementAndGet();
                return true;
            }

            return false;
        }
    }

    // Stores client and their package
    private final Map<String, ClientPackage> clientPackages = new ConcurrentHashMap<>();
    // Stores client rate limiters
    private final Map<String, RateLimiter> rateLimiters = new ConcurrentHashMap<>();

    // Register a client with a specific package
    public void registerClient(String clientName, String packageName) {
        try {
            ClientPackage clientPackage = ClientPackage.valueOf(packageName.toUpperCase());
            clientPackages.put(clientName, clientPackage);
            rateLimiters.put(clientName, new RateLimiter(clientPackage.getRequestLimit()));
            System.out.println("Client registered: " + clientName + " [" + clientPackage + "]");
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid package name: " + packageName);
        }
    }

    // Check if request is allowed
    public boolean isRequestAllowed(String clientName) {
        RateLimiter limiter = rateLimiters.get(clientName);
        if (limiter == null) {
            System.err.println("Client not registered: " + clientName);
            return false;
        }
        return limiter.isAllowed();
    }

    // Test method
    public static void main(String[] args) throws InterruptedException {
        DesignRateLimiter rateLimiterService = new DesignRateLimiter();

        // Register clients
        rateLimiterService.registerClient("C1", "SILVER");
        rateLimiterService.registerClient("C2", "GOLD");
        rateLimiterService.registerClient("C3", "PLATINUM");

        // Simulate requests
        simulateRequests(rateLimiterService, "C1", 3010);
        System.out.println("--------------------------------------");
        simulateRequests(rateLimiterService, "C2", 7510);
        System.out.println("--------------------------------------");
    }

    private static void simulateRequests(DesignRateLimiter service, String client, int totalRequests) throws InterruptedException {
        Random random = new Random();
        for (int i = 1; i <= totalRequests; i++) {
            if (!service.isRequestAllowed(client)) {
                System.out.println(client + " rate limited at request #" + i);
                Thread.sleep(random.nextInt(10) * 1000); // simulate backoff
            }
        }
    }
}
