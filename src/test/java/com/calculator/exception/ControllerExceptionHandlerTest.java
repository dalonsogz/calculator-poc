package com.calculator.exception;

import com.calculator.model.ErrorMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.WebRequest;

public class ControllerExceptionHandlerTest {

    private final ControllerExceptionHandler exceptionHandler = new ControllerExceptionHandler();

    @Test
    public void testIllegalArgumentExceptionHandler() {
        // Arrange
        IllegalArgumentException exception = new IllegalArgumentException("Invalid argument");
        WebRequest request = Mockito.mock(WebRequest.class);
        Mockito.when(request.getDescription(false)).thenReturn("Request description");

        // Act
        ErrorMessage errorMessage = exceptionHandler.illegalArgumentExceptionHandler(exception, request);

        // Assert
        Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), errorMessage.getStatusCode());
        Assertions.assertNotNull(errorMessage.getTimestamp());
        Assertions.assertEquals("Invalid argument", errorMessage.getMessage());
        Assertions.assertEquals("Request description", errorMessage.getDescription());
    }

    @Test
    public void testGlobalExceptionHandler() {
        // Arrange
        Exception exception = new Exception("Internal server error");
        WebRequest request = Mockito.mock(WebRequest.class);
        Mockito.when(request.getDescription(false)).thenReturn("Request description");

        // Act
        ErrorMessage errorMessage = exceptionHandler.globalExceptionHandler(exception, request);

        // Assert
        Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), errorMessage.getStatusCode());
        Assertions.assertNotNull(errorMessage.getTimestamp());
        Assertions.assertEquals("Internal server error", errorMessage.getMessage());
        Assertions.assertEquals("Request description", errorMessage.getDescription());
    }
}

