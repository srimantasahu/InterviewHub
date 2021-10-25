package com.kvvssut.interviews.designpattern.structural;

/*
 * Sometimes we need the ability to control the access to an object. For
 * example if we need to use only a few methods of some costly objects we'll
 * initialize those objects when we need them entirely. Until that point we
 * can use some light objects exposing the same interface as the heavy
 * objects. These light objects are called proxies and they will instantiate
 * those heavy objects when they are really needed and by then we'll use some
 * light objects instead.
 * 
 * This ability to control the access to an object can be required for a
 * variety of reasons: controlling when a costly object needs to be
 * instantiated and initialized, giving different access rights to an
 * object, as well as providing a sophisticated means of accessing and
 * referencing objects running in other processes, on other machines.
 * 
 * Intent
 * 
 * 1. The intent of this pattern is to provide a Placeholder for an object
 * to control references to it.
 * 
 * A client obtains a reference to a proxy, the client then handles the
 * proxy in the same way it handles RealSubject and thus invoking the method
 * doSomething(). At that point the proxy can do different things prior to
 * invoking RealSubject's doSomething() method. The client might create a
 * RealSubject object at that point, perform initialization, check
 * permissions of the client to invoke the method, and then invoke the
 * method on the object. The client can also do additional tasks after
 * invoking the doSomething() method, such as incrementing the number of
 * references to the object.
 */

/**
 * Subject Interface
 */
interface Image {
	public void showImage();
}

/**
 * Proxy
 */
class ImageProxy implements Image {

	/**
	 * Private Proxy data
	 */
	private String imageFilePath;

	/**
	 * Reference to RealSubject
	 */
	private Image proxifiedImage;

	public ImageProxy(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}

	@Override
	public void showImage() {

		// create the Image Object only when the image is required to be shown
		proxifiedImage = new HighResolutionImage(imageFilePath);

		// now call showImage on realSubject
		proxifiedImage.showImage();
	}
}

/**
 * RealSubject
 */
class HighResolutionImage implements Image {

	public HighResolutionImage(String imageFilePath) {

		loadImage(imageFilePath);
	}

	private void loadImage(String imageFilePath) {
		// load Image from disk into memory
		// this is heavy and costly operation
	}

	@Override
	public void showImage() {
		// Actual Image rendering logic
	}
}

/**
 * Image Viewer program
 */
public class ProxyPattern {

	public static void main(String[] args) {

		// assuming that the user selects a folder that has 3 images
		// create the 3 images
		Image highResolutionImage1 = new ImageProxy("sample/veryHighResPhoto1.jpeg");
		Image highResolutionImage2 = new ImageProxy("sample/veryHighResPhoto2.jpeg");
		Image highResolutionImage3 = new ImageProxy("sample/veryHighResPhoto3.jpeg");

		// assume that the user clicks on Image one item in a list
		// this would cause the program to call showImage() for that image only
		// note that in this case only image one was loaded into memory
		highResolutionImage1.showImage();

		// consider using the high resolution image object directly
		Image highResolutionImageNoProxy1 = new HighResolutionImage("sample/veryHighResPhoto1.jpeg");
		Image highResolutionImageNoProxy2 = new HighResolutionImage("sample/veryHighResPhoto2.jpeg");
		Image highResolutionImageBoProxy3 = new HighResolutionImage("sample/veryHighResPhoto3.jpeg");

		// assume that the user selects image two item from images list
		highResolutionImageNoProxy2.showImage();

		// note that in this case all images have been loaded into memory and
		// not all have been actually displayed - this is a waste of memory
		// resources
	}
}

/*
 * Common Situations where the proxy pattern is applicable are:
 * 
 * 1. Virtual Proxies: delaying the creation and initialization of expensive
 * objects until needed, where the objects are created on demand (For example
 * creating the RealSubject object only when the doSomething method is invoked).
 * 
 * 2. Remote Proxies: providing a local representation for an object that is in
 * a different address space. A common example is Java RMI stub objects. The
 * stub object acts as a proxy where invoking methods on the stub would cause
 * the stub to communicate and invoke methods on a remote object (called
 * skeleton) found on a different machine.
 *
 * In java RMI an object on one machine (executing in one JVM) called a client
 * can invoke methods on an object in another machine (another JVM) the second
 * object is called a remote object. The proxy (also called a stub) resides on
 * the client machine and the client invokes the proxy in as if it is invoking
 * the object itself (remember that the proxy implements the same interface that
 * RealSubject implements). The proxy itself will handle communication to the
 * remote object, invoke the method on that remote object, and would return the
 * result if any to the client.
 */