package com.calculator.service.impl;

import com.calculator.model.Operation;
import com.calculator.service.CalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Locale;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public BigDecimal calculate(BigDecimal firstOperator, BigDecimal secondOperator, String operation) {

        if (firstOperator == null || secondOperator == null || operation == null) {
            throw new RuntimeException("Invalid parameters");
        }

        switch (Operation.valueOf(operation.toUpperCase())) {
            case ADDITION:
                return firstOperator.add(secondOperator);
            case SUBTRACTION:
                return firstOperator.subtract(secondOperator);
            default:
                throw new RuntimeException("Operation not implemented");

        }
    }
}
