package com.calculator.api;

import org.junit.jupiter.api.Test;
import org.springframework.web.context.request.NativeWebRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class ApiUtilTest {

    @Test
    void setExampleResponse_IOException_ThrowsRuntimeException() throws IOException {
        // Arrange
        NativeWebRequest req = mock(NativeWebRequest.class);
        HttpServletResponse res = mock(HttpServletResponse.class);
        when(req.getNativeResponse(HttpServletResponse.class)).thenReturn(res);
        doThrow(IOException.class).when(res).getWriter();

        String contentType = "application/json";
        String example = "{ \"result\": 10 }";

        // Act & Assert
        assertThrows(RuntimeException.class, () -> ApiUtil.setExampleResponse(req, contentType, example));

    }
}
