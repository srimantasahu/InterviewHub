package com.kvvssut.pnlcalc.repo;

import com.kvvssut.pnlcalc.dto.Trade;

import java.util.*;

import static com.kvvssut.pnlcalc.bean.Side.SELL;

public class TraderData {

    private final String id;
    private final Map<String, Queue<Trade>> trades;
    private final Map<String, Deque<Trade>> unrealizedTrades;

    private double realizedPnl;
    private final double unrealizedPnl;
    private double peakPnl;
    private double maxDrawdown;

    public TraderData(String traderId) {
        id = traderId;
        trades = new HashMap<>();
        unrealizedTrades = new HashMap<>();
        realizedPnl = 0d;
        unrealizedPnl = 0d;
        peakPnl = 0d;
        maxDrawdown = 0d;
    }

    public synchronized void addTrade(Trade trade) {
        String symbol = trade.symbol();

        if (!trades.containsKey(symbol)) {
            Queue<Trade> tradesQueue = new ArrayDeque<>();
            tradesQueue.add(trade);
            trades.put(symbol, tradesQueue);

            Deque<Trade> realizedTradesQueue = new ArrayDeque<>();
            realizedTradesQueue.add(trade);
            unrealizedTrades.put(symbol, realizedTradesQueue);
        } else {
            trades.get(symbol).offer(trade);

            Deque<Trade> unrealizedTradesQueue = unrealizedTrades.get(symbol);

            if (unrealizedTradesQueue.peek().side() == trade.side()) {
                unrealizedTradesQueue.offer(trade);
            } else {
                // start to realize trades
                realizeTrade(trade, unrealizedTradesQueue);

                // update pnl calc metrics
                updatePnlMetrics();
            }
        }
    }

    public synchronized void updateTickerPrice(String symbol, double price) {


    }

    private void realizeTrade(Trade trade, Deque<Trade> unrealizedTradesQueue) {
        int qty = trade.qty();
        int multiplier = trade.side() == SELL ? 1 : -1;

        while (qty > 0 && !unrealizedTradesQueue.isEmpty()) {
            Trade prevTrade = unrealizedTradesQueue.poll();

            if (prevTrade.qty() >= qty) {
                realizedPnl += (qty * (prevTrade.price() - trade.price()) * multiplier);
                // if partially consumed, add the same trade at the beginning with reduced qty
                if (prevTrade.qty() > qty) {
                    unrealizedTradesQueue.offerFirst(new Trade(prevTrade.traderId(), prevTrade.side(), prevTrade.symbol(), prevTrade.qty() - qty, prevTrade.price()));
                }
                qty = 0;
            } else {
                realizedPnl += (prevTrade.qty() * (prevTrade.price() - trade.price()) * multiplier);
                qty -= prevTrade.qty();
            }
        }

        // if queue gets empty then add the remaining qty as a new trade
        if (qty > 0) {
            unrealizedTradesQueue.offer(new Trade(trade.traderId(), trade.side(), trade.symbol(), qty, trade.price()));
        }
    }


    private void updatePnlMetrics() {
        double currentPnl = realizedPnl + unrealizedPnl;

        if (peakPnl - currentPnl > maxDrawdown) {
            maxDrawdown = peakPnl - currentPnl;
        }

        if (currentPnl > peakPnl) {
            peakPnl = realizedPnl + unrealizedPnl;
        }
    }

    public String getId() {
        return id;
    }

    public double getCurrentPnl() {
        return realizedPnl + unrealizedPnl;
    }

    public double getRealizedPnl() {
        return realizedPnl;
    }

    public double getUnrealizedPnl() {
        return unrealizedPnl;
    }

    public double getMaxDrawdown() {
        return maxDrawdown;
    }

    public Map<String, Queue<Trade>> getTradesHistory() {
        return trades;
    }
}
