package com.calculator.model;

import com.calculator.exception.InvalidOperationException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class EnumOperationExecutor implements OperationExecutor {
    @Override
    public BigDecimal execute(Operation operation, BigDecimal firstOperator, BigDecimal secondOperator) {
        switch (operation) {
            case ADDITION:
                return firstOperator.add(secondOperator);
            case SUBTRACTION:
                return firstOperator.subtract(secondOperator);
            default:
                throw new InvalidOperationException("Invalid operation");
        }
    }
}
