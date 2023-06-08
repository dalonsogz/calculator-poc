package com.calculator;

import com.calculator.config.AppConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.junit.Assert;
import org.junit.runner.RunWith;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CalculatorApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CalculatorApplicationTests {

	@LocalServerPort
	int randomServerPort;

	private ResponseEntity<BigDecimal> calculate(double firstOperator, double secondOperator, String operator) throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:" + randomServerPort +
				"/api/v1/calculate?firstOperator=" + firstOperator +
				"&secondOperator=" + secondOperator + "&operation=" + operator;
		URI uri = new URI(baseUrl);

		ResponseEntity<BigDecimal> result = restTemplate.getForEntity(uri, BigDecimal.class);
		return result;
	}

	@Test
	public void testAdditionOk() throws URISyntaxException {

		ResponseEntity<BigDecimal> result = calculate(4, 6, "addition");

		//Comprueba el resultado
		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertEquals(10.0d, result.getBody().doubleValue(), 0.001d);
	}

	@Test
	public void testSubtractionOk() throws URISyntaxException {

		ResponseEntity<BigDecimal> result = calculate(4, 6, "subtraction");

		//Comprueba el resultado
		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertEquals(-2.0d, result.getBody().doubleValue(), 0.001d);
	}

}
