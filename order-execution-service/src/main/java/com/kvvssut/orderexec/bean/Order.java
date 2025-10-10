package com.kvvssut.orderexec.bean;

import java.math.BigDecimal;

public record Order(String orderId, Side side, BigDecimal price, int quantity, long timestamp) {
}
