package com.kvvssut.orderexec.bean;

public record Order(String orderId, Side side, double price, int quantity, long timestamp) {
}
