package com.calculator.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvalidOperationExceptionTest {

    @Test
    public void testDefaultConstructor() {
        InvalidOperationException exception = new InvalidOperationException();
        Assertions.assertNull(exception.getMessage());
    }

    @Test
    public void testConstructorWithMessage() {
        String errorMessage = "Invalid operation";
        InvalidOperationException exception = new InvalidOperationException(errorMessage);
        Assertions.assertEquals(errorMessage, exception.getMessage());
    }
}
