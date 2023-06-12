package com.calculator.controller;

import com.calculator.model.OperationResponse;
import com.calculator.service.CalculatorService;
import io.corp.calculator.TracerImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class CalculatorControllerTest {

    @Mock
    TracerImpl tracer;

    @Mock
    CalculatorService calculatorService;

    @InjectMocks
    CalculatorController calculatorController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void calculate_ValidInput_ReturnsOperationResponse() {
        // Arrange
        BigDecimal firstOperator = BigDecimal.valueOf(10);
        BigDecimal secondOperator = BigDecimal.valueOf(5);
        String operation = "addition";
        BigDecimal expectedResult = BigDecimal.valueOf(15);

        when(calculatorService.calculate(firstOperator, secondOperator, operation))
                .thenReturn(expectedResult);

        // Act
        ResponseEntity<OperationResponse> response = calculatorController.calculate(firstOperator, secondOperator, operation);

        // Assert
        assertEquals(expectedResult, response.getBody().getResult());
        assertEquals(200, response.getStatusCodeValue());
    }
}
