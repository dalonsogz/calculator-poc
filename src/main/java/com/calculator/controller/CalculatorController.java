package com.calculator.controller;

import com.calculator.api.CalculatorApi;
import com.calculator.domain.Operation;
import com.calculator.model.CalculateRequest;
import com.calculator.service.CalculatorService;
import io.corp.calculator.TracerImpl;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;

@RestController
//@RequestMapping("/api/v1")
public class CalculatorController implements CalculatorApi {

    private TracerImpl tracer = new TracerImpl();

    @Autowired
    private CalculatorService calculatorService;

//    @GetMapping(value = "/calculate")
//    public ResponseEntity<BigDecimal> calculate(@RequestParam(name = "firstOperator") BigDecimal firstOperator,
//                                            @RequestParam(name = "secondOperator") BigDecimal secondOperator,
//                                            @RequestParam(name = "operation") String operation) {
//
//        BigDecimal result = this.calculatorService.calculate(firstOperator, secondOperator, operation);
//        tracer.trace("firstOperator="+firstOperator+";secondOperator="+secondOperator+";operation="+operation+";result="+result);
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }

    @Override
    public ResponseEntity<BigDecimal> calculate(CalculateRequest apiCalculateRequest) {
        Operation operation = new Operation();
        operation.firstOperator = apiCalculateRequest.getFirstOp();
        operation.secondOperator = apiCalculateRequest.getSecondOp();
        operation.operation = apiCalculateRequest.getOperation();

        BigDecimal result = this.calculatorService.calculate(operation.firstOperator, operation.secondOperator,  operation.operation);
        tracer.trace("firstOperator="+operation.firstOperator+";secondOperator="+operation.secondOperator+";operation="+operation.operation+";result="+result);
        return ResponseEntity.ok(result);
    }

}
