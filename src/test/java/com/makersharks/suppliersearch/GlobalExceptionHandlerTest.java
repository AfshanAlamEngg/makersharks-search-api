package com.makersharks.suppliersearch;

import com.makersharks.suppliersearch.exception.GlobalExceptionHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class GlobalExceptionHandlerTest {

    @Autowired
    private GlobalExceptionHandler globalExceptionHandler;

    @Test
    void testHandleMethodArgumentNotValid() {
        // Mocking MethodArgumentNotValidException
        MethodArgumentNotValidException ex = new MethodArgumentNotValidException(null, null);
        ResponseEntity<Object> response = globalExceptionHandler.handleMethodArgumentNotValid(ex);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertTrue(response.getBody() instanceof Map);
        @SuppressWarnings("unchecked")
        Map<String, String> errors = (Map<String, String>) response.getBody();
        assertTrue(errors.containsKey("fieldName")); // Adjust based on actual error details
    }
}
