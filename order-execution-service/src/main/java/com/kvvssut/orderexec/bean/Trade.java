package com.kvvssut.orderexec.bean;

public record Trade(String tradeId, String buyOrderId, String sellOrderId, double price, int quantity) {
}
