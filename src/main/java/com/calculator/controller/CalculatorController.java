package com.calculator.controller;

import com.calculator.api.CalculateApi;
import com.calculator.model.OperationResponse;
import com.calculator.service.CalculatorService;
import io.corp.calculator.TracerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1")
public class CalculatorController implements CalculateApi {

    @Autowired
    TracerImpl tracer;

    @Autowired
    private CalculatorService calculatorService;

    @Override
    public ResponseEntity<OperationResponse> calculate(BigDecimal firstOperator, BigDecimal secondOperator, String operation) {

        BigDecimal result = this.calculatorService.calculate(firstOperator, secondOperator, operation);

        tracer.trace("firstOperator=" + firstOperator +
                ";secondOperator=" + secondOperator +
                ";operation=" + operation +
                "result=" + result);

        return ResponseEntity.ok(new OperationResponse().result(result));
    }


}
