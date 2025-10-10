package com.kvvssut.orderexec.repository;

import com.kvvssut.orderexec.bean.Order;
import com.kvvssut.orderexec.bean.Side;
import com.kvvssut.orderexec.bean.Trade;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderBook {

    private final AtomicInteger counter;
    private TreeMap<BigDecimal, Deque<Order>> buyOrders;
    private TreeMap<BigDecimal, Deque<Order>> sellOrders;
    private List<Trade> trades;

    public OrderBook() {
        this.buyOrders = new TreeMap<>(Comparator.reverseOrder()); // in descending buy prices
        this.sellOrders = new TreeMap<>(); // in ascending sell prices
        this.trades = new ArrayList<>();
        this.counter = new AtomicInteger(0);
    }

    public TreeMap<BigDecimal, Deque<Order>> getOrders(Side side) {
        return side == Side.BUY ? buyOrders : sellOrders;
    }

    public void addTrade(String buyOrderId, String sellOrderId, BigDecimal price, int quantity) {
        this.trades.add(new Trade(getAutoIncrementTradeId(), buyOrderId, sellOrderId, price, quantity));
    }

    public List<Trade> getTrades() {
        return trades;
    }

    private String getAutoIncrementTradeId() {
        return "T" + counter.incrementAndGet();
    }
}
