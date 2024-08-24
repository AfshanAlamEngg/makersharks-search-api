package com.makersharks.suppliersearch;

import com.makersharks.suppliersearch.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResourceNotFoundExceptionTest {

    @Test
    void testResourceNotFoundException() {
        String message = "Resource not found";
        ResourceNotFoundException exception = new ResourceNotFoundException(message);
        assertEquals(message, exception.getMessage());
    }
}
