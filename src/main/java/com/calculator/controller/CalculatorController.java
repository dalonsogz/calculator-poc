package com.calculator.controller;

import com.calculator.service.CalculatorService;
import io.corp.calculator.TracerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1")
public class CalculatorController {

    private TracerImpl tracer = new TracerImpl();

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping(value = "/calculate")
    public ResponseEntity<BigDecimal> calcula(@RequestParam(name = "firstOperator") BigDecimal firstOperator,
                                            @RequestParam(name = "secondOperator") BigDecimal secondOperator,
                                            @RequestParam(name = "operation") String operation) {

        BigDecimal result = this.calculatorService.calculate(firstOperator, secondOperator, operation);
        tracer.trace("firstOperator="+firstOperator+";secondOperator="+secondOperator+";operation="+operation+";result="+result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}