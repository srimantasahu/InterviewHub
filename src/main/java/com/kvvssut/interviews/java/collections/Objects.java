package com.kvvssut.interviews.java.collections;

public class Objects {

    public static void main(String[] args) {

        /**
         * Class {Object} is the root of the class hierarchy. Every class has {Object} as a superclass. All objects,
         * including arrays, implement the methods of this class. */

        /**
         * Native Method: 	private static native void registerNatives();
         static {
         registerNatives();
         }  */

        /**
         * Native Method: public final native Class<?> getClass();
         *
         * Returns the runtime class of this {Object}. The returned {Class} object is the object that is locked by
         * {static synchronized} methods of the represented class.
         *
         * The actual result type is {Class<? extends |X|>} where {|X|} is the erasure of the static type of the
         * expression on which {getClass} is called. For example, no cast is required in this code fragment:
         *
         * {Number n = 0; }
         * {Class<? extends Number> c = n.getClass(); }  */

        /**
         * Native Method: public native int hashCode();
         *
         * Returns a hash code value for the object. This method is supported for the benefit of hash tables such as
         * those provided by {java.util.HashMap}.
         *
         * The general contract of {hashCode} is:
         *
         * Whenever it is invoked on the same object more than once during an execution of a Java application, the {hashCode} method
         * must consistently return the same integer, provided no information used in {equals} comparisons on the object is modified.
         * This integer need not remain consistent from one execution of an application to another execution of the same application.
         *
         * If two objects are equal according to the {equals(Object)} method, then calling the {hashCode} method on each of
         * the two objects must produce the same integer result.
         *
         * It is not required that if two objects are unequal according to the {java.lang.Object#equals(java.lang.Object)}
         * method, then calling the {hashCode} method on each of the two objects must produce distinct integer results.  However, the
         * programmer should be aware that producing distinct integer results for unequal objects may improve the performance of hash tables.
         *
         * As much as is reasonably practical, the hashCode method defined by class {Object} does return distinct integers for distinct
         * objects. (This is typically implemented by converting the internal address of the object into an integer, but this implementation
         * technique is not required by the JavaTM programming language.)  */

        /**
         * Method: 	public boolean equals(Object obj) {
         return (this == obj);
         }
         *
         * The {equals} method for class {Object} implements the most discriminating possible equivalence relation on objects;
         * that is, for any non-null reference values {x} and {y}, this method returns {true} if and only if {x} and {y} refer
         * to the same object ({x == y} has the value {true}).
         *
         * Note that it is generally necessary to override the {hashCode} method whenever this method is overridden, so as to maintain the
         * general contract for the {hashCode} method, which states that equal objects must have equal hash codes.  */

        /**
         * Native Method: protected native Object clone() throws CloneNotSupportedException;
         *
         * Creates and returns a copy of this object.
         *
         * By convention, the object returned by this method should be independent of this object (which is being cloned). To achieve this independence,
         * it may be necessary to modify one or more fields of the object returned by {super.clone} before returning it. Typically, this means
         * copying any mutable objects that comprise the internal "deep structure" of the object being cloned and replacing the references to these
         * objects with references to the copies. If a class contains only primitive fields or references to immutable objects, then it is usually
         * the case that no fields in the object returned by {super.clone} need to be modified.
         *
         * The method {clone} for class {Object} performs a specific cloning operation. First, if the class of this object does
         * not implement the interface {Cloneable}, then a {CloneNotSupportedException} is thrown.
         * Note that all arrays are considered to implement the interface {Cloneable} and that the return type of the {clone} method of an array type {T[]}
         * is {T[]} where T is any reference or primitive type. Otherwise, this method creates a new instance of the class of this
         * object and initializes all its fields with exactly the contents of the corresponding fields of this object, as if by assignment; the
         * contents of the fields are not themselves cloned. Thus, this method performs a "shallow copy" of this object, not a "deep copy" operation.  */

        /**
         * Method:  	public String toString() {
         return getClass().getName() + "@" + Integer.toHexString(hashCode());
         }
         *
         * Returns a string representation of the object. In general, the {toString} method returns a string that
         * "textually represents" this object. The result should be a concise but informative representation that is easy for a person to read.
         * It is recommended that all subclasses override this method.
         *
         * The {toString} method for class {Object} returns a string consisting of the name of the class of which the
         * object is an instance, the at-sign character `{@}', and the unsigned hexadecimal representation of the hash code of the object.  */

        /**
         * Native Method: 	public final native void notify();
         *
         *    */


        /**
         * Method: 	protected void finalize() throws Throwable { }
         *
         * Called by the garbage collector on an object when garbage collection determines that there are no more references to the object.
         * A subclass overrides the {finalize} method to dispose of system resources or to perform other cleanup.
         *
         * The general contract of {finalize} is that it is invoked if and when the JavaTM virtual machine has determined that there is no longer any
         * means by which this object can be accessed by any thread that has not yet died, except as a result of an action taken by the
         * finalization of some other object or class which is ready to be finalized. The {finalize} method may take any action, including
         * making this object available again to other threads; the usual purpose of {finalize}, however, is to perform cleanup actions before
         * the object is irrevocably discarded. For example, the finalize method for an object that represents an input/output connection might perform
         * explicit I/O transactions to break the connection before the object is permanently discarded.
         *
         * The Java programming language does not guarantee which thread will invoke the {finalize} method for any given object. It is
         * guaranteed, however, that the thread that invokes finalize will not be holding any user-visible synchronization locks when finalize is
         * invoked. If an uncaught exception is thrown by the finalize method, the exception is ignored and finalization of that object terminates.
         *
         * After the {finalize} method has been invoked for an object, no further action is taken until the Java virtual machine has again
         * determined that there is no longer any means by which this object can be accessed by any thread that has not yet died, including possible
         * actions by other objects or classes which are ready to be finalized, at which point the object may be discarded.
         *
         * The {finalize} method is never invoked more than once by a Java virtual machine for any given object.
         */

        Object object;
    }
}
