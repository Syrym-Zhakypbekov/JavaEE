# 🚀 Quick Start Guide

This guide will walk you through running each lab step by step in IntelliJ IDEA.

---

## Prerequisites

1. **Java 17 or 21** installed
2. **IntelliJ IDEA** (Community or Ultimate edition)
3. **Kotlin plugin** enabled in IntelliJ (usually included by default)

---

## 📝 Practice 01: Hello Spring Boot

### Step 1: Open Project
1. Open IntelliJ IDEA
2. Click **File → Open**
3. Navigate to `C:\Users\syrym\IdeaProjects\JavaEE\practice01-hello-springboot`
4. Click **OK**
5. Wait for Gradle sync (see progress at bottom of IDE)

### Step 2: Run Application
1. Open `src/main/kotlin/com/iitu/student/hellospringboot/HelloSpringBootApplication.kt`
2. Click the green **play button** ▶️ next to the class name
3. Select **Run 'HelloSpringBootApplicationKt'**

### Step 3: Test
Open browser and visit:
- http://localhost:8080/ → "Hello, Spring Boot!"
- http://localhost:8080/greeting → "Welcome to Web Component Development!"

---

## 👨‍🎓 Lab 01: Student Info App

### Step 1: Stop Previous Application
Click the red **stop button** ⏹️ in IntelliJ run panel (if Practice 01 is running)

### Step 2: Open Project
1. Click **File → Open**
2. Navigate to `C:\Users\syrym\IdeaProjects\JavaEE\lab01-student-info`
3. Click **OK**
4. Wait for Gradle sync

### Step 3: Run Application
1. Open `src/main/kotlin/com/iitu/webdev/studentinfoapp/StudentInfoAppApplication.kt`
2. Click the green **play button** ▶️
3. Select **Run 'StudentInfoAppApplicationKt'**

### Step 4: Test Endpoints

**Using Browser:**
- http://localhost:8080/api/students → List all students
- http://localhost:8080/api/students/S001 → Get specific student
- http://localhost:8080/api/students/health → Health check

**Using cURL (Command Prompt):**
```cmd
curl http://localhost:8080/api/students
```

**Create a new student:**
```cmd
curl -X POST http://localhost:8080/api/students -H "Content-Type: application/json" -d "{\"id\":\"S003\",\"name\":\"Charlie\",\"email\":\"charlie@iitu.edu.kz\",\"major\":\"IT\"}"
```

---

## 👥 Lab 02: Users App (Complete CRUD)

### Step 1: Stop Previous Application
Click the red **stop button** ⏹️ (if Lab 01 is running)

### Step 2: Open Project
1. Click **File → Open**
2. Navigate to `C:\Users\syrym\IdeaProjects\JavaEE\lab02-users-app`
3. Click **OK**
4. Wait for Gradle sync

### Step 3: Run Application
1. Open `src/main/kotlin/com/iitu/users/UsersAppApplication.kt`
2. Click the green **play button** ▶️
3. Select **Run 'UsersAppApplicationKt'**

### Step 4: Test CRUD Operations

**READ all users:**
```cmd
curl http://localhost:8080/users
```

**READ one user:**
```cmd
curl http://localhost:8080/users/ximena@email.com
```

**CREATE new user:**
```cmd
curl -X POST http://localhost:8080/users -H "Content-Type: application/json" -d "{\"email\":\"alice@email.com\",\"name\":\"Alice\"}"
```

**UPDATE user:**
```cmd
curl -X PUT http://localhost:8080/users/ximena@email.com -H "Content-Type: application/json" -d "{\"email\":\"ximena@email.com\",\"name\":\"Ximena Updated\"}"
```

**DELETE user:**
```cmd
curl -X DELETE http://localhost:8080/users/norma@email.com
```

**Test error handling (404):**
```cmd
curl http://localhost:8080/users/notfound@email.com
```

**Test validation error (400):**
```cmd
curl -X POST http://localhost:8080/users -H "Content-Type: application/json" -d "{\"email\":\"\",\"name\":\"\"}"
```

---

## 🔄 Switching Between Projects

If you have multiple projects open:
1. Use **Alt+Tab** (Windows) or **Cmd+`** (Mac) to switch windows
2. Or click on the IntelliJ icon in taskbar and select the project

---

## 🛑 Stopping the Application

To stop a running application:
1. Click the red **square button** ⏹️ in the Run panel (bottom of IDE)
2. Or press **Ctrl+F2** (Windows/Linux) or **Cmd+F2** (Mac)

---

## ❗ Troubleshooting

### Port 8080 Already in Use
**Error:** `Port 8080 was already in use`

**Solution:**
1. Stop any other running Spring Boot applications
2. Or change port in `application.properties`:
   ```properties
   server.port=8081
   ```

### Gradle Sync Failed
**Solution:**
1. Click the **Gradle** tab on the right side of IDE
2. Click the **refresh/reload** button 🔄
3. Or: **File → Invalidate Caches → Invalidate and Restart**

### Kotlin Not Recognized
**Solution:**
1. **File → Settings → Plugins**
2. Search for "Kotlin" and ensure it's enabled
3. Restart IDE if needed

---

## 📚 File Locations Quick Reference

| Project | Main File Path |
|---------|----------------|
| Practice 01 | `practice01-hello-springboot/src/main/kotlin/.../HelloSpringBootApplication.kt` |
| Lab 01 | `lab01-student-info/src/main/kotlin/.../StudentInfoAppApplication.kt` |
| Lab 02 | `lab02-users-app/src/main/kotlin/.../UsersAppApplication.kt` |

---

**You're all set! Happy coding! 🎉**
