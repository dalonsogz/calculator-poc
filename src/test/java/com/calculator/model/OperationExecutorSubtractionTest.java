package com.calculator.model;

import com.calculator.model.Operation;
import com.calculator.model.OperationExecutorSubtraction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class OperationExecutorSubtractionTest {

    @Test
    public void testGetOperationType() {
        // Arrange
        OperationExecutorSubtraction executor = new OperationExecutorSubtraction();

        // Act
        Operation operationType = executor.getOperationType();

        // Assert
        Assertions.assertEquals(Operation.SUBTRACTION, operationType);
    }

    @Test
    public void testExecute_SubtractionOperation_ExecutedSuccessfully() {
        // Arrange
        OperationExecutorSubtraction executor = new OperationExecutorSubtraction();
        BigDecimal firstOperator = BigDecimal.valueOf(10);
        BigDecimal secondOperator = BigDecimal.valueOf(5);

        // Act
        BigDecimal result = executor.execute(Operation.SUBTRACTION, firstOperator, secondOperator);

        // Assert
        Assertions.assertEquals(BigDecimal.valueOf(5), result);
    }
}
