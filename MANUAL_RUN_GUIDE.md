# 🚀 Manual Run Guide - Terminal/Command Prompt

## ⚠️ Forget about `src/Main.kt`!

That `Main.kt` in `src/` folder is just a **placeholder** from IntelliJ.  
**The real projects are in separate folders!**

---

## 📁 Project Structure (What You Actually Run)

```
JavaEE/                          ← Root folder
│
├── src/Main.kt                  ← ❌ IGNORE THIS (placeholder)
│
├── practice01-hello-springboot/ ← ✅ THIS IS PROJECT 1
│   └── src/main/kotlin/com/iitu/student/hellospringboot/
│       └── HelloSpringBootApplication.kt  ← 🎯 ENTRY POINT
│
├── lab01-student-info/          ← ✅ THIS IS PROJECT 2
│   └── src/main/kotlin/com/iitu/webdev/studentinfoapp/
│       └── StudentInfoAppApplication.kt   ← 🎯 ENTRY POINT
│
└── lab02-users-app/             ← ✅ THIS IS PROJECT 3 (Main one!)
    └── src/main/kotlin/com/iitu/users/
        └── UsersAppApplication.kt           ← 🎯 ENTRY POINT
```

---

## 🎯 The 3 Entry Points (Main Files)

| Project | Entry File | What It Does |
|---------|-----------|--------------|
| **Practice 01** | `HelloSpringBootApplication.kt` | Simple Hello World API |
| **Lab 01** | `StudentInfoAppApplication.kt` | Student CRUD with config |
| **Lab 02** | `UsersAppApplication.kt` | Full CRUD + Validation |

---

## 🔧 How to Run MANUALLY (Step by Step)

### Step 1: Open Terminal/Command Prompt

**Option A - Command Prompt (CMD):**
1. Press `Win + R`
2. Type `cmd`
3. Press Enter

**Option B - PowerShell:**
1. Press `Win + X`
2. Select "Windows PowerShell" or "Terminal"

---

### Step 2: Navigate to Project Folder

```batch
:: Change to the JavaEE folder
cd C:\Users\syrym\IdeaProjects\JavaEE

:: List what folders exist (you should see practice01..., lab01..., lab02...)
dir
```

You should see:
```
lab01-student-info/
lab02-users-app/
practice01-hello-springboot/
```

---

### Step 3: Choose Which Project to Run

#### 🟢 Option A: Practice 01 (Simplest - Hello World)

```batch
:: Navigate to Practice 01 folder
cd practice01-hello-springboot

:: Run with Gradle (Method 1 - Recommended)
.\gradlew.bat bootRun

:: Or if you have Gradle installed globally (Method 2)
gradle bootRun
```

**Success signs:**
```
Started HelloSpringBootApplicationKt in 2.5 seconds
Tomcat started on port(s): 8080 (http)

╔══════════════════════════════════════╗
║   🚀 Practice 01: Hello Spring Boot  ║
╚══════════════════════════════════════╝
```

**Test in browser:**
- http://localhost:8080/
- http://localhost:8080/greeting

**To stop:** Press `Ctrl + C` in the terminal

---

#### 🟡 Option B: Lab 01 (Student Info - Intermediate)

```batch
:: Navigate to Lab 01 folder
cd C:\Users\syrym\IdeaProjects\JavaEE\lab01-student-info

:: Or from anywhere
cd \Users\syrym\IdeaProjects\JavaEE\lab01-student-info

:: Run with Gradle
.\gradlew.bat bootRun
```

**Success signs:**
```
Started StudentInfoAppApplicationKt in 3.0 seconds
Tomcat started on port(s): 8080 (http)

╔══════════════════════════════════════╗
║   🚀 Lab 01: Student Info App        ║
╚══════════════════════════════════════╝
```

**Test in browser:**
- http://localhost:8080/api/students
- http://localhost:8080/api/students/S001
- http://localhost:8080/api/students/health

**To stop:** Press `Ctrl + C` in the terminal

---

#### 🔴 Option C: Lab 02 (Users App - Full CRUD - MOST IMPORTANT!)

```batch
:: Navigate to Lab 02 folder
cd C:\Users\syrym\IdeaProjects\JavaEE\lab02-users-app

:: Run with Gradle
.\gradlew.bat bootRun
```

**Success signs:**
```
Started UsersAppApplicationKt in 2.8 seconds
Tomcat started on port(s): 8080 (http)

╔══════════════════════════════════════╗
║   🚀 Lab 02: Users App Started!      ║
║   Complete CRUD API Implementation   ║
╚══════════════════════════════════════╝
```

**Test in browser:**
- http://localhost:8080/users
- http://localhost:8080/users/ximena@email.com
- http://localhost:8080/users/health

**Test with curl:**
```batch
:: Get all users
curl http://localhost:8080/users

:: Create new user
curl -X POST http://localhost:8080/users -H "Content-Type: application/json" -d "{\"email\":\"alice@email.com\",\"name\":\"Alice\"}"

:: Update user
curl -X PUT http://localhost:8080/users/ximena@email.com -H "Content-Type: application/json" -d "{\"email\":\"ximena@email.com\",\"name\":\"Ximena Updated\"}"

:: Delete user
curl -X DELETE http://localhost:8080/users/norma@email.com
```

**To stop:** Press `Ctrl + C` in the terminal

---

## 🛑 Troubleshooting

### Error: "JAVA_HOME not set"

**Solution:** Tell it where Java is

```batch
:: Set Java path (from IntelliJ installation)
set JAVA_HOME=C:\Program Files\JetBrains\IntelliJ IDEA 2025.2.5\jbr
set PATH=%JAVA_HOME%\bin;%PATH%

:: Now try again
.\gradlew.bat bootRun
```

---

### Error: "Port 8080 already in use"

**Solution A - Kill other Java:**
```batch
:: Find Java processes
tasklist | findstr java

:: Kill them
taskkill /F /IM java.exe

:: Or kill by port
netstat -ano | findstr :8080
taskkill /PID <number> /F
```

**Solution B - Change port:**
Edit `lab02-users-app/src/main/resources/application.properties`:
```properties
server.port=8081
```

---

### Error: "gradlew.bat is not recognized"

**Solution:** Make sure you're in the right folder
```batch
:: Check where you are
cd

:: Should show: C:\Users\syrym\IdeaProjects\JavaEE\lab02-users-app

:: If not, navigate there
cd C:\Users\syrym\IdeaProjects\JavaEE\lab02-users-app

:: Now try
.\gradlew.bat bootRun
```

---

### Error: Window closes immediately

**Solution:** Run from already-open terminal, not by double-clicking

1. Open Command Prompt first
2. Navigate to folder
3. Run the command

---

## 📋 Quick Reference

### One-Liner Commands (Copy-Paste Ready)

```batch
:: PRACTICE 01
cd C:\Users\syrym\IdeaProjects\JavaEE\practice01-hello-springboot && .\gradlew.bat bootRun

:: LAB 01
cd C:\Users\syrym\IdeaProjects\JavaEE\lab01-student-info && .\gradlew.bat bootRun

:: LAB 02
cd C:\Users\syrym\IdeaProjects\JavaEE\lab02-users-app && .\gradlew.bat bootRun
```

---

### With Java Setup Included

```batch
:: PRACTICE 01 - Complete setup
set JAVA_HOME=C:\Program Files\JetBrains\IntelliJ IDEA 2025.2.5\jbr
set PATH=%JAVA_HOME%\bin;%PATH%
cd C:\Users\syrym\IdeaProjects\JavaEE\practice01-hello-springboot
.\gradlew.bat bootRun

:: LAB 01 - Complete setup
set JAVA_HOME=C:\Program Files\JetBrains\IntelliJ IDEA 2025.2.5\jbr
set PATH=%JAVA_HOME%\bin;%PATH%
cd C:\Users\syrym\IdeaProjects\JavaEE\lab01-student-info
.\gradlew.bat bootRun

:: LAB 02 - Complete setup
set JAVA_HOME=C:\Program Files\JetBrains\IntelliJ IDEA 2025.2.5\jbr
set PATH=%JAVA_HOME%\bin;%PATH%
cd C:\Users\syrym\IdeaProjects\JavaEE\lab02-users-app
.\gradlew.bat bootRun
```

---

## 🎓 Understanding the Flow

### What happens when you run `.\gradlew.bat bootRun`:

1. **Gradle Wrapper** (`gradlew.bat`) starts
2. It reads `build.gradle.kts` (build configuration)
3. Downloads dependencies (Spring Boot, Kotlin, etc.)
4. **Compiles** Kotlin code to Java bytecode
5. **Starts** Spring Boot application
6. **Embedded Tomcat** starts on port 8080
7. Your **REST API** is now ready!

```
You type:          Gradle does:
.\gradlew.bat      → Download deps
   bootRun         → Compile code
                   → Start Tomcat
                   → Run your app
                   → Show banner
```

---

## 🎯 For Your Presentation

### Recommended Flow:

**Terminal 1:**
```batch
cd lab02-users-app
.\gradlew.bat bootRun
```

**Terminal 2** (while Terminal 1 is running):
```batch
:: Test the API
curl http://localhost:8080/users
curl -X POST http://localhost:8080/users -H "Content-Type: application/json" -d "{\"email\":\"test@test.com\",\"name\":\"Test\"}"
```

**Browser:**
- http://localhost:8080/users

---

## ❓ FAQ

### Q: What is `bootRun`?
**A:** It's a Gradle task that compiles and runs Spring Boot application

### Q: Can I run multiple projects at once?
**A:** Only if they use different ports! Change `server.port` in application.properties

### Q: Do I need IntelliJ to run?
**A:** NO! You can run from terminal without IntelliJ open

### Q: What if I don't have Gradle installed?
**A:** `gradlew.bat` downloads Gradle automatically! No need to install.

### Q: Why Kotlin files but I run with Gradle?
**A:** Gradle compiles Kotlin to Java bytecode, then runs it

---

## 📁 Summary: Which Folder = Which Project

| Folder | Project Name | Port | URL |
|--------|-------------|------|-----|
| `practice01-hello-springboot/` | Hello Spring Boot | 8080 | http://localhost:8080/ |
| `lab01-student-info/` | Student Info App | 8080 | http://localhost:8080/api/students |
| `lab02-users-app/` | Users App (Main!) | 8080 | http://localhost:8080/users |

**Remember:** Run ONE at a time (they all use port 8080 by default)!

---

**Now you know exactly how to run each project manually! 🚀**
