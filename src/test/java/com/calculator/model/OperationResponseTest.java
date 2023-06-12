package com.calculator.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


class OperationResponseTest {


    @Test
    void testResultGetterSetter() {
        BigDecimal expectedResult = new BigDecimal("55.8");
        OperationResponse response = new OperationResponse();
        response.setResult(expectedResult);
        assertEquals(expectedResult, response.getResult());
    }

    @Test
    void testHashCode() {
        BigDecimal result1 = new BigDecimal("55.8");
        BigDecimal result2 = new BigDecimal("55.8");
        BigDecimal differentResult = new BigDecimal("99.9");

        OperationResponse response1 = new OperationResponse();
        response1.setResult(result1);
        OperationResponse response2 = new OperationResponse();
        response2.setResult(result2);
        OperationResponse response3 = new OperationResponse();
        response3.setResult(differentResult);

        // Test hashCode
        assertEquals(response1.hashCode(), response2.hashCode());
        assertNotEquals(response1.hashCode(), response3.hashCode());
    }

    @Test
    void testToString() {
        BigDecimal result = new BigDecimal("55.8");

        OperationResponse response = new OperationResponse();
        response.setResult(result);

        String expectedToString = "class OperationResponse {\n" +
                "    result: 55.8\n" +
                "}";
        assertEquals(expectedToString, response.toString());

        response.setResult(null);
        Pattern pattern = Pattern.compile("result: (\\w+)");
        Matcher matcher = pattern.matcher(response.toString());
        matcher.find();
        String nullValue = matcher.group(1);
        assertEquals("null", nullValue);
    }

    @Test
    void testEquals() {
        BigDecimal result1 = new BigDecimal("55.8");
        BigDecimal result2 = new BigDecimal("55.8");
        BigDecimal differentResult = new BigDecimal("99.9");

        OperationResponse response1 = new OperationResponse();
        response1.setResult(result1);
        OperationResponse response2 = new OperationResponse();
        response2.setResult(result2);
        OperationResponse response3 = new OperationResponse();
        response3.setResult(differentResult);

        // Test equals
        assertEquals(response1, response2);
        assertNotEquals(response1, response3);
        assertEquals(response1, response1);
        assertEquals(false, response1.equals(null));
        assertEquals(false, response1.equals(""));
    }
}
