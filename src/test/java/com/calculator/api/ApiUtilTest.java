package com.calculator.api;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.context.request.NativeWebRequest;

import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApiUtilTest {

    @Mock
    private HttpServletResponse response;

    @Mock
    private NativeWebRequest nativeWebRequest;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSetExampleResponse_Exception() {
        // Create a mock NativeWebRequest that throws IOException
        NativeWebRequest mockWebRequest = createMockNativeWebRequestWithIOException();

        // Expect an IOException to be thrown
        assertThrows(RuntimeException.class, () ->
                ApiUtil.setExampleResponse(mockWebRequest, "text/plain", "Example"));
    }

    private NativeWebRequest createMockNativeWebRequestWithIOException() {
        return new NativeWebRequest() {
            @Override
            public Object getAttribute(String name, int scope) {
                return null;
            }

            @Override
            public void setAttribute(String name, Object value, int scope) {

            }

            @Override
            public void removeAttribute(String name, int scope) {

            }

            @Override
            public String[] getAttributeNames(int scope) {
                return new String[0];
            }

            @Override
            public void registerDestructionCallback(String name, Runnable callback, int scope) {

            }

            @Override
            public Object resolveReference(String key) {
                return null;
            }

            @Override
            public String getSessionId() {
                return null;
            }

            @Override
            public Object getSessionMutex() {
                return null;
            }

            @Override
            public Object getNativeRequest() {
                throw new RuntimeException("IOException");
            }

            @Override
            public Object getNativeResponse() {
                throw new RuntimeException("IOException");
            }

            @Override
            public <T> T getNativeRequest(Class<T> requiredType) {
                throw new RuntimeException("IOException");
            }

            @Override
            public <T> T getNativeResponse(Class<T> requiredType) {
                throw new RuntimeException("IOException");
            }

            @Override
            public String getHeader(String name) {
                throw new RuntimeException("IOException");
            }

            @Override
            public String[] getHeaderValues(String name) {
                throw new RuntimeException("IOException");
            }

            @Override
            public Iterator<String> getHeaderNames() {
                return null;
            }

            @Override
            public String getParameter(String paramName) {
                return null;
            }

            @Override
            public String[] getParameterValues(String paramName) {
                return new String[0];
            }

            @Override
            public Iterator<String> getParameterNames() {
                return null;
            }

            @Override
            public Map<String, String[]> getParameterMap() {
                return null;
            }

            @Override
            public Locale getLocale() {
                return null;
            }

            @Override
            public String getContextPath() {
                return null;
            }

            @Override
            public String getRemoteUser() {
                return null;
            }

            @Override
            public Principal getUserPrincipal() {
                return null;
            }

            @Override
            public boolean isUserInRole(String role) {
                return false;
            }

            @Override
            public boolean isSecure() {
                return false;
            }

            @Override
            public boolean checkNotModified(long lastModifiedTimestamp) {
                return false;
            }

            @Override
            public boolean checkNotModified(String etag) {
                return false;
            }

            @Override
            public boolean checkNotModified(String etag, long lastModifiedTimestamp) {
                return false;
            }

            @Override
            public String getDescription(boolean includeClientInfo) {
                return null;
            }
        };
    }
}
