# Bank Service API

The Bank Service API is a RESTful web service designed to manage bank accounts and transactions. It provides endpoints for creating banks, managing accounts, performing transactions, and retrieving transaction history and account balances.

## Features

- Create banks with transaction flat fee and percent fee values.
- Create accounts within banks.
- Perform transactions between accounts, including withdrawals and deposits.
- Retrieve transaction history for any account.
- Check account balances for any account.
- Retrieve a list of all bank accounts.
- View bank-level statistics such as total transaction fee amount and total transfer amount.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- H2 Database (In-memory)
- Swagger (for API documentation)
- Gradle (for building and dependency management)
- Docker (for containerization)

## Setup

1. Clone the repository to your local machine.
2. Make sure you have Java, Gradle, and Docker installed.
3. Build the project using Gradle: `./gradlew clean build`.
4. Build the Docker image: `docker build -t bank-service .`.
5. Run the Docker container: `docker run -p 8080:8080 bank-service`.

## API Documentation

The API documentation is available via Swagger UI. After running the application, navigate to `http://localhost:8080/swagger-ui.html` in your web browser to view the API documentation.

## Usage

You can use tools like cURL, Swagger Postman, or any HTTP client to interact with the API endpoints. Make sure to provide the required parameters for each endpoint as described in the API documentation.
