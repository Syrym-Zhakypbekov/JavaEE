================================================================================
Lab 02 - Users App
Web Component Development (Java EE) - Week 1
Lab 2.1 & 2.2 (Complete CRUD + Bonus Tasks)
================================================================================

PROJECT DESCRIPTION:
-------------------
This application demonstrates complete CRUD operations:
- Create, Read, Update, Delete (CRUD) API
- Input validation with annotations
- Error handling with custom exceptions
- Global exception handler
- HTTP status codes (200, 201, 204, 400, 404)

Based on Chapter 1 from "Pro Spring Boot 3 with Kotlin, 3rd Edition"

TECHNOLOGIES USED:
-----------------
- Spring Boot 3.2.5
- Spring Web (REST API)
- Spring Boot DevTools
- Spring Boot Validation
- Kotlin 1.9.23
- Gradle (Kotlin DSL)
- Java 17

PROJECT STRUCTURE:
-----------------
lab02-users-app/
├── src/main/kotlin/com/iitu/users/
│   ├── UsersAppApplication.kt          # Main application class
│   ├── User.kt                         # User data class with validation
│   ├── UsersController.kt              # Full CRUD controller
│   └── GlobalExceptionHandler.kt       # Error handling (bonus)
├── src/main/resources/
│   └── application.properties          # Configuration
└── build.gradle.kts                    # Gradle build configuration

CONFIGURATION:
-------------
Server Port: 8080
No context path (endpoints at root)

API ENDPOINTS (CRUD):
--------------------
| Method | Endpoint           | Description              |
|--------|--------------------|--------------------------|
| GET    | /users             | Get all users            |
| GET    | /users/{email}     | Get user by email        |
| POST   | /users             | Create new user          |
| PUT    | /users/{email}     | Update existing user     |
| DELETE | /users/{email}     | Delete user              |
| GET    | /users/health      | Health check             |

SAMPLE USER JSON:
----------------
{
    "email": "alice@email.com",
    "name": "Alice"
}

VALIDATION RULES:
----------------
- email: Required, must be valid email format
- name: Required, cannot be blank

INITIAL DATA:
------------
ximena@email.com: Ximena
norma@email.com: Norma

ERROR RESPONSES:
---------------
404 Not Found - User not found
400 Bad Request - Validation failed
500 Internal Server Error - Unexpected error

HOW TO RUN:
----------
1. Open project in IntelliJ IDEA
2. Wait for Gradle sync to complete
3. Run UsersAppApplication.kt
4. Application will start on port 8080

TESTING WITH CURL:
-----------------

--- READ ---
# Get all users
curl http://localhost:8080/users

# Get user by email
curl http://localhost:8080/users/ximena@email.com

--- CREATE ---
# Create new user
curl -X POST http://localhost:8080/users \
  -H "Content-Type: application/json" \
  -d '{"email":"alice@email.com","name":"Alice"}'

--- UPDATE ---
# Update existing user
curl -X PUT http://localhost:8080/users/ximena@email.com \
  -H "Content-Type: application/json" \
  -d '{"email":"ximena@email.com","name":"Ximena Updated"}'

--- DELETE ---
# Delete user
curl -X DELETE http://localhost:8080/users/norma@email.com

--- ERROR TESTING ---
# Get non-existent user (404)
curl http://localhost:8080/users/notfound@email.com

# Invalid data (400)
curl -X POST http://localhost:8080/users \
  -H "Content-Type: application/json" \
  -d '{"email":"","name":""}'

CRUD TEST SEQUENCE:
------------------
1. GET /users - See initial 2 users
2. POST /users - Create alice@email.com
3. GET /users - Verify 3 users now
4. GET /users/alice@email.com - Get specific user
5. PUT /users/alice@email.com - Update Alice
6. DELETE /users/norma@email.com - Delete Norma
7. GET /users - Verify back to 2 users

================================================================================
