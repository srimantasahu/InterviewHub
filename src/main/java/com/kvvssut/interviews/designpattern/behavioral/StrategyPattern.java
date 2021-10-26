package com.kvvssut.interviews.designpattern.behavioral;

/*
 * There are common situations when classes differ only in their behavior. For these cases, it is a good idea to isolate the
 * algorithms in separate classes in order to have the ability to select different algorithms at runtime.
 * 
 * Intent
 * 
 * Define a family of algorithms, encapsulate each one, and make them interchangeable. Strategy lets the algorithm vary independently
 * from clients that use it.
 */

interface IBehaviour {
	public int moveCommand();
}

class AggressiveBehaviour implements IBehaviour {
	public int moveCommand() {
		System.out.println("\tAggressive Behaviour: if find another robot attack it");
		return 1;
	}
}

class DefensiveBehaviour implements IBehaviour {
	public int moveCommand() {
		System.out.println("\tDefensive Behaviour: if find another robot run from it");
		return -1;
	}
}

class NormalBehaviour implements IBehaviour {
	public int moveCommand() {
		System.out.println("\tNormal Behaviour: if find another robot ignore it");
		return 0;
	}
}

class Robot {
	IBehaviour behaviour;
	String name;

	public Robot(String name) {
		this.name = name;
	}

	public void setBehaviour(IBehaviour behaviour) {
		this.behaviour = behaviour;
	}

	public IBehaviour getBehaviour() {
		return behaviour;
	}

	public void move() {
		System.out.println(this.name + ": Based on current position" + "the behaviour object decide the next move:");
		int command = behaviour.moveCommand();
		// ... send the command to mechanisms
		System.out.println("\tThe result returned by behaviour object " + "is sent to the movement mechanisms "
				+ " for the robot '" + this.name + "'");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

public class StrategyPattern {

	public static void main(String[] args) {

		Robot r1 = new Robot("Big Robot");
		Robot r2 = new Robot("George v.2.1");
		Robot r3 = new Robot("R2");

		r1.setBehaviour(new AggressiveBehaviour());
		r2.setBehaviour(new DefensiveBehaviour());
		r3.setBehaviour(new NormalBehaviour());

		r1.move();
		r2.move();
		r3.move();

		System.out.println("\r\nNew behaviours: " + "\r\n\t'Big Robot' gets really scared"
				+ "\r\n\t, 'George v.2.1' becomes really mad because" + "it's always attacked by other robots"
				+ "\r\n\t and R2 keeps its calm\r\n");

		r1.setBehaviour(new DefensiveBehaviour());
		r2.setBehaviour(new AggressiveBehaviour());

		r1.move();
		r2.move();
		r3.move();
	}

}

/*
 * The strategy design pattern splits the behavior (there are many behaviors) of a class from the class itself.
 * This has some advantages, but the main drawback is that a client must understand how the Strategies differ.
 * Since, clients get exposed to implementation issues, the strategy design pattern should be used only
 * when the variation in behavior is relevant to them.
 */
