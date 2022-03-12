package com.kvvssut.interviews.java.misc;

public class ExceptionBasics {

    public static void main(String[] args) throws MyCheckedException { // checked
        // exception
        // so we
        // need
        // to
        // add
        // in
        // throws
        // clause

        if (false) { // runtime exception example - no need to handle it
            // explicitly with catch or throws
            throw new ExceptionBasics().new MyRuntimeException(
                    "Testing Runtime exception!");
        }

        try { // checked exception example
            throw new ExceptionBasics().new MyCheckedException(
                    "Testing checked exception!"); // can either handle it with
            // catch or throw to the
            // calling method with
            // throws
        } catch (MyCheckedException myCheckedException) {
            System.out.println(myCheckedException.getMessage()); // just added a
            // logger
            // and
            // thrown
            // back to
            // caller
            // method
            throw myCheckedException;
        }

    }

    // Checked exceptions are children of Exception class
    class MyCheckedException extends Exception {
        public MyCheckedException() {
        }

        public MyCheckedException(String errorMessage) {
            super(errorMessage);
        }

        public MyCheckedException(String errorMessage, Throwable exception) {
            super(errorMessage, exception);
        }
    }

    // Unchecked exceptions are children of RuntimeException class
    class MyRuntimeException extends RuntimeException {
        public MyRuntimeException() {
        }

        public MyRuntimeException(String errorMessage) {
            super(errorMessage);
        }
    }
}
