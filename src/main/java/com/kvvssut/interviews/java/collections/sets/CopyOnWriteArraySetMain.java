package com.kvvssut.interviews.java.collections.sets;

public class CopyOnWriteArraySetMain {

    /*
     * This class is implemented as a thin wrapper around an instance of
     * CopyOnWriteArrayList, which in turn is backed by an array. This array is
     * treated immutable; a change to the contents of the set results in an
     * entirely new array being created. So add has complexity O(n), as does
     * contains, which has to be implemented by a linear search. Clearly we
     * shouldn't use CopyOnWriteArraySet in a context where you were expecting
     * many searches or insertions. But the array implementation means that
     * iteration costs O(1) per element - faster than HashSet - and it has one
     * advantage which is really compelling in some applications: it provides
     * thread safety without adding to the cost of read operations. This is in
     * contrast to those collections which use locking to achieve thread safety
     * for all operations. Such collections are a bottleneck in multi-threaded
     * use because a thread must get exclusive access to the collection object
     * before it can use it in any way. By contrast, read operations on
     * copy-on-write collections are implemented on the backing array, which is
     * never modified after its creation, so they can be used by any thread
     * without danger of interference from a concurrent write operation.
     */

    /*
     * CopyOnWriteArraySet is used in fairly specialized cases; one that is
     * quite common is in the implementation of the Subject-Observer design
     * pattern, which requires events to be notified to a set of observers. This
     * set must not be modified during the process of notification; with locking
     * set implementations, read and write operations share the overhead
     * necessary to ensure this, whereas with CopyOnWriteArraySet the overhead
     * is carried entirely by write operations. This makes sense for
     * Subject-Observer; in typical uses of this pattern, event notifications
     * occur much frequently than changes to the listener set.
     */

    /*
     * Iterators for CopyOnWriteArraySet can be used only to read the set. When
     * they are created, they are attached to the instance of the backing array
     * being used by the set at that moment. Since no instance of this array
     * should ever be modified, the iterators' remove method is not implemented.
     * These are snapshot iterators; they reflect the state of the set at the
     * time it was created, and can subsequently be traversed without any danger
     * of interference from threads modifying the set from which they were
     * removed.
     */

    /*
     * Since there are no configuration parameters for CopyOnWriteArraySet, the
     * constructors are just the standard ones discussed earlier.
     */
}
