package com.calculator.exception;

public class InvalidOperationException extends RuntimeException {

    public InvalidOperationException() {
        super();
    }

    public InvalidOperationException(String message) {
        super(message);
    }

}
