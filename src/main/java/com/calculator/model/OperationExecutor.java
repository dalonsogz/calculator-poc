package com.calculator.model;

import java.math.BigDecimal;

public interface OperationExecutor {

    Operation getOperationType();

    BigDecimal execute(Operation operation, BigDecimal firstOperator, BigDecimal secondOperator);
}