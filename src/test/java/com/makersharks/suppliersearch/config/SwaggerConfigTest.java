package com.makersharks.suppliersearch.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SwaggerConfigTest {

    @Test
    public void testCustomOpenAPI() {
        // Create a Spring application context and register the SwaggerConfig class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SwaggerConfig.class);

        // Retrieve the OpenAPI bean from the context
        OpenAPI openAPI = context.getBean(OpenAPI.class);

        // Assert that the OpenAPI bean is not null
        assertNotNull(openAPI, "OpenAPI bean should not be null");

        // Assert that the Info object within OpenAPI is correctly configured
        Info info = openAPI.getInfo();
        assertNotNull(info, "Info object should not be null");
        assertEquals("Supplier Search API", info.getTitle(), "API title should be 'Supplier Search API'");
        assertEquals("1.0", info.getVersion(), "API version should be '1.0'");
        assertEquals("API for searching suppliers based on specific criteria", info.getDescription(), "API description should match");

        // Close the application context
        context.close();
    }
}
