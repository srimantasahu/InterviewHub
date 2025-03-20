package com.kvvssut.interviews.problemsolving.askedininterview;

/*
    Given a list of stock's (timestamp, stock, price, vol) info, find out latest price, max price, min price, total volume, VWAP.
 */

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StockTradeAnalytics {

    private final Map<String, StockPriceVolMetrics> cache;

    public StockTradeAnalytics() {
        cache = new ConcurrentHashMap<>();
    }

    public void addTrade(long timestamp, String stock, double price, int vol) {
        StockPriceVolMetrics metrics;
        if (cache.containsKey(stock)) {
            metrics = cache.get(stock);
            if (timestamp > metrics.getLatestTimestamp()) {
                metrics.setLatestTimestamp(timestamp);
                metrics.setLatestPrice(price);
            }
            if (price > metrics.getMaxPrice()) metrics.setMaxPrice(price);
            if (price < metrics.getMinPrice()) metrics.setMinPrice(price);
            metrics.setTotalVolume(metrics.getTotalVolume() + vol);
            metrics.setCumPriceVolMultiplier(metrics.getCumPriceVolMultiplier() + price * vol);
        } else {
            metrics = new StockPriceVolMetrics();
            metrics.setLatestTimestamp(timestamp);
            metrics.setLatestPrice(price);
            metrics.setMaxPrice(price);
            metrics.setMinPrice(price);
            metrics.setTotalVolume(vol);
            metrics.setCumPriceVolMultiplier(price * vol);
        }
        cache.put(stock, metrics);
    }

    public double getLatestPrice(String stock) {
        return cache.containsKey(stock) ? cache.get(stock).getLatestPrice() : -999;
    }

    public double getMaxPrice(String stock) {
        return cache.containsKey(stock) ? cache.get(stock).getMaxPrice() : -999;
    }

    public double getMinPrice(String stock) {
        return cache.containsKey(stock) ? cache.get(stock).getMinPrice() : -999;
    }

    public long getTotalVolume(String stock) {
        return cache.containsKey(stock) ? cache.get(stock).getTotalVolume() : -999;
    }

    public double getVWAP(String stock) {
        if (cache.containsKey(stock)) {
            StockPriceVolMetrics metrics = cache.get(stock);
            return metrics.getCumPriceVolMultiplier() / metrics.getTotalVolume();
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

class StockPriceVolMetrics {
    private long latestTimestamp;
    private double latestPrice;
    private double maxPrice;
    private double minPrice;
    private long totalVolume;
    private double cumPriceVolMultiplier;

    public long getLatestTimestamp() {
        return latestTimestamp;
    }

    public void setLatestTimestamp(long latestTimestamp) {
        this.latestTimestamp = latestTimestamp;
    }

    public double getLatestPrice() {
        return latestPrice;
    }

    public void setLatestPrice(double latestPrice) {
        this.latestPrice = latestPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public long getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(long totalVolume) {
        this.totalVolume = totalVolume;
    }

    public double getCumPriceVolMultiplier() {
        return cumPriceVolMultiplier;
    }

    public void setCumPriceVolMultiplier(double cumPriceVolMultiplier) {
        this.cumPriceVolMultiplier = cumPriceVolMultiplier;
    }
}