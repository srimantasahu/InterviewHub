package com.kvvssut.interviews.designpattern.behavioral;

import java.util.ArrayList;

/*
 * An object that contains a symbol, name or key that represents a list of
 * commands, actions or keystrokes. This is the definition of a macro, one
 * that should be familiar to any computer user. From this idea the Command
 * design pattern was given birth. The Macro represents, at some extent, a
 * command that is built from the reunion of a set of other commands, in a
 * given order. Just as a macro, the Command design pattern encapsulates
 * commands (method calls) in objects allowing us to issue requests without
 * knowing the requested operation or the requesting object. Command design
 * pattern provides the options to queue commands, undo/redo actions and
 * other manipulations.
 * 
 * Intent
 * 
 * 1. encapsulate a request in an object
 * 
 * 2. allows the parameterization of clients with different requests
 * 
 * 3. allows saving the requests in a queue
 */

interface Order {
	public abstract void execute();
}

// Receiver class.
class StockTrade {
	public void buy() {
		System.out.println("You want to buy stocks");
	}

	public void sell() {
		System.out.println("You want to sell stocks ");
	}
}

// Invoker.
class Agent {
	private ArrayList<Order> m_ordersQueue = new ArrayList<Order>();

	public Agent() {
	}

	void placeOrder(Order order) {
		m_ordersQueue.add(order);
		m_ordersQueue.remove(0).execute();
	}
}

// ConcreteCommand Class.
class BuyStockOrder implements Order {
	private StockTrade stock;

	public BuyStockOrder(StockTrade st) {
		stock = st;
	}

	public void execute() {
		stock.buy();
	}
}

// ConcreteCommand Class.
class SellStockOrder implements Order {
	private StockTrade stock;

	public SellStockOrder(StockTrade st) {
		stock = st;
	}

	public void execute() {
		stock.sell();
	}
}

// Client
public class CommandPattern {
	public static void main(String[] args) {
		StockTrade stock = new StockTrade();
		BuyStockOrder bsc = new BuyStockOrder(stock);
		SellStockOrder ssc = new SellStockOrder(stock);

		Agent agent = new Agent();
		agent.placeOrder(bsc); // Buy Shares
		agent.placeOrder(ssc); // Sell Shares
	}
}

/*
 * The applicability of the Command design pattern can be found in the cases
 * below:
 * 
 * 1. parameterizes objects depending on the action they must perform
 * 
 * 2. decouples the object that invokes the action from the object that performs
 * the action. Due to this usage it is also known as Producer - Consumer design
 * pattern.
 */
