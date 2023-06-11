package com.calculator.api;

import com.calculator.model.OperationResponse;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.math.BigDecimal;
import java.util.Optional;

@SpringBootTest
class CalculateApiTest {

    @Mock
    private NativeWebRequest nativeWebRequest;

    @InjectMocks
    private CalculateApi calculateApi = new CalculateApi() {
        @Override
        public Optional<NativeWebRequest> getRequest() {
            return Optional.of(nativeWebRequest);
        }
    };

    @Spy
    private CalculateApi calculateApiImpl;

    @Test
    public void getRequestTest() {
        // Just for coverage
        Optional<NativeWebRequest> nativeWebRequest = calculateApiImpl.getRequest();
        Assert.assertEquals(Optional.empty(), nativeWebRequest);
    }

    @Test
    public void calculateTest() {
        ResponseEntity<OperationResponse> responseEntity = calculateApi.calculate(new BigDecimal(1.5), new BigDecimal(1.5), "addition");
        Assert.assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
