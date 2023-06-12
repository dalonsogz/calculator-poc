package com.calculator.service.impl;

import com.calculator.exception.InvalidOperationException;
import com.calculator.model.Operation;
import com.calculator.model.OperationExecutor;
import com.calculator.service.CalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CalculatorServiceImplTest {

    @Mock
    private CalculatorService calculatorService;

    @Mock
    private OperationExecutor additionExecutor;

    @Mock
    private OperationExecutor subtractionExecutor;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);

        // Create a map of operation executors
        Map<Operation, OperationExecutor> operationExecutors = new HashMap<>();
        operationExecutors.put(Operation.ADDITION, additionExecutor);
        operationExecutors.put(Operation.SUBTRACTION, subtractionExecutor);

        // Provide mocks the operation type value
        Mockito.when(additionExecutor.getOperationType()).thenReturn(Operation.ADDITION);
        Mockito.when(subtractionExecutor.getOperationType()).thenReturn(Operation.SUBTRACTION);

        // Create the calculator service instance
        calculatorService = new CalculatorServiceImpl(new ArrayList<>(operationExecutors.values()));
    }

    @Test
    public void testCalculate_AdditionOperation_ExecutedSuccessfully() {
        // Arrange
        BigDecimal firstOperator = BigDecimal.valueOf(10);
        BigDecimal secondOperator = BigDecimal.valueOf(5);
        String operation = "ADDITION";

        BigDecimal expectedResult = BigDecimal.valueOf(15);

        Mockito.when(additionExecutor.execute(Operation.ADDITION, firstOperator, secondOperator)).thenReturn(expectedResult);

        // Act
        BigDecimal result = calculatorService.calculate(firstOperator, secondOperator, operation);

        // Assert
        Assertions.assertEquals(expectedResult, result);
        Mockito.verify(additionExecutor, Mockito.times(1)).execute(Operation.ADDITION, firstOperator, secondOperator);
    }

    @Test
    public void testCalculate_SubtractionOperation_ExecutedSuccessfully() {
        // Arrange
        BigDecimal firstOperator = BigDecimal.valueOf(10);
        BigDecimal secondOperator = BigDecimal.valueOf(5);
        String operation = "SUBTRACTION";

        BigDecimal expectedResult = BigDecimal.valueOf(5);

        Mockito.when(subtractionExecutor.execute(Operation.SUBTRACTION, firstOperator, secondOperator)).thenReturn(expectedResult);

        // Act
        BigDecimal result = calculatorService.calculate(firstOperator, secondOperator, operation);

        // Assert
        Assertions.assertEquals(expectedResult, result);
        Mockito.verify(subtractionExecutor, Mockito.times(1)).execute(Operation.SUBTRACTION, firstOperator, secondOperator);
    }

    @Test
    public void testCalculate_InvalidOperation_ExceptionThrown() {
        // Arrange
        BigDecimal firstOperator = BigDecimal.valueOf(10);
        BigDecimal secondOperator = BigDecimal.valueOf(5);
        String operation = "MULTIPLICATION"; // Invalid operation

        // Act & Assert
        Assertions.assertThrows(InvalidOperationException.class, () ->
                calculatorService.calculate(firstOperator, secondOperator, operation));
    }
}
