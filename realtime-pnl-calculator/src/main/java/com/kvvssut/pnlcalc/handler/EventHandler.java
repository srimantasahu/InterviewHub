package com.kvvssut.pnlcalc.handler;

import com.kvvssut.pnlcalc.bean.MarketEvent;
import com.kvvssut.pnlcalc.dto.PriceUpdate;
import com.kvvssut.pnlcalc.dto.Trade;
import com.kvvssut.pnlcalc.service.PnlService;

public class EventHandler {

    // Autowire
    private PnlService pnlService;

    public void handle(MarketEvent marketEvent) {

        switch (marketEvent.getType()) {
            case TRADE -> pnlService.executeTrade((Trade) marketEvent.getPayload());
            case PRICE_UPDATE -> pnlService.executePriceUpdate((PriceUpdate) marketEvent.getPayload());
        }

    }
}
