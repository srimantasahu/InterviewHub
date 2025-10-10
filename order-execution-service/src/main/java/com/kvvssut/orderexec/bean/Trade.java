package com.kvvssut.orderexec.bean;

import java.math.BigDecimal;

public record Trade(String tradeId, String buyOrderId, String sellOrderId, BigDecimal price, int quantity) {
}
