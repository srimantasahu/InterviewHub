package com.kvvssut.pnlcalc.parser;

import com.kvvssut.pnlcalc.bean.EventType;
import com.kvvssut.pnlcalc.bean.MarketEvent;
import com.kvvssut.pnlcalc.bean.Side;
import com.kvvssut.pnlcalc.dto.PriceUpdate;
import com.kvvssut.pnlcalc.dto.Trade;

public class EventParser {


    public static MarketEvent parse(String event) {

        if (event == null || event.isBlank()) {
            System.out.println("Invalid event received: " + event);
            return null;
        }

        // trim first
        event = event.trim();

        String[] data = event.split("\\|");

        EventType type = EventType.valueOf(data[0].toUpperCase());

        return switch (type) {
            case TRADE ->
                    new MarketEvent(type, new Trade(data[1].trim(), Side.valueOf(data[2].trim().toUpperCase()), data[3].trim(), Integer.parseInt(data[4]), Double.parseDouble(data[5])));
            case PRICE_UPDATE ->
                    new MarketEvent(type, new PriceUpdate(data[1].trim().toUpperCase(), Double.parseDouble(data[2].trim())));
        };
    }
}
