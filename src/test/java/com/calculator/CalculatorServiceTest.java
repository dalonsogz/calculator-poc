package com.calculator;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;

import static com.calculator.Constants.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CalculatorApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CalculatorServiceTest {

    @LocalServerPort
    private int localServerPort;


    private ResponseEntity<BigDecimal> calculateOK(BigDecimal firstOperator, BigDecimal secondOperator, String operation) throws URISyntaxException {
        final String baseUrl = HTTP_DOMAIN + localServerPort + HTTP_API_VERSION + CALCULATE_ENDPOINT +
                "?firstOperator=" + firstOperator +
                "&secondOperator=" + secondOperator +
                "&operation=" + operation;

        System.out.println("calculateOk=" + baseUrl);
        return new RestTemplate().getForEntity(new URI(baseUrl), BigDecimal.class);
    }

    @Test
    public void testAdditionOk() throws URISyntaxException {
        ResponseEntity<BigDecimal> result = calculateOK(new BigDecimal(98.5), new BigDecimal(1.5), "addition");
        Assert.assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
        Assert.assertEquals(100, result.getBody().doubleValue(), 0.001);
    }

    @Test
    public void testSubtractionOk() throws URISyntaxException {
        ResponseEntity<BigDecimal> result = calculateOK(new BigDecimal(98.5), new BigDecimal(1.5), "subtraction");
        Assert.assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
        Assert.assertEquals(97, result.getBody().doubleValue(), 0.001);
    }
}
