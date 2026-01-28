================================================================================
Lab 01 - Student Info App
Web Component Development (Java EE) - Week 1
Lab 1.1 & 1.2
================================================================================

PROJECT DESCRIPTION:
-------------------
This application demonstrates:
- Spring Boot project setup with Spring Initializr-style structure
- Application configuration via application.properties
- REST controller with multiple endpoints
- Data model class (Student)
- In-memory storage using HashMap
- GET and POST operations

TECHNOLOGIES USED:
-----------------
- Spring Boot 3.2.5
- Spring Web (REST API)
- Spring Boot DevTools (hot reload)
- Kotlin 1.9.23
- Gradle (Kotlin DSL)
- Java 17

PROJECT STRUCTURE:
-----------------
lab01-student-info/
├── src/main/kotlin/com/iitu/webdev/studentinfoapp/
│   ├── StudentInfoAppApplication.kt          # Main application class
│   ├── model/
│   │   └── Student.kt                        # Student data class
│   └── controller/
│       └── StudentController.kt              # REST controller
├── src/main/resources/
│   └── application.properties                # Configuration
└── build.gradle.kts                          # Gradle build configuration

CONFIGURATION (application.properties):
--------------------------------------
spring.application.name=Student Info App
server.port=8080
server.servlet.context-path=/api              # All endpoints prefixed with /api
logging.level.com.iitu.webdev=DEBUG

BASE URL:
--------
http://localhost:8080/api

API ENDPOINTS:
-------------
GET    /api/students           - Get all students
GET    /api/students/{id}      - Get student by ID (e.g., S001, S002)
POST   /api/students           - Create new student
GET    /api/students/health    - Health check endpoint

SAMPLE STUDENT JSON:
-------------------
{
    "id": "S003",
    "name": "Charlie Brown",
    "email": "charlie@iitu.edu.kz",
    "major": "Information Systems"
}

INITIAL DATA:
------------
S001: Alice Johnson, alice@iitu.edu.kz, Computer Science
S002: Bob Smith, bob@iitu.edu.kz, Software Engineering

HOW TO RUN:
----------
1. Open project in IntelliJ IDEA
2. Wait for Gradle sync to complete
3. Run StudentInfoAppApplication.kt
4. Application will start on port 8080

TESTING WITH CURL:
-----------------
# Get all students
curl http://localhost:8080/api/students

# Get student by ID
curl http://localhost:8080/api/students/S001

# Create new student
curl -X POST http://localhost:8080/api/students \
  -H "Content-Type: application/json" \
  -d '{"id":"S003","name":"Charlie","email":"charlie@iitu.edu.kz","major":"IT"}'

# Health check
curl http://localhost:8080/api/students/health

================================================================================
