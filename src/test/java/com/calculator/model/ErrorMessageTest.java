package com.calculator.model;

import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

public class ErrorMessageTest {

    @Test
    void testConstructorAndGetters() {
        int statusCode = 404;
        OffsetDateTime timestamp = OffsetDateTime.now();
        String message = "Not Found";
        String description = "The requested resource was not found.";

        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setStatusCode(statusCode);
        errorMessage.setTimestamp(timestamp);
        errorMessage.setMessage(message);
        errorMessage.setDescription(description);

        assertEquals(statusCode, errorMessage.getStatusCode());
        assertEquals(timestamp, errorMessage.getTimestamp());
        assertEquals(message, errorMessage.getMessage());
        assertEquals(description, errorMessage.getDescription());
    }

    @Test
    void testToString() {
        int statusCode = 500;
        OffsetDateTime timestamp = OffsetDateTime.now();

        String message = "Internal Server Error";
        String description = "An unexpected error occurred.";

        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setStatusCode(statusCode);
        errorMessage.setTimestamp(timestamp);
        errorMessage.setMessage(message);
        errorMessage.setDescription(description);

        String expectedToString = "class ErrorMessage {\n" +
                "    statusCode: 500\n" +
                "    message: Internal Server Error\n" +
                "    description: An unexpected error occurred.\n" +
                "}";
        assertEquals(expectedToString, errorMessage.toString().replaceAll(".*timestamp:.+\\n", ""));

        errorMessage.setStatusCode(null);
        Pattern pattern = Pattern.compile("statusCode: (\\w+)");
        Matcher matcher = pattern.matcher(errorMessage.toString());
        matcher.find();
        String nullValue = matcher.group(1);
        assertEquals("null", nullValue);
    }

    @Test
    void testNoArgsConstructor() {
        ErrorMessage errorMessage = new ErrorMessage();
        assertNotNull(errorMessage);
    }

    @Test
    void testSetters() {
        int statusCode = 400;
        OffsetDateTime timestamp = OffsetDateTime.now();
        String message = "Bad Request";
        String description = "The request is invalid.";

        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setStatusCode(statusCode);
        errorMessage.setTimestamp(timestamp);
        errorMessage.setMessage(message);
        errorMessage.setDescription(description);

        assertEquals(statusCode, errorMessage.getStatusCode());
        assertEquals(timestamp, errorMessage.getTimestamp());
        assertEquals(message, errorMessage.getMessage());
        assertEquals(description, errorMessage.getDescription());
    }

    @Test
    void testEqualsAndHashCode() {
        int statusCode = 200;
        OffsetDateTime timestamp = OffsetDateTime.now();
        String message = "OK";
        String description = "The request was successful.";

        ErrorMessage errorMessage1 = new ErrorMessage();
        errorMessage1.setStatusCode(statusCode);
        errorMessage1.setTimestamp(timestamp);
        errorMessage1.setMessage(message);
        errorMessage1.setDescription(description);

        ErrorMessage errorMessage2 = new ErrorMessage();
        errorMessage2.setStatusCode(statusCode);
        errorMessage2.setTimestamp(timestamp);
        errorMessage2.setMessage(message);
        errorMessage2.setDescription(description);

        assertEquals(errorMessage1, errorMessage2);
        assertEquals(errorMessage1.hashCode(), errorMessage2.hashCode());
        assertEquals(errorMessage1, errorMessage1);
        assertFalse(errorMessage1.equals(null));
        assertFalse(errorMessage1.equals(""));

        errorMessage2.setStatusCode(202);
        assertNotEquals(errorMessage1, errorMessage2);
        errorMessage2.setStatusCode(statusCode);
        errorMessage2.setTimestamp(OffsetDateTime.now());
        assertNotEquals(errorMessage1, errorMessage2);
        errorMessage2.setTimestamp(timestamp);
        errorMessage2.setMessage("KO");
        assertNotEquals(errorMessage1, errorMessage2);
        errorMessage2.setMessage(message);
        errorMessage2.setDescription("-");
        assertNotEquals(errorMessage1, errorMessage2);
    }

    @Test
    void testSetsGets() {
        int statusCode = 200;
        OffsetDateTime timestamp = OffsetDateTime.now();
        String message = "OK";
        String description = "The request was successful.";

        ErrorMessage errorMessage = new ErrorMessage();

        assertEquals(statusCode, errorMessage.statusCode(statusCode).getStatusCode());
        assertEquals(timestamp, errorMessage.timestamp(timestamp).getTimestamp());
        assertEquals(message, errorMessage.message(message).getMessage());
        assertEquals(description, errorMessage.description(description).getDescription());

    }
}
