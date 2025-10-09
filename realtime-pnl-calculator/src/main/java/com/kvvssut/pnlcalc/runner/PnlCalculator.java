package com.kvvssut.pnlcalc.runner;

import com.kvvssut.pnlcalc.bean.MarketEvent;
import com.kvvssut.pnlcalc.handler.EventHandler;
import com.kvvssut.pnlcalc.parser.EventParser;

import java.util.Arrays;
import java.util.List;

public class PnlCalculator {

    // Autowire
    private final EventHandler handler = new EventHandler();

    public void start() {

        System.out.println("Processing below market events...");

        List<String> events = Arrays.asList(
                "TRADE|Trader1|BUY|MSFT|100|10",
                "TRADE|Trader1|BUY|MSFT|50|12",
                "TRADE|Trader1|SELL|MSFT|80|15",
                "PRICE_UPDATE|MSFT|14",
                "TRADE|Trader1|BUY|SELL|20|14",
                "PRICE_UPDATE|MSFT|13");

        for (String event : events) {
            MarketEvent marketEvent = EventParser.parse(event);

            if (marketEvent == null) {
                System.out.println("Event parsing failed for: " + event);
                continue;
            }

            handler.handle(marketEvent);
        }

        System.out.println("Event processing completed.");

    }

}
