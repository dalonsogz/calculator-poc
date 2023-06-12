package com.calculator.service.impl;

import com.calculator.exception.InvalidOperationException;
import com.calculator.model.Operation;
import com.calculator.model.OperationExecutor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;


class CalculatorServiceImplTest {

    @Mock
    OperationExecutor operationExecutor;

    @InjectMocks
    CalculatorServiceImpl calculatorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCalculate_Addition() {
        // Arrange
        BigDecimal firstOperator = BigDecimal.valueOf(5);
        BigDecimal secondOperator = BigDecimal.valueOf(3);
        String operation = "ADDITION";
        BigDecimal expectedResult = BigDecimal.valueOf(8);

        Mockito.when(operationExecutor.execute(Operation.ADDITION, firstOperator, secondOperator))
                .thenReturn(expectedResult);

        // Act
        BigDecimal result = calculatorService.calculate(firstOperator, secondOperator, operation);

        // Assert
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    void testCalculate_Subtraction() {
        // Arrange
        BigDecimal firstOperator = BigDecimal.valueOf(5);
        BigDecimal secondOperator = BigDecimal.valueOf(3);
        String operation = "SUBTRACTION";
        BigDecimal expectedResult = BigDecimal.valueOf(2);

        Mockito.when(operationExecutor.execute(Operation.SUBTRACTION, firstOperator, secondOperator))
                .thenReturn(expectedResult);

        // Act
        BigDecimal result = calculatorService.calculate(firstOperator, secondOperator, operation);

        // Assert
        Assertions.assertEquals(expectedResult, result);
    }


    @Test
    void testCalculate_InvalidOperation() {
        // Arrange
        BigDecimal firstOperator = BigDecimal.valueOf(5);
        BigDecimal secondOperator = BigDecimal.valueOf(3);
        String operation = "ADDITION";

        Mockito.when(operationExecutor.execute(Mockito.any(Operation.class), Mockito.any(BigDecimal.class), Mockito.any(BigDecimal.class)))
                .thenThrow(new InvalidOperationException("Invalid operation"));

        // Act & Assert
        Assertions.assertThrows(InvalidOperationException.class,
                () -> calculatorService.calculate(firstOperator, secondOperator, operation));
    }

}
