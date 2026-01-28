# 🎓 JavaEE Web Component Development - Week 1 Labs

Complete Kotlin implementation of all Week 1 labs for Web Component Development (Java EE) course.

---

## 📚 Table of Contents

1. [Project Structure](#project-structure)
2. [Practice 01: Hello Spring Boot](#practice-01-hello-spring-boot)
3. [Lab 01: Student Info App](#lab-01-student-info-app)
4. [Lab 02: Users App (Complete CRUD)](#lab-02-users-app-complete-crud)
5. [How to Run in IntelliJ IDEA](#how-to-run-in-intellij-idea)
6. [Testing with cURL](#testing-with-curl)
7. [Understanding the Code](#understanding-the-code)

---

## 📁 Project Structure

```
JavaEE/
├── practice01-hello-springboot/    # Practice Work 1 - Hello World
│   ├── src/main/kotlin/com/iitu/student/hellospringboot/
│   │   ├── HelloSpringBootApplication.kt   # Main class
│   │   └── HelloController.kt              # REST controller
│   └── build.gradle.kts
│
├── lab01-student-info/             # Lab 1.1 & 1.2 - Student API
│   ├── src/main/kotlin/com/iitu/webdev/studentinfoapp/
│   │   ├── StudentInfoAppApplication.kt    # Main class
│   │   ├── model/Student.kt                # Data model
│   │   └── controller/StudentController.kt # REST controller
│   └── build.gradle.kts
│
├── lab02-users-app/                # Lab 2.1 & 2.2 - Users CRUD API
│   ├── src/main/kotlin/com/iitu/users/
│   │   ├── UsersAppApplication.kt          # Main class
│   │   ├── User.kt                         # Data model with validation
│   │   ├── UsersController.kt              # Full CRUD controller
│   │   └── GlobalExceptionHandler.kt       # Error handling
│   └── build.gradle.kts
│
└── README.md                       # This file
```

---

## 🚀 Practice 01: Hello Spring Boot

### What You'll Learn
- Creating a Spring Boot project structure
- Understanding the main application class
- Creating your first REST controller
- Running and testing a Spring Boot application

### Project Details
- **Group**: `com.iitu.student`
- **Artifact**: `hello-spring-boot`
- **Port**: 8080

### Endpoints

| Method | Endpoint    | Description                     |
|--------|-------------|---------------------------------|
| GET    | `/`         | Returns "Hello, Spring Boot!"   |
| GET    | `/greeting` | Returns course welcome message  |

### How to Run
```bash
cd practice01-hello-springboot
./gradlew bootRun
```

### Test in Browser
- http://localhost:8080/
- http://localhost:8080/greeting

---

## 👨‍🎓 Lab 01: Student Info App

### What You'll Learn
- Configuring `application.properties`
- Creating a data model class
- Building a REST controller with multiple endpoints
- Using in-memory storage (HashMap)
- Understanding Spring annotations

### Project Details
- **Group**: `com.iitu.webdev`
- **Artifact**: `student-info-app`
- **Base URL**: http://localhost:8080/api
- **Context Path**: `/api`

### Configuration (`application.properties`)

```properties
# Application name
spring.application.name=Student Info App

# Server runs on port 8080
server.port=8080

# All endpoints prefixed with /api
server.servlet.context-path=/api

# Logging levels
logging.level.root=INFO
logging.level.com.iitu.webdev=DEBUG
```

### Endpoints

| Method | Endpoint               | Description                 |
|--------|------------------------|-----------------------------|
| GET    | `/api/students`        | Get all students            |
| GET    | `/api/students/{id}`   | Get student by ID           |
| POST   | `/api/students`        | Create new student          |
| GET    | `/api/students/health` | Health check                |

### Sample Student JSON
```json
{
  "id": "S003",
  "name": "Charlie Brown",
  "email": "charlie@iitu.edu.kz",
  "major": "Information Systems"
}
```

---

## 👥 Lab 02: Users App (Complete CRUD)

### What You'll Learn
- Complete CRUD operations (Create, Read, Update, Delete)
- Input validation with annotations
- Error handling and custom exceptions
- HTTP status codes
- Global exception handling

### Project Details
- **Group**: `com.iitu.users`
- **Artifact**: `users-app`
- **Port**: 8080

### CRUD Operations

| Operation | HTTP Method | Endpoint              | Description           |
|-----------|-------------|-----------------------|-----------------------|
| Create    | POST        | `/users`              | Create new user       |
| Read All  | GET         | `/users`              | Get all users         |
| Read One  | GET         | `/users/{email}`      | Get user by email     |
| Update    | PUT         | `/users/{email}`      | Update existing user  |
| Delete    | DELETE      | `/users/{email}`      | Delete user           |

### Validation Rules
- **email**: Required, must be valid email format
- **name**: Required, cannot be blank

### Error Responses
When validation fails or user not found:
```json
{
  "timestamp": "2026-01-28T10:30:00",
  "status": 400,
  "error": "Validation Failed",
  "message": "Input validation failed",
  "details": {
    "email": "Email is required",
    "name": "Name is required"
  }
}
```

---

## 🔧 How to Run in IntelliJ IDEA

### Step 1: Open Project
1. Open IntelliJ IDEA
2. Click **File → Open**
3. Select the project folder (e.g., `lab02-users-app`)
4. Wait for Gradle sync to complete

### Step 2: Verify Project Structure
Ensure you see this structure:
```
lab02-users-app/
├── src/
│   ├── main/
│   │   ├── kotlin/com/iitu/users/
│   │   └── resources/application.properties
│   └── test/
└── build.gradle.kts
```

### Step 3: Run the Application
**Method 1 - Using IDE:**
1. Open the main application file (e.g., `UsersAppApplication.kt`)
2. Click the green play button next to the class
3. Select **Run 'UsersAppApplicationKt'**

**Method 2 - Using Terminal:**
```bash
# Navigate to project directory
cd lab02-users-app

# Run with Gradle wrapper (Windows)
.\gradlew.bat bootRun

# Run with Gradle wrapper (Mac/Linux)
./gradlew bootRun
```

### Step 4: Verify Application is Running
Look for these messages in the console:
```
Started UsersAppApplicationKt in X.XXX seconds
Tomcat started on port(s): 8080 (http)
```

---

## 🧪 Testing with cURL

### Practice 01 - Hello Spring Boot
```bash
# Test root endpoint
curl http://localhost:8080/
# Output: Hello, Spring Boot!

# Test greeting endpoint
curl http://localhost:8080/greeting
# Output: Welcome to Web Component Development!
```

### Lab 01 - Student Info App
```bash
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
```

### Lab 02 - Users App

#### Read Operations (GET)
```bash
# Get all users
curl http://localhost:8080/users

# Get user by email
curl http://localhost:8080/users/ximena@email.com

# Try to get non-existent user (should return 404)
curl http://localhost:8080/users/nonexistent@email.com
```

#### Create Operation (POST)
```bash
# Create new user
curl -X POST http://localhost:8080/users \
  -H "Content-Type: application/json" \
  -d '{"email":"alice@email.com","name":"Alice"}'

# Try to create user with invalid data (should return 400)
curl -X POST http://localhost:8080/users \
  -H "Content-Type: application/json" \
  -d '{"email":"invalid","name":""}'
```

#### Update Operation (PUT)
```bash
# Update existing user
curl -X PUT http://localhost:8080/users/ximena@email.com \
  -H "Content-Type: application/json" \
  -d '{"email":"ximena@email.com","name":"Ximena Updated"}'
```

#### Delete Operation (DELETE)
```bash
# Delete user
curl -X DELETE http://localhost:8080/users/norma@email.com

# Verify deletion
curl http://localhost:8080/users
```

---

## 📖 Understanding the Code

### Key Kotlin Concepts

#### 1. Data Classes
```kotlin
data class User(
    var email: String? = null,
    var name: String? = null
)
```
- Automatically generates `equals()`, `hashCode()`, `toString()`
- Provides `copy()` method
- Much cleaner than Java boilerplate

#### 2. Null Safety
```kotlin
var email: String? = null  // Nullable String (can be null)
users[email!!] = user      // !! asserts non-null (throws if null)
```

#### 3. String Templates
```kotlin
return "Users API is running! Total users: ${users.size}"
```

### Key Spring Boot Annotations

#### @SpringBootApplication
```kotlin
@SpringBootApplication
class UsersAppApplication
```
Combines:
- `@Configuration` - Configuration class
- `@EnableAutoConfiguration` - Auto-configuration
- `@ComponentScan` - Scan for components

#### @RestController
```kotlin
@RestController
@RequestMapping("/users")
class UsersController
```
Combines `@Controller` + `@ResponseBody`

#### HTTP Method Annotations
```kotlin
@GetMapping          // Handle GET requests
@PostMapping         // Handle POST requests
@PutMapping          // Handle PUT requests
@DeleteMapping       // Handle DELETE requests
```

#### Parameter Annotations
```kotlin
@PathVariable email: String     // Extract from URL: /users/{email}
@RequestBody user: User         // Convert JSON to object
@Valid user: User               // Trigger validation
```

---

## 📋 Submission Checklist

- [ ] All projects run without errors
- [ ] All endpoints tested with cURL/browser
- [ ] Code has proper comments explaining key concepts
- [ ] Git commits follow conventional format:
  ```
  feat: add Practice 1 project structure
  feat: implement HelloController with two endpoints
  feat: add Student model and REST controller
  feat: implement Users CRUD operations
  ```

---

## 🔗 Useful Resources

- [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/)
- [Kotlin Documentation](https://kotlinlang.org/docs/)
- [Spring Initializr](https://start.spring.io/)
- [HTTP Status Codes](https://httpstatuses.com/)

---

## 📝 Notes

1. **Port Conflicts**: If port 8080 is busy, change it in `application.properties`:
   ```properties
   server.port=8081
   ```

2. **Gradle Wrapper**: If you don't have Gradle installed, use the wrapper:
   - Windows: `gradlew.bat bootRun`
   - Mac/Linux: `./gradlew bootRun`

3. **Hot Reload**: Spring Boot DevTools provides automatic restart when files change.

4. **Logging**: Check console output for detailed logs at DEBUG level for application packages.

---

**Happy Coding! 🚀**
