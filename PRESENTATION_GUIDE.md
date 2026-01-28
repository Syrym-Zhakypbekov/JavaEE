# 🎬 Presentation Guide - JavaEE Week 1 Labs

**Quick commands to showcase each project during your presentation.**

---

## 🚀 Quick Start (For Expo)

### Option 1: Use Demo Scripts (Recommended)
```powershell
# Practice 01 - Hello Spring Boot
.\demo-practice01.ps1

# Lab 01 - Student Info App
.\demo-lab01.ps1

# Lab 02 - Users App (Full CRUD)
.\demo-lab02.ps1
```

### Option 2: Manual Start
```powershell
$env:JAVA_HOME = "C:\Program Files\JetBrains\IntelliJ IDEA 2025.2.5\jbr"
$env:Path = "$env:JAVA_HOME\bin;$env:Path"
cd practice01-hello-springboot
.\gradlew.bat bootRun
```

---

## 📋 Presentation Flow

### 1️⃣ Practice 01: Hello Spring Boot (5 minutes)

**What to show:**
1. Project structure in IntelliJ
2. `HelloController.kt` - explain `@RestController` and `@GetMapping`
3. Run the application
4. Open browser and show:
   - http://localhost:8080/ → "Hello, Spring Boot!"
   - http://localhost:8080/greeting → "Welcome to Web Component Development!"

**Key talking points:**
- Spring Boot auto-configuration
- Embedded Tomcat server
- Kotlin with Spring Boot

---

### 2️⃣ Lab 01: Student Info App (10 minutes)

**What to show:**
1. `application.properties` - explain configuration
2. `Student.kt` - data class with fields
3. `StudentController.kt` - GET and POST methods
4. Run the application
5. Test endpoints:
   ```bash
   # Get all students
   curl http://localhost:8080/api/students
   
   # Get specific student
   curl http://localhost:8080/api/students/S001
   
   # Create new student
   curl -X POST http://localhost:8080/api/students \
     -H "Content-Type: application/json" \
     -d '{"id":"S003","name":"Charlie","email":"charlie@iitu.edu.kz","major":"IT"}'
   ```

**Key talking points:**
- Context path configuration (`/api`)
- In-memory storage with HashMap
- JSON serialization
- REST API design

---

### 3️⃣ Lab 02: Users App - Full CRUD (15 minutes)

**What to show:**
1. Project structure with validation
2. `User.kt` - validation annotations
3. `UsersController.kt` - all CRUD operations
4. `GlobalExceptionHandler.kt` - error handling
5. Run the application
6. Full CRUD demo:

```powershell
# Start the app, then run in another terminal:
.\test-api-lab02.ps1
```

**Manual demo sequence:**
```bash
# 1. READ all users
curl http://localhost:8080/users

# 2. CREATE new user
curl -X POST http://localhost:8080/users \
  -H "Content-Type: application/json" \
  -d '{"email":"alice@email.com","name":"Alice"}'

# 3. READ to verify
curl http://localhost:8080/users

# 4. UPDATE user
curl -X PUT http://localhost:8080/users/ximena@email.com \
  -H "Content-Type: application/json" \
  -d '{"email":"ximena@email.com","name":"Ximena Updated"}'

# 5. DELETE user
curl -X DELETE http://localhost:8080/users/norma@email.com

# 6. READ to verify deletion
curl http://localhost:8080/users

# 7. Test 404 error
curl http://localhost:8080/users/notfound@email.com

# 8. Test 400 validation error
curl -X POST http://localhost:8080/users \
  -H "Content-Type: application/json" \
  -d '{"email":"","name":""}'
```

**Key talking points:**
- Complete CRUD operations
- Input validation with annotations
- Error handling (404, 400)
- HTTP status codes
- Production-ready features

---

## 🛠️ Troubleshooting During Presentation

### Port 8080 in use
```bash
# Find process using port 8080
netstat -ano | findstr :8080

# Kill the process
taskkill /PID <PID> /F

# Or change port in application.properties
server.port=8081
```

### Gradle not found
```powershell
# Use full path to gradlew
.\gradlew.bat bootRun
```

### Java version issues
```powershell
# Set JAVA_HOME explicitly
$env:JAVA_HOME = "C:\Program Files\JetBrains\IntelliJ IDEA 2025.2.5\jbr"
$env:Path = "$env:JAVA_HOME\bin;$env:Path"
```

---

## 📊 Demo Checklist

Before presentation:
- [ ] All projects build successfully
- [ ] Practice 01 runs on port 8080
- [ ] Lab 01 runs with context path `/api`
- [ ] Lab 02 runs with full CRUD working
- [ ] Browser tabs prepared with URLs
- [ ] Postman or curl ready for testing
- [ ] Backup plan (IntelliJ can run all projects)

During presentation:
- [ ] Show code structure
- [ ] Run the application
- [ ] Test endpoints live
- [ ] Show error handling
- [ ] Highlight Kotlin features

---

## 🎯 Key Features to Highlight

1. **Kotlin Data Classes** - Less boilerplate than Java
2. **Null Safety** - Prevents NullPointerExceptions
3. **Spring Boot Auto-Configuration** - Convention over configuration
4. **Embedded Tomcat** - No external server needed
5. **Validation** - Automatic input validation
6. **Error Handling** - Professional error responses

---

## 🔗 URLs for Quick Access

| Project | URL |
|---------|-----|
| Practice 01 - Hello | http://localhost:8080/ |
| Practice 01 - Greeting | http://localhost:8080/greeting |
| Lab 01 - All Students | http://localhost:8080/api/students |
| Lab 01 - Health | http://localhost:8080/api/students/health |
| Lab 02 - All Users | http://localhost:8080/users |
| Lab 02 - Health | http://localhost:8080/users/health |

---

**Good luck with your presentation! 🚀**
