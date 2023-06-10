package com.calculator.api;

import com.calculator.CalculatorApplication;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.NativeWebRequest;

import java.math.BigDecimal;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CalculatorApplication.class)
class CalculateApiTest {

    @Spy
    private CalculateApi calculateApiImpl;

    @Test
    public void getRequestTest() {
        Optional<NativeWebRequest> nativeWebRequest = calculateApiImpl.getRequest();
        Assert.assertEquals(Optional.empty(), nativeWebRequest);
    }

    @Test
    public void calculateTest() {
        ResponseEntity<BigDecimal> responseEntity = calculateApiImpl.calculate(new BigDecimal(1.5),new BigDecimal(1.5),"addition");
        Assert.assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
