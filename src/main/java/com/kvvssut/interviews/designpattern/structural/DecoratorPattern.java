package com.kvvssut.interviews.designpattern.structural;

/*
 * Extending an object's functionality can be done statically (at compile
 * time) by using inheritance however it might be necessary to extend an
 * object's functionality dynamically (at runtime) as an object is used.
 * 
 * Intent
 * 
 * 1. The intent of this pattern is to add additional responsibilities
 * dynamically to an object.
 * 
 * The decorator pattern applies when there is a need to dynamically add as
 * well as remove responsibilities to a class, and when sub-classing would be
 * impossible due to the large number of subclasses that could result.
 * 
 */

/**
 * Window Interface
 * 
 * Component window
 */
interface Window {

	public void renderWindow();

}

/**
 * Window implementation
 * 
 * Concrete implementation
 */
class SimpleWindow implements Window {

	@Override
	public void renderWindow() {
		// implementation of rendering details

	}
}

class DecoratedWindow implements Window {

	/**
	 * private reference to the window being decorated
	 */
	private Window privateWindowRefernce = null;

	public DecoratedWindow(Window windowRefernce) {

		this.privateWindowRefernce = windowRefernce;
	}

	@Override
	public void renderWindow() {

		privateWindowRefernce.renderWindow();

	}
}

/**
 * Concrete Decorator with extended state
 * 
 * Scrollable window creates a window that is scrollable
 * 
 *
 */
class ScrollableWindow extends DecoratedWindow {

	/**
	 * Additional State
	 */
	private Object scrollBarObjectRepresentation = null;

	public ScrollableWindow(Window windowRefernce) {

		super(windowRefernce);
	}

	@Override
	public void renderWindow() {

		// render scroll bar
		renderScrollBarObject();

		// render decorated window
		super.renderWindow();
	}

	private void renderScrollBarObject() {

		// prepare scroll bar
		scrollBarObjectRepresentation = new Object();

		// render scrollbar

	}
}

class DecoratorPattern {

	public static void main(String[] args) {

		// create a new window

		Window window = new SimpleWindow();
		window.renderWindow();

		// decorate old window
		window = new DecoratedWindow(window);
		window.renderWindow();

		// at some point later maybe text size becomes larger than the window
		// thus the scrolling behavior must be added

		// decorate old window
		window = new ScrollableWindow(window);
		// now window object has additional behavior / state
		window.renderWindow();

	}

}

/*
 * Decoration is more convenient for adding functionalities to objects instead
 * of entire classes at runtime. With decoration it is also possible to remove
 * the added functionalities dynamically.
 */
