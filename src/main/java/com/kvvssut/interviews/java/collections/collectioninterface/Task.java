package com.kvvssut.interviews.java.collections.collectioninterface;

public abstract class Task implements Comparable<Task> {

    protected Task() {
    }

    public boolean equal(Object o) {
        if (o instanceof Task) {
            return toString().equals(o.toString());
        } else
            return false;
    }

    /*
     * Natural ordering on tasks is consistent with equality i.e., compareTo
     * returns 0 exactly when equals returns true.
     */
    @Override
    public int compareTo(Task t) {
        return toString().compareTo(t.toString());
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public abstract String toString();

}
