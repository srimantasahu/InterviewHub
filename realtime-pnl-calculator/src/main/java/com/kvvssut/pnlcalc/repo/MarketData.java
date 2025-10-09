package com.kvvssut.pnlcalc.repo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MarketData {

    private final Map<String, Double> instrumentData;

    public MarketData() {
        instrumentData = new ConcurrentHashMap<>();
    }

    public void updatePrice(String symbol, double price) {
        instrumentData.put(symbol, price);
    }

    public Double getPrice(String symbol) {
        return instrumentData.get(symbol);
    }

    public Map<String, Double> getInstrumentData() {
        return instrumentData;
    }
}
