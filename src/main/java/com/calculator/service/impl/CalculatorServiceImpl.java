package com.calculator.service.impl;

import com.calculator.model.Operation;
import com.calculator.service.CalculatorService;
import org.openapitools.client.model.CalculateRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Locale;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public BigDecimal calculate(CalculateRequest calculateRequest) {

        BigDecimal firstOperator = calculateRequest.getFirstOp();
        BigDecimal secondOperator = calculateRequest.getSecondOp();
        String operation = calculateRequest.getOperation();

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
