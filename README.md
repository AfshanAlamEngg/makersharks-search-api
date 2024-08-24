# Supplier Search API

This API allows users to search for suppliers based on specific criteria such as location, nature of business, and manufacturing processes.

## Features

- Supplier search with pagination
- Input validation
- Global exception handling
- H2 in-memory database for easy testing
- Swagger documentation

## Technologies Used

- Spring Boot
- H2 Database
- ModelMapper
- Swagger
- JUnit 5

## Running the Application

To run the application locally, use the following command:

```bash
./gradlew bootRun
```

## Accessing the API
- Swagger UI: http://localhost:8080/swagger-ui/index.html
- H2 Console: http://localhost:8080/h2-console

## Running Tests
To run the tests, use the following command:

```bash
./gradlew test
```

This structure should provide a comprehensive starting point for your supplier search API 