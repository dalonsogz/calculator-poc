package com.calculator.model;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class OperationTest {

    @Test
    public void testGetValue() {
        assertEquals("ADDITION", Operation.ADDITION.getValue());
        assertEquals("SUBTRACTION", Operation.SUBTRACTION.getValue());
    }

    @Test
    public void testFromString_ValidValue() {
        assertEquals(Operation.ADDITION, Operation.fromValue("ADDITION"));
        assertEquals(Operation.SUBTRACTION, Operation.fromValue("SUBTRACTION"));
    }

    @Test
    public void testToString() {
        assertEquals("ADDITION", Operation.ADDITION.toString());
        assertEquals("SUBTRACTION", Operation.SUBTRACTION.toString());
    }

    @Test
    public void testFromString_InvalidValue() {
        assertThrows(IllegalArgumentException.class, () -> Operation.fromValue("INVALID"));
    }
}