package com.kvvssut.interviews.interviewprep.codinground.java;

/*
    Given a list of stock's (timestamp, stock, price, vol) info, find out latest price, max price, min price, total volume, VWAP.
 */

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StockTradeAnalytics {

    private record StockPriceVolMetrics(long latestTimestamp, double latestPrice, double maxPrice, double minPrice,
                                        long totalVolume, double cumulativePriceVolMultiplier) {
    }

    private final Map<String, StockPriceVolMetrics> cache;

    public StockTradeAnalytics() {
        cache = new ConcurrentHashMap<>();
    }

    public void addTrade(long timestamp, String stock, double price, int vol) {
        StockPriceVolMetrics metrics;
        if (cache.containsKey(stock)) {
            StockPriceVolMetrics old = cache.get(stock);
            metrics = new StockPriceVolMetrics(
                    Math.max(timestamp, old.latestTimestamp),
                    timestamp > old.latestTimestamp ? price : old.latestPrice,
                    Math.max(price, old.maxPrice),
                    Math.min(price, old.minPrice),
                    old.totalVolume + vol,
                    old.cumulativePriceVolMultiplier + price * vol);
        } else {
            metrics = new StockPriceVolMetrics(timestamp, price, price, price, vol, price * vol);
        }
        cache.put(stock, metrics);
    }

    public double getLatestPrice(String stock) {
        return cache.containsKey(stock) ? cache.get(stock).latestPrice : -999;
    }

    public double getMaxPrice(String stock) {
        return cache.containsKey(stock) ? cache.get(stock).maxPrice : -999;
    }

    public double getMinPrice(String stock) {
        return cache.containsKey(stock) ? cache.get(stock).minPrice : -999;
    }

    public long getTotalVolume(String stock) {
        return cache.containsKey(stock) ? cache.get(stock).totalVolume : -999;
    }

    public double getVWAP(String stock) {
        if (cache.containsKey(stock)) {
            StockPriceVolMetrics metrics = cache.get(stock);
            return metrics.cumulativePriceVolMultiplier / metrics.totalVolume;
        }
        return 0;
    }

    public static void main(String[] args) {
        StockTradeAnalytics stockTradeAnalytics = new StockTradeAnalytics();
        // add trades
        stockTradeAnalytics.addTrade(1, "AAPL", 150, 100);
        stockTradeAnalytics.addTrade(2, "AAPL", 200, 50);
        stockTradeAnalytics.addTrade(3, "MSN", 100, 200);
        stockTradeAnalytics.addTrade(4, "AAPL", 160, 100);
        stockTradeAnalytics.addTrade(5, "MSN", 120, 50);

        // get latest price
        System.out.println(stockTradeAnalytics.getLatestPrice("AAPL")); // 160.0
        System.out.println(stockTradeAnalytics.getLatestPrice("MSN"));  // 120.0

        // get max price
        System.out.println(stockTradeAnalytics.getMaxPrice("AAPL"));    // 200.0
        System.out.println(stockTradeAnalytics.getMaxPrice("MSN"));     // 120.0

        // get min price
        System.out.println(stockTradeAnalytics.getMinPrice("AAPL"));    // 150.0
        System.out.println(stockTradeAnalytics.getMinPrice("MSN"));     // 100.0

        // get total volume
        System.out.println(stockTradeAnalytics.getTotalVolume("AAPL")); // 250
        System.out.println(stockTradeAnalytics.getTotalVolume("MSN"));  // 250

        // get VWAP - volume weighted average price
        System.out.println(stockTradeAnalytics.getVWAP("AAPL"));        // 164.0
        System.out.println(stockTradeAnalytics.getVWAP("MSN"));         // 104.0
    }

}