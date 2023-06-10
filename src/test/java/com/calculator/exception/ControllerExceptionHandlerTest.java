package com.calculator.exception;

import com.calculator.CalculatorApplication;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.context.request.ServletWebRequest;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CalculatorApplication.class)
class ControllerExceptionHandlerTest {

    @Mock
    private ServletWebRequest servletWebRequest;

    @Spy
    private ControllerExceptionHandler controllerExceptionHandler;

    @Test
    public void testMissingServletRequestParameterExceptionHandler() {
        final var responseEntity = controllerExceptionHandler.illegalArgumentExceptionHandler(new MissingServletRequestParameterException("param", "paramype", false), servletWebRequest);
        Assert.assertEquals(HttpStatus.BAD_REQUEST.value(), responseEntity.getStatusCode());
    }

    @Test
    public void testIllegalArgumentExceptionHandler() {
        final var responseEntity = controllerExceptionHandler.illegalArgumentExceptionHandler(new IllegalArgumentException(), servletWebRequest);
        Assert.assertEquals(HttpStatus.BAD_REQUEST.value(), responseEntity.getStatusCode());
    }

    @Test
    public void testGlobalExceptionHandler() {
        final var responseEntity = controllerExceptionHandler.globalExceptionHandler(new Exception(), servletWebRequest);
        Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), responseEntity.getStatusCode());
    }

}
