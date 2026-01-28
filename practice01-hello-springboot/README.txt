================================================================================
Practice 01 - Hello Spring Boot
Web Component Development (Java EE) - Week 1
================================================================================

PROJECT DESCRIPTION:
-------------------
This is a basic Spring Boot application demonstrating:
- Spring Boot project structure
- REST controller creation
- Simple GET endpoints
- Kotlin with Spring Boot

TECHNOLOGIES USED:
-----------------
- Spring Boot 3.2.5
- Kotlin 1.9.23
- Gradle (Kotlin DSL)
- Java 17

PROJECT STRUCTURE:
-----------------
practice01-hello-springboot/
├── src/main/kotlin/com/iitu/student/hellospringboot/
│   ├── HelloSpringBootApplication.kt    # Main application class
│   └── HelloController.kt               # REST controller with endpoints
├── src/main/resources/
│   └── application.properties           # Application configuration
└── build.gradle.kts                     # Gradle build configuration

HOW TO RUN:
----------
1. Open project in IntelliJ IDEA
2. Wait for Gradle sync to complete
3. Run HelloSpringBootApplication.kt
4. Application will start on port 8080

API ENDPOINTS:
-------------
GET /           - Returns "Hello, Spring Boot!"
GET /greeting   - Returns "Welcome to Web Component Development!"

TESTING:
-------
Browser: http://localhost:8080/
cURL: curl http://localhost:8080/

CONFIGURATION:
-------------
- Server Port: 8080
- Application Name: Hello Spring Boot

================================================================================
