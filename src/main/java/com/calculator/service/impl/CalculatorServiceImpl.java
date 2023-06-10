package com.calculator.service.impl;

import com.calculator.service.CalculatorService;
import io.corp.calculator.TracerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Autowired
    private TracerImpl tracer;

    @Override
    public BigDecimal calculate(BigDecimal firstOperator, BigDecimal secondOperator, String operation) {

        switch (Operation.valueOf(operation.toUpperCase())) {
            case ADDITION:
                return firstOperator.add(secondOperator);
            case SUBTRACTION:
                return firstOperator.subtract(secondOperator);
            default:
                throw new RuntimeException("Invalid operation");
        }
    }
}
