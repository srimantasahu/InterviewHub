package com.kvvssut.pnlcalc.service;

import com.kvvssut.pnlcalc.dto.PriceUpdate;
import com.kvvssut.pnlcalc.dto.Trade;
import com.kvvssut.pnlcalc.repo.PnlRepository;
import com.kvvssut.pnlcalc.repo.TraderData;

import java.util.List;

public class PnlService {

    // autowire these
    private final PnlRepository pnlRepository = new PnlRepository();

    public void executeTrade(Trade trade) {
        // validate trade -  quantity, price
        // proceed when good

        pnlRepository.processTrade(trade);

    }

    public void executePriceUpdate(PriceUpdate priceUpdate) {

        // validate price update values

        pnlRepository.updatePrice(priceUpdate.symbol(), priceUpdate.price());
    }

    public List<TraderData> fetchTopKTraders(int k) {
        // validate k > 0

        return pnlRepository.getTopKTraders(k);
    }
}
