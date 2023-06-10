package com.calculator.service;

import java.math.BigDecimal;

public interface CalculatorService {

    enum Operation {
        ADDITION, SUBTRACTION;
    }

    BigDecimal calculate(BigDecimal firstOperator, BigDecimal secondOperator, String operation);
}
