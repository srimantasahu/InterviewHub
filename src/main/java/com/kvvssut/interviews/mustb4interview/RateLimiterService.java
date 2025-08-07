package com.kvvssut.interviews.mustb4interview;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class RateLimiterService {

    private static final long ONE_MINUTE_IN_MILLIS = 60 * 1000L;

    // Tier limit mapping
    private enum Tier {
        SILVER(1000), GOLD(3000), PLATINUM(10000);

        final int limit;

        Tier(int limit) {
            this.limit = limit;
        }
    }

    // Rate limiter per client
    private static class RateLimiter {
        private final int maxRequestsPerMinute;
        private AtomicInteger requestCount = new AtomicInteger(0);
        private volatile long windowStart;

        public RateLimiter(int maxRequestsPerMinute) {
            this.maxRequestsPerMinute = maxRequestsPerMinute;
            this.windowStart = System.currentTimeMillis();
        }

        public synchronized boolean allowRequest() {
            long now = System.currentTimeMillis();
            if (now - windowStart >= ONE_MINUTE_IN_MILLIS) {
                // reset window
                windowStart = now;
                requestCount.set(0);
            }

            if (requestCount.get() < maxRequestsPerMinute) {
                requestCount.incrementAndGet();
                return true;
            }
            return false;
        }
    }

    private final ConcurrentHashMap<String, RateLimiter> clientLimiters = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Tier> clientTiers = new ConcurrentHashMap<>();

    // Register client with tier
    public void registerClient(String clientId, String tierName) {
        Tier tier = Tier.valueOf(tierName.toUpperCase());
        clientTiers.put(clientId, tier);
        clientLimiters.put(clientId, new RateLimiter(tier.limit));
    }

    // Check if request is allowed
    public boolean isRequestAllowed(String clientId) {
        if (!clientLimiters.containsKey(clientId)) {
            throw new IllegalArgumentException("Client not registered");
        }
        return clientLimiters.get(clientId).allowRequest();
    }

    // Example Usage
    public static void main(String[] args) throws InterruptedException {
        RateLimiterService service = new RateLimiterService();

        service.registerClient("client1", "silver");
        service.registerClient("client2", "gold");

        for (int i = 1; i < 1100; i++) {
            boolean allowed = service.isRequestAllowed("client1");
            if (!allowed) {
                System.out.println("client1 - rate limit exceeded at " + i);
                break;
            }
        }

        for (int i = 1; i < 3100; i++) {
            boolean allowed = service.isRequestAllowed("client2");
            if (!allowed) {
                System.out.println("client2 - rate limit exceeded at " + i);
                break;
            }
        }
    }
}
