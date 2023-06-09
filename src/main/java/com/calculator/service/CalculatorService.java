package com.calculator.service;

import java.math.BigDecimal;

public interface CalculatorService {

    BigDecimal calculate(BigDecimal firstOperator, BigDecimal secondOperator, String operation);
}
