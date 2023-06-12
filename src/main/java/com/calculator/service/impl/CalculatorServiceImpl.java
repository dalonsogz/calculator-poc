package com.calculator.service.impl;

import com.calculator.exception.InvalidOperationException;
import com.calculator.model.Operation;
import com.calculator.model.OperationExecutor;
import com.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    private final Map<Operation, OperationExecutor> operationExecutors;

    @Autowired
    public CalculatorServiceImpl(List<OperationExecutor> operationExecutorList) {
        this.operationExecutors = operationExecutorList.stream()
                .collect(Collectors.toMap(OperationExecutor::getOperationType, Function.identity()));
    }

    @Override
    public BigDecimal calculate(BigDecimal firstOperator, BigDecimal secondOperator, String operation) {
        Operation operationEnum = null;
        try {
            operationEnum = Operation.valueOf(operation.toUpperCase());
        } catch (IllegalArgumentException iae) {
            throw new InvalidOperationException("Unsupported operation: " + operation);
        }
        OperationExecutor executor = operationExecutors.get(operationEnum);

        return executor.execute(operationEnum, firstOperator, secondOperator);
    }

}
