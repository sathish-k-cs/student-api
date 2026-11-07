
# Student Management REST API

A REST API developed using Java 21 and Spring Boot 3.5.7.

## Available Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | /students | Retrieve all students |
| POST | /students | Add a new student |
| GET | /health | Check application health |

## Build and Run

Build the application:

mvn clean package

Run the application:

java -Dserver.port=8081 -jar target/student-api-1.0.0.jar

## Testing

Automated tests are implemented using JUnit and Spring Boot Test.
Automatic Jenkins CI trigger verification
