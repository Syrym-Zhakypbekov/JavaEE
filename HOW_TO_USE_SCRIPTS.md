# 🎬 How to Run & Show Off Your Project

Complete guide for running your JavaEE labs and presenting them like a pro! 🚀

---

## 📋 Table of Contents

1. [What's Available](#whats-available)
2. [Method 1: PowerShell Scripts (Recommended)](#method-1-powershell-scripts-recommended)
3. [Method 2: Command Prompt (.bat files)](#method-2-command-prompt-bat-files)
4. [Method 3: IntelliJ IDEA](#method-3-intellij-idea)
5. [Method 4: Manual Gradle Commands](#method-4-manual-gradle-commands)
6. [How to Show Off (Presentation Tips)](#how-to-show-off-presentation-tips)

---

## What's Available

You have **4 ways** to run each project:

| Method | File Type | Best For |
|--------|-----------|----------|
| PowerShell | `.ps1` | Modern Windows, cool colors |
| Command Prompt | `.bat` | Simple, classic Windows |
| IntelliJ IDEA | IDE | Development, debugging |
| Manual Gradle | Commands | Advanced users |

---

## Method 1: PowerShell Scripts (Recommended ⭐)

### What Are .ps1 Files?
- **PowerShell scripts** - Modern Windows scripting
- Show **colored output** and **cool banners**
- Automatically set up Java environment

### How to Run

#### Step 1: Open PowerShell
1. Right-click on the **JavaEE folder**
2. Select **"Open PowerShell window here"** or **"Open Terminal"**

#### Step 2: Run Any Demo Script
```powershell
# Practice 01 - Hello Spring Boot (simplest)
.\demo-practice01.ps1

# Lab 01 - Student Info App
.\demo-lab01.ps1

# Lab 02 - Users App (Full CRUD - most impressive!)
.\demo-lab02.ps1
```

#### Step 3: What You'll See
```
╔══════════════════════════════════════════════════════════════╗
║                                                              ║
║   🚀 Practice 01: Hello Spring Boot Started!                 ║
║                                                              ║
╚══════════════════════════════════════════════════════════════╝

📦 Building project...
✅ Build successful!

🚀 Starting application...
📍 URL: http://localhost:8080/
📍 URL: http://localhost:8080/greeting

Started HelloSpringBootApplicationKt in 2.5 seconds
Tomcat started on port(s): 8080
```

#### Step 4: Test the API
Open browser and go to:
- http://localhost:8080/
- http://localhost:8080/greeting

---

### Testing Lab 02 with Automated Script

While Lab 02 is running, open **another PowerShell window**:

```powershell
# This runs 9 automated tests!
.\test-api-lab02.ps1
```

**Output will be:**
```
╔══════════════════════════════════════════════════════════════╗
║          Lab 02 - Automated API Testing                       ║
╚══════════════════════════════════════════════════════════════╝

--- Test 1: Get All Users ---
✅ GET http://localhost:8080/users - 200
   📄 [{"email":"ximena@email.com","name":"Ximena"}...]

--- Test 2: Get User by Email ---
✅ GET http://localhost:8080/users/ximena@email.com - 200

--- Test 3: Create New User ---
✅ POST http://localhost:8080/users - 200

--- Test 4: Verify User Created ---
✅ GET http://localhost:8080/users/test@email.com - 200

--- Test 5: Update User ---
✅ PUT http://localhost:8080/users/test@email.com - 200

--- Test 6: Delete User ---
✅ DELETE http://localhost:8080/users/test@email.com - 204 (Expected)

--- Test 7: Verify Deletion (Expect 404) ---
✅ GET http://localhost:8080/users/test@email.com - 404 (Expected)

--- Test 8: Validation Error (Expect 400) ---
✅ POST http://localhost:8080/users - 400 (Expected)

--- Test 9: Health Check ---
✅ GET http://localhost:8080/users/health - 200

╔══════════════════════════════════════════════════════════════╗
║                    TEST SUMMARY                              ║
╠══════════════════════════════════════════════════════════════╣
║  ✅ Passed: 9                                                 ║
║  ❌ Failed: 0                                                 ║
║  📊 Total:  9                                                 ║
╚══════════════════════════════════════════════════════════════╝
```

---

## Method 2: Command Prompt (.bat files)

### What Are .bat Files?
- **Batch files** - Classic Windows commands
- Work in Command Prompt (cmd.exe)
- Simple, no colors, but reliable

### How to Run

#### Step 1: Open Command Prompt
1. Right-click on the **JavaEE folder**
2. Select **"Open Command Prompt here"** or **"Open CMD"**

#### Step 2: Run Any Batch File
```batch
:: Practice 01
run-practice01.bat

:: Lab 01
run-lab01.bat

:: Lab 02 (most impressive)
run-lab02.bat
```

---

## Method 3: IntelliJ IDEA (Best for Development)

### How to Run

#### Step 1: Open Project
1. Open **IntelliJ IDEA**
2. Click **File → Open**
3. Select project folder (e.g., `lab02-users-app`)
4. Wait for Gradle sync (see bottom bar)

#### Step 2: Run Application
1. Open the **Main Application file**:
   - `practice01-hello-springboot`: `HelloSpringBootApplication.kt`
   - `lab01-student-info`: `StudentInfoAppApplication.kt`
   - `lab02-users-app`: `UsersAppApplication.kt`

2. Click the **green play button** ▶️ next to the class name
   ![Green Play Button](https://i.imgur.com/example.png)

3. Select **"Run '...ApplicationKt'"**

#### Step 3: See Cool Startup Banner
```
╔══════════════════════════════════════════════════════════════╗
║   🚀 Lab 02: Users App Started!                              ║
║   Complete CRUD API Implementation                           ║
║                                                              ║
║   📍 Base URL: http://localhost:8080                         ║
╚══════════════════════════════════════════════════════════════╝
```

---

## Method 4: Manual Gradle Commands

### For PowerShell
```powershell
$env:JAVA_HOME = "C:\Program Files\JetBrains\IntelliJ IDEA 2025.2.5\jbr"
$env:Path = "$env:JAVA_HOME\bin;$env:Path"
cd lab02-users-app
.\gradlew.bat bootRun
```

### For Command Prompt
```batch
set JAVA_HOME=C:\Program Files\JetBrains\IntelliJ IDEA 2025.2.5\jbr
set PATH=%JAVA_HOME%\bin;%PATH%
cd lab02-users-app
gradlew.bat bootRun
```

---

## How to Show Off (Presentation Tips) 🎤

### 🎯 The "Wow Factor" Sequence

#### 1. Start with Practice 01 (30 seconds)
```powershell
.\demo-practice01.ps1
```
**Say:** *"This is the simplest Spring Boot app. Just 2 endpoints."*

Open browser:
- http://localhost:8080/ → Shows "Hello, Spring Boot!"
- http://localhost:8080/greeting → Shows welcome message

---

#### 2. Show Lab 01 - Student Info (1 minute)
```powershell
.\demo-lab01.ps1
```
**Say:** *"Now with configuration and data models."*

Show in browser:
- http://localhost:8080/api/students → JSON with students
- http://localhost:8080/api/students/S001 → Specific student

**Highlight:** The `/api` context path in configuration!

---

#### 3. The Main Event - Lab 02 Full CRUD (3 minutes) ⭐
```powershell
.\demo-lab02.ps1
```

**While it's starting, say:** *"Now the complete REST API with full CRUD operations!"*

##### Live Demo Commands (type these in browser/curl):

```bash
# READ (Show initial data)
curl http://localhost:8080/users
# Shows: [{"email":"ximena@email.com","name":"Ximena"}, {"email":"norma@email.com","name":"Norma"}]

# CREATE
# Open browser dev tools (F12) → Network tab
curl -X POST http://localhost:8080/users -H "Content-Type: application/json" -d '{"email":"alice@email.com","name":"Alice"}'
# Shows: {"email":"alice@email.com","name":"Alice"}

# READ again (show Alice was added)
curl http://localhost:8080/users
# Now shows 3 users!

# UPDATE
curl -X PUT http://localhost:8080/users/ximena@email.com -H "Content-Type: application/json" -d '{"email":"ximena@email.com","name":"Ximena Updated"}'
# Shows: {"email":"ximena@email.com","name":"Ximena Updated"}

# DELETE
curl -X DELETE http://localhost:8080/users/norma@email.com
# Returns: (nothing - 204 No Content)

# READ final (show Norma is gone)
curl http://localhost:8080/users
# Now shows only 2 users!
```

---

#### 4. Show Error Handling (Bonus points!) 🎁

```bash
# Show 404 error
curl http://localhost:8080/users/notfound@email.com
# Returns: 404 Not Found with JSON error

# Show validation error
curl -X POST http://localhost:8080/users -H "Content-Type: application/json" -d '{"email":"","name":""}'
# Returns: 400 Bad Request with validation errors
```

**Say:** *"Look at the professional error handling! It returns proper HTTP status codes and JSON error messages!"*

---

#### 5. Run Automated Tests (The Grand Finale!) 🏆

Open **another PowerShell** while Lab 02 is running:

```powershell
.\test-api-lab02.ps1
```

**Watch the green checkmarks appear!**

**Say:** *"And I even created automated tests that verify all 9 operations work perfectly!"*

---

### 🎨 Visual Tips for Presentation

#### 1. Use Split Screen
- **Left:** IntelliJ IDEA showing code
- **Right:** Browser/PowerShell showing running app

#### 2. Show Code First
Before running, quickly show:
- `User.kt` - *"Data class with validation"*
- `UsersController.kt` - *"All CRUD operations"*
- `GlobalExceptionHandler.kt` - *"Professional error handling"*

#### 3. Use Browser DevTools
- Press **F12** → Network tab
- Show the HTTP requests being made
- Show response status codes (200, 201, 204, 400, 404)

#### 4. Have These Ready
Open in browser tabs before presentation:
- http://localhost:8080/users
- http://localhost:8080/users/ximena@email.com

---

## 🚨 Troubleshooting During Presentation

### "gradlew.bat is not recognized"
**Solution:** Use `.\gradlew.bat` (with the dot and backslash)

### "JAVA_HOME not set"
**Solution:** The .ps1 scripts handle this automatically. If using manual commands:
```powershell
$env:JAVA_HOME = "C:\Program Files\JetBrains\IntelliJ IDEA 2025.2.5\jbr"
```

### "Port 8080 already in use"
**Solution:** Kill existing Java processes:
```powershell
Get-Process java | Stop-Process -Force
```
Or change port in `application.properties`:
```properties
server.port=8081
```

### PowerShell script won't run
**Solution:** Run this first to allow scripts:
```powershell
Set-ExecutionPolicy -ExecutionPolicy Bypass -Scope Process
```

---

## 📱 Quick Reference Card

### For Practice 01
```powershell
.\demo-practice01.ps1
# Test: http://localhost:8080/
```

### For Lab 01
```powershell
.\demo-lab01.ps1
# Test: http://localhost:8080/api/students
```

### For Lab 02 (Main Demo)
```powershell
# Terminal 1:
.\demo-lab02.ps1

# Terminal 2 (while Lab 02 runs):
.\test-api-lab02.ps1
```

---

**You're ready to impress! Good luck! 🚀🎓**
