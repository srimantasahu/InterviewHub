package com.kvvssut.orderexec;

import com.kvvssut.orderexec.runner.OrderBookRunner;

public class App {

    public static void main(String[] args) throws InterruptedException {
        new OrderBookRunner().start();
    }
}
