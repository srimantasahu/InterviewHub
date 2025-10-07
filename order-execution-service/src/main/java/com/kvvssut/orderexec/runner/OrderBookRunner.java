package com.kvvssut.orderexec.runner;

import com.kvvssut.orderexec.bean.Order;
import com.kvvssut.orderexec.helper.OrderParser;
import com.kvvssut.orderexec.service.OrderBookService;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class OrderBookRunner {

    // Autowire these
    private OrderParser orderParser = new OrderParser();
    private OrderBookService orderBookService = new OrderBookService();

    public void start() throws InterruptedException {
        System.out.println("Starting OMS for order processing...");

        // list of order text
        List<String> orders = Arrays.asList(
                "O1, BUY, 100.0, 50, 1",
                "O2, SELL, 99.5, 20, 2",
                "O3, SELL, 100.0, 30, 3",
                "O4, BUY, 101.0, 25, 4"
        );

        // parse to order
        List<Order> ordersStream = orders.stream().map(text -> orderParser.parseOrderText(text)).filter(Objects::nonNull).toList();

        // process each
        for (Order order : ordersStream) {
            orderBookService.matchOrder(order);
        }

        System.out.println("Order processing completed.");

        System.out.println("Printing eod trades...");

        orderBookService.printTrades();

        System.out.println("Printing remaining orders...");

        orderBookService.printRemainingOrders();

//        Thread.currentThread().join();  // to run this program forever
    }

}
