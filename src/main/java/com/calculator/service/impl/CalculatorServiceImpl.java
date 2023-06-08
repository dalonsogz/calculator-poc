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

    private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorServiceImpl.class);


    @Override
    public BigDecimal calculate(BigDecimal firstOperator, BigDecimal secondOperator, String operator) {


        if (firstOperator == null || secondOperator == null || operator == null) {
            throw new RuntimeException("Invalid parameters");
        }

        Operation operation = Operation.valueOf(operator.toUpperCase());

        switch (operation) {
            case ADDITION:
                return firstOperator.add(secondOperator);
            case SUBTRACTION:
                return firstOperator.subtract(secondOperator);
            default:
                throw new RuntimeException("Operation not implemented");

        }
    }
}
