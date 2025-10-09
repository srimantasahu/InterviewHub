package com.kvvssut.pnlcalc.repo;

import com.kvvssut.pnlcalc.dto.Trade;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class PnlRepository {
    // Autowire this
    private final MarketData marketData = new MarketData();

    private final Map<String, TraderData> tradersData;
    private final PriorityQueue<TraderData> topKTraders;


    public PnlRepository() {
        tradersData = new ConcurrentHashMap<>();
        topKTraders = new PriorityQueue<>(Comparator.comparing(TraderData::getCurrentPnl));
    }


    public synchronized void processTrade(Trade trade) {

        if (!tradersData.containsKey(trade.traderId())) {
            TraderData traderData = new TraderData(trade.traderId());
            traderData.addTrade(trade);
            tradersData.put(trade.traderId(), traderData);
            topKTraders.offer(traderData);
        } else {
            TraderData traderData = tradersData.get(trade.traderId());
            traderData.addTrade(trade);
            topKTraders.offer(traderData);
        }

    }

    public synchronized List<TraderData> getTopKTraders(int k) {
        List<TraderData> topKTradersList = new ArrayList<>();
        PriorityQueue<TraderData> clonedTopKTraders = new PriorityQueue<>(topKTraders);

        for (int i = 0; i < k; i++) {
            TraderData top = clonedTopKTraders.peek();

            // lazy deletion
            while (top != null && tradersData.get(top.getId()).getCurrentPnl() != top.getCurrentPnl()) {
                clonedTopKTraders.poll(); // discard outdated entry
                top = clonedTopKTraders.peek();
            }

            if (top == null) {
                break;
            }

            topKTradersList.add(clonedTopKTraders.poll());
        }

        return topKTradersList;
    }

    public void updatePrice(String symbol, double price) {
        if (marketData.getPrice(symbol) != null) {
            marketData.updatePrice(symbol, price);
        }
    }
}
