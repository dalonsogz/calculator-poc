package com.calculator.model;

import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
public class OperationExecutorAddition implements OperationExecutor {

    @Override
    public Operation getOperationType() {
        return Operation.ADDITION;
    }

    @Override
    public BigDecimal execute(Operation operation, BigDecimal firstOperator, BigDecimal secondOperator) {
        return firstOperator.add(secondOperator);
    }
}
