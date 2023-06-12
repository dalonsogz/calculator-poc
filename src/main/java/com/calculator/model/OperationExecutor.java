package com.calculator.model;

import java.math.BigDecimal;

public interface OperationExecutor {
    BigDecimal execute(Operation operation, BigDecimal firstOperator, BigDecimal secondOperator);
}