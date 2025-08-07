package com.kvvssut.interviews.mustb4interview;

import java.util.*;
import java.util.concurrent.*;

public class SlidingWindowRateLimiter {

    private static final long WINDOW_SIZE_IN_MS = 60 * 1000L;

    // Define client tiers
    private enum Tier {
        SILVER(1000), GOLD(3000), PLATINUM(10000);

        final int limit;

        Tier(int limit) {
            this.limit = limit;
        }
    }

    // Per-client rate limiter with sliding window
    private static class ClientRequestLog {
        private final Deque<Long> timestamps = new ArrayDeque<>();
        private final int maxRequests;

        public ClientRequestLog(int maxRequests) {
            this.maxRequests = maxRequests;
        }

        // synchronized to ensure thread safety
        public synchronized boolean allowRequest() {
            long now = System.currentTimeMillis();

            // Remove timestamps older than 60 seconds
            while (!timestamps.isEmpty() && (now - timestamps.peekFirst()) >= WINDOW_SIZE_IN_MS) {
                timestamps.pollFirst();
            }

            if (timestamps.size() < maxRequests) {
                timestamps.addLast(now);
                return true;
            } else {
                return false;
            }
        }
    }

    // Maps client ID to their log and tier
    private final ConcurrentHashMap<String, ClientRequestLog> clientLogs = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Tier> clientTiers = new ConcurrentHashMap<>();

    // Register a client with a tier
    public void registerClient(String clientId, String tierName) {
        Tier tier = Tier.valueOf(tierName.toUpperCase());
        clientTiers.put(clientId, tier);
        clientLogs.put(clientId, new ClientRequestLog(tier.limit));
    }

    // Check if the request is allowed
    public boolean isRequestAllowed(String clientId) {
        if (!clientLogs.containsKey(clientId)) {
            throw new IllegalArgumentException("Client not registered: " + clientId);
        }
        return clientLogs.get(clientId).allowRequest();
    }

    // Demo usage
    public static void main(String[] args) throws InterruptedException {
        SlidingWindowRateLimiter limiter = new SlidingWindowRateLimiter();

        limiter.registerClient("client1", "silver");
        limiter.registerClient("client2", "gold");

        // Simulate requests
        for (int i = 1; i < 1100; i++) {
            if (!limiter.isRequestAllowed("client1")) {
                System.out.println("client1 - rate limit exceeded at request " + i);
                break;
            }
        }

        for (int i = 1; i < 3100; i++) {
            if (!limiter.isRequestAllowed("client2")) {
                System.out.println("client2 - rate limit exceeded at request " + i);
                break;
            }
        }
    }
}
