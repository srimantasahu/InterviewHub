package com.kvvssut.interviews.designpattern.behavioral;

/*
 * We can not talk about Object Oriented Programming without considering the
 * state of the objects. After all object oriented programming is about
 * objects and their interaction. The cases when certain objects need to be
 * informed about the changes occurred in other objects are frequent. To
 * have a good design means to decouple as much as possible and to reduce
 * the dependencies. The Observer Design Pattern can be used whenever a
 * subject has to be observed by one or more observers.
 * 
 * Intent
 * 
 * 1. Defines a one-to-many dependency between objects so that when one
 * object state changes, all its dependents are notified and updated
 * automatically.
 */

class Observable {
	int state = 0;
	int additionalState = 0;

	public void updateState(int increment) {
		state = state + increment;
		notifyObservers();
	}

	private void notifyObservers() {
		// notify observers
	}
}

public class ObserverPattern extends Observable {
	public void updateState(int increment) {
		super.updateState(increment); // the observers are notified
		additionalState = additionalState + increment; // the state is changed after the notifiers are updated
	}
}

/*
 * The observer pattern is used when:
 * 
 * 1. the change of a state in one object must be reflected in another object without keeping the objects tightly coupled.
 * 
 * 2. the framework we are writing needs to be enhanced in future with new observers with minimal changes.
 * 
 * Some Classical Examples:
 * 
 * Model View Controller Pattern - The observer pattern is used in the model view controller (MVC) architectural pattern.
 * In MVC architecture, this pattern is used to decouple the model from the view.
 * View represents the Observer and the model is the Observable object.
 * 
 * Event management - This is one of the domains where the Observer patterns is extensively used.
 * Swing and .Net are extensively using the Observer pattern for implementing the events mechanism.
 * 
 */
