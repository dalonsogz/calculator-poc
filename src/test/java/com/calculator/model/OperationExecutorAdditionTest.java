package com.calculator.model;

import com.calculator.model.Operation;
import com.calculator.model.OperationExecutorAddition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class OperationExecutorAdditionTest {

    private OperationExecutorAddition executor;

    @BeforeEach
    void setUp() {
        executor = new OperationExecutorAddition();
    }

    @Test
    void getOperationType_ShouldReturnAdditionOperation() {
        Operation operation = executor.getOperationType();
        Assertions.assertEquals(Operation.ADDITION, operation);
    }

    @Test
    void execute_ShouldReturnSumOfOperands() {
        BigDecimal firstOperator = BigDecimal.valueOf(5);
        BigDecimal secondOperator = BigDecimal.valueOf(10);
        BigDecimal expected = BigDecimal.valueOf(15);

        BigDecimal result = executor.execute(Operation.ADDITION, firstOperator, secondOperator);

        Assertions.assertEquals(expected, result);
    }
}
