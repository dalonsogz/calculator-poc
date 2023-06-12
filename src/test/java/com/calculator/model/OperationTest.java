package com.calculator.model;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class OperationTest {

    @Test
    void testGetValue() {
        assertEquals("ADDITION", Operation.ADDITION.getValue());
        assertEquals("SUBTRACTION", Operation.SUBTRACTION.getValue());
    }

    @Test
    void testFromString_ValidValue() {
        assertEquals(Operation.ADDITION, Operation.fromValue("ADDITION"));
        assertEquals(Operation.SUBTRACTION, Operation.fromValue("SUBTRACTION"));
    }

    @Test
    void testToString() {
        assertEquals("ADDITION", Operation.ADDITION.toString());
        assertEquals("SUBTRACTION", Operation.SUBTRACTION.toString());
    }

    @Test
    void testFromString_InvalidValue() {
        assertThrows(IllegalArgumentException.class, () -> Operation.fromValue("INVALID"));
    }
}