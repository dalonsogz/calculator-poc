package com.calculator.service;

import org.openapitools.client.model.CalculateRequest;

import java.math.BigDecimal;

public interface CalculatorService {

    BigDecimal calculate(CalculateRequest calculateRequest);
}
