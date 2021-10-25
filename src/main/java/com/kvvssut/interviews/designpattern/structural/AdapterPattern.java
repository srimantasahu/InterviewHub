package com.kvvssut.interviews.designpattern.structural;

public class AdapterPattern {

	/*
	 * The adapter pattern is adapting between classes and objects. Like any
	 * adapter in the real world it is used to be an interface, a bridge between
	 * two objects.
	 * 
	 * Intent
	 * 
	 * 1. Convert the interface of a class into another interface clients
	 * expect.
	 * 
	 * 2. Adapter lets classes work together, that could not otherwise because
	 * of incompatible interfaces.
	 */

	/*
	 * Wrappers used to adopt 3rd parties libraries and frameworks - most of the
	 * applications using third party libraries use adapters as a middle layer
	 * between the application and the 3rd party library to decouple the
	 * application from the library. If another library has to be used only an
	 * adapter for the new library is required without having to change the
	 * application code.
	 * 
	 * If the Target is represented by an interface instead of a class then we
	 * can talk about "class" adapters, because we can implement as many
	 * interfaces as we want.
	 * 
	 * If the Target and Adaptee are similar then the adapter has just to
	 * delegate the requests from the Target to the Adaptee. If Target and
	 * Adaptee are not similar, then the adapter might have to convert the data
	 * structures between those and to implement the operations required by the
	 * Target but not implemented by the Adaptee.
	 */

}
