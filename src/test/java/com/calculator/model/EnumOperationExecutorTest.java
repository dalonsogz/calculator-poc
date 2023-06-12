package com.calculator.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class EnumOperationExecutorTest {


    private final EnumOperationExecutor operationExecutor = new EnumOperationExecutor();

    @Test
    public void testExecute_Addition_Success() {
        // Arrange
        BigDecimal firstOperator = BigDecimal.valueOf(10);
        BigDecimal secondOperator = BigDecimal.valueOf(5);
        Operation operation = Operation.ADDITION;

        // Act
        BigDecimal result = operationExecutor.execute(operation, firstOperator, secondOperator);

        // Assert
        Assertions.assertEquals(BigDecimal.valueOf(15), result);
    }

    @Test
    public void testExecute_Subtraction_Success() {
        // Arrange
        BigDecimal firstOperator = BigDecimal.valueOf(10);
        BigDecimal secondOperator = BigDecimal.valueOf(5);
        Operation operation = Operation.SUBTRACTION;

        // Act
        BigDecimal result = operationExecutor.execute(operation, firstOperator, secondOperator);

        // Assert
        Assertions.assertEquals(BigDecimal.valueOf(5), result);
    }

}

