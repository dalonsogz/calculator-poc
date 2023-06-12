package com.calculator.exception;

import org.springframework.stereotype.Component;

@Component
public class InvalidOperationException extends RuntimeException {

    public InvalidOperationException() {
        super();
    }

    public InvalidOperationException(String message) {
        super(message);
    }

}
