package com.calculator.model;

import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
public class OperationExecutorSubtraction implements OperationExecutor {

    @Override
    public Operation getOperationType() {
        return Operation.SUBTRACTION;
    }

    @Override
    public BigDecimal execute(Operation operation, BigDecimal firstOperator, BigDecimal secondOperator) {
        return firstOperator.subtract(secondOperator);
    }
}
