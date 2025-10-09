package com.kvvssut.pnlcalc;

import com.kvvssut.pnlcalc.runner.PnlCalculator;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting pnl calculator...");

        new PnlCalculator().start();

        System.out.println("Successfully started pnl calculator.");

        Thread.currentThread().join();

    }
}
