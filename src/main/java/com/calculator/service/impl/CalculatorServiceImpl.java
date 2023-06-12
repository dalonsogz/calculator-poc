package com.calculator.service.impl;

import com.calculator.model.Operation;
import com.calculator.model.OperationExecutor;
import com.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Autowired
    OperationExecutor operationExecutor;

    @Override
    public BigDecimal calculate(BigDecimal firstOperator, BigDecimal secondOperator, String operation) {
        Operation operationEnum = Operation.valueOf(operation.toUpperCase());
        return operationExecutor.execute(operationEnum, firstOperator, secondOperator);
    }

}
