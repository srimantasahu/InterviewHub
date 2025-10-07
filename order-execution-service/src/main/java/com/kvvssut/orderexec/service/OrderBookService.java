package com.kvvssut.orderexec.service;

import com.kvvssut.orderexec.bean.Order;
import com.kvvssut.orderexec.bean.Side;
import com.kvvssut.orderexec.bean.Trade;
import com.kvvssut.orderexec.repository.OrderBook;

import java.util.*;

public class OrderBookService {

    // Autowired
    private final OrderBook orderBook = new OrderBook();

    public void matchOrder(Order order) {
        System.out.println("matching order: " + order);

        Side side = order.side();
        Side otherSide = side == Side.BUY ? Side.SELL : Side.BUY;

        synchronized (orderBook) {
            TreeMap<Double, Deque<Order>> sideOrders = orderBook.getOrders(side);
            TreeMap<Double, Deque<Order>> otherSideOrders = orderBook.getOrders(otherSide);

            double price = order.price();
            int qty = order.quantity();

            if (otherSideOrders.isEmpty() || isPriceOutOfBound(side, price, otherSideOrders.firstKey())) {
                addOrderToBook(order, sideOrders);
            } else {
                while (qty > 0) {
                    if (otherSideOrders.isEmpty() || isPriceOutOfBound(side, price, otherSideOrders.firstKey())) {
                        addOrderToBook(new Order(order.orderId(), side, price, qty, order.timestamp()), sideOrders);
                        return;
                    }

                    Map.Entry<Double, Deque<Order>> entry = otherSideOrders.pollFirstEntry();
                    double otherPrice = entry.getKey();
                    Deque<Order> queue = entry.getValue();

                    while (!queue.isEmpty()) {
                        Order otherOrder = queue.pollFirst();
                        int otherQty = otherOrder.quantity();

                        // clarify whether to use resting price or current trade price
                        if (qty == otherQty) {
                            orderBook.addTrade(getBuyOrderId(side, order, otherOrder), getSellOrderId(side, order, otherOrder), price, qty);
                            qty = 0;
                            break;
                        } else if (qty < otherQty) {
                            orderBook.addTrade(getBuyOrderId(side, order, otherOrder), getSellOrderId(side, order, otherOrder), price, qty);
                            queue.offerFirst(new Order(otherOrder.orderId(), otherSide, otherPrice, otherQty - qty, otherOrder.timestamp()));
                            qty = 0;
                            break;
                        } else {
                            orderBook.addTrade(getBuyOrderId(side, order, otherOrder), getSellOrderId(side, order, otherOrder), price, otherQty);
                            qty -= otherQty;
                        }
                    }

                    // add entry back to orders book, if some orders are left for the price
                    if (!queue.isEmpty()) {
                        otherSideOrders.put(otherPrice, queue);
                    }
                }
            }
        }

        System.out.println("completed matching order: " + order);
    }

    private String getBuyOrderId(Side side, Order order, Order otherOrder) {
        return side == Side.BUY ? order.orderId() : otherOrder.orderId();
    }

    private String getSellOrderId(Side side, Order order, Order otherOrder) {
        return side == Side.SELL ? order.orderId() : otherOrder.orderId();
    }

    private void addOrderToBook(Order order, TreeMap<Double, Deque<Order>> sideOrders) {
        if (!sideOrders.containsKey(order.price())) {
            Deque<Order> queue = new ArrayDeque<>();
            queue.add(order);
            sideOrders.put(order.price(), queue);
        } else {
            sideOrders.get(order.price()).add(order);
        }
    }

    private boolean isPriceOutOfBound(Side side, double price, double otherPrice) {
        return side == Side.BUY ? price < otherPrice : price > otherPrice;
    }

    public void printTrades() {
        List<Trade> executedTrades = orderBook.getTrades();

        System.out.println("Executed trades are: ");

        executedTrades.forEach(System.out::println);
    }

    public void printRemainingOrders() {
        System.out.println("Remaining orders are: ");

        for (Side side : Side.values()) {
            System.out.println(side);
            TreeMap<Double, Deque<Order>> orders = orderBook.getOrders(side);
            orders.entrySet().forEach(System.out::println);
        }
    }
}
