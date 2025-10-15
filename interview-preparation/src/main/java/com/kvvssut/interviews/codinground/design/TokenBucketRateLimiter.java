package com.kvvssut.interviews.codinground.design;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TokenBucketRateLimiter {

    // Client tier limits
    private enum Tier {
        SILVER(1000), GOLD(3000), PLATINUM(10000);

        final int ratePerMinute;

        Tier(int rate) {
            this.ratePerMinute = rate;
        }

        public double getRatePerSecond() {
            return ratePerMinute / 60.0;
        }
    }

    // Token Bucket
    private static class TokenBucket {
        private final int maxTokens;
        private final double refillRatePerSec;
        private double currentTokens;
        private long lastRefillTimestamp;

        public TokenBucket(int maxTokens, double refillRatePerSec) {
            this.maxTokens = maxTokens;
            this.refillRatePerSec = refillRatePerSec;
            this.currentTokens = maxTokens; // full bucket at start
            this.lastRefillTimestamp = System.nanoTime();
        }

        // Check and refill bucket, then try to consume one token
        public synchronized boolean allowRequest() {
            refill();

            if (currentTokens >= 1) {
                currentTokens -= 1;
                return true;
            } else {
                return false;
            }
        }

        private void refill() {
            long now = System.nanoTime();
            double secondsPassed = (now - lastRefillTimestamp) / 1_000_000_000.0;
            double tokensToAdd = secondsPassed * refillRatePerSec;

            if (tokensToAdd > 0) {
                currentTokens = Math.min(maxTokens, currentTokens + tokensToAdd);
                lastRefillTimestamp = now;
            }
        }
    }

    private final Map<String, TokenBucket> clientBuckets = new ConcurrentHashMap<>();
    private final Map<String, Tier> clientTiers = new ConcurrentHashMap<>();

    public void registerClient(String clientId, String tierName) {
        Tier tier = Tier.valueOf(tierName.toUpperCase());
        clientTiers.put(clientId, tier);
        clientBuckets.put(clientId, new TokenBucket(tier.ratePerMinute, tier.getRatePerSecond()));
    }

    public boolean isRequestAllowed(String clientId) {
        TokenBucket bucket = clientBuckets.get(clientId);
        if (bucket == null) {
            throw new IllegalArgumentException("Client not registered: " + clientId);
        }
        return bucket.allowRequest();
    }

    public static void main(String[] args) throws InterruptedException {
        TokenBucketRateLimiter limiter = new TokenBucketRateLimiter();

        limiter.registerClient("client1", "silver");
        limiter.registerClient("client2", "gold");

        for (int i = 1; i < 1100; i++) {
            if (!limiter.isRequestAllowed("client1")) {
                System.out.println("client1 - request " + i + " blocked");
                break;
            }
        }

        for (int i = 1; i < 3100; i++) {
            if (!limiter.isRequestAllowed("client2")) {
                System.out.println("client2 - request " + i + " blocked");
                break;
            }
        }
    }
}
