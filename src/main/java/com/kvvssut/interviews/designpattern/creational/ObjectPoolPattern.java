package com.kvvssut.interviews.designpattern.creational;

public class ObjectPoolPattern {

	/*
	 * Performance can be sometimes the key issue during the software
	 * development and the object creation(class instantiation) is a costly
	 * step. While the Prototype pattern helps in improving the performance by
	 * cloning the objects, the Object Pool pattern offer a mechanism to reuse
	 * objects that are expensive to create.
	 * 
	 * Clients of an object pool "feel" like they are owners of a service
	 * although the service is shared among many other clients.
	 * 
	 * Intent
	 * 
	 * 1. reuse and share objects that are expensive to create.
	 *
	 *
	 * The clients are not aware that they are sharing the Reusable object. From
	 * the client point of view they are the owners of a new object which comes
	 * from the Resource pool in the same way that it comes from a factory or
	 * another creational design pattern. The only difference is that the Client
	 * should mark the Reusable object as available, after it finishes to use
	 * it. It's not about releasing the objects; for example if we work with
	 * databases, when a connection is closed it's not necessarily destroyed, it
	 * means that it can be reused by another client.
	 * 
	 * When the Object Pool pattern is used the objects should be marked as
	 * available(released) by the client after they are used, so the pool will
	 * be aware about this. This is the main drawback because the client should
	 * do this and it's a common situation when database connection are not
	 * released after they are used. To overcome this a mechanism can be
	 * implemented to release resources if they are not used for a period of
	 * time.
	 * 
	 * Creating the resources might fail and this case should be treated
	 * carefully. When there is no available resource(because the number is
	 * limited or creating a new one failed) the client should be notified about
	 * it.
	 */

}
