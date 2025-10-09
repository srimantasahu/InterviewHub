package com.kvvssut.pnlcalc.dto;

import com.kvvssut.pnlcalc.bean.Side;

public record Trade(String traderId, Side side, String symbol, int qty, double price) {
}
