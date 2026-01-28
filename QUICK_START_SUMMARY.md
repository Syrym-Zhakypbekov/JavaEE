# 🚀 Quick Start Summary - Choose Your Way!

## ⚡ Easiest Way (Recommended for Expo)

### Just Double-Click!
```
📁 JavaEE/
└── 📄 START_HERE.bat    ← DOUBLE CLICK THIS!
```

This opens an **interactive menu**:
```
╔════════════════════════════════════════════════╗
║     JavaEE Web Component Development           ║
╚════════════════════════════════════════════════╝

[1] Practice 01 - Hello Spring Boot
[2] Lab 01 - Student Info App
[3] Lab 02 - Users App (MOST IMPRESSIVE!)
[4] Test Lab 02 API
[5] Open GitHub Repository
[0] Exit
```

---

## 🎯 For Presentation (Show Off Mode)

### Option A: Command Prompt (Simple, Reliable)
```batch
:: Just type these in Command Prompt:

run-lab02.bat         :: Start the main app
test-lab02.bat        :: Run automated tests (in another window)
```

### Option B: PowerShell (Fancy Colors)
```powershell
# In PowerShell:
.\demo-lab02.ps1      # Start with cool banner
.\test-api-lab02.ps1  # Run automated tests
```

### Option C: IntelliJ IDEA (Show Code + Running App)
1. Open IntelliJ
2. Open `lab02-users-app`
3. Run `UsersAppApplication.kt`
4. Split screen: Code on left, Browser on right

---

## 📊 What Each Script Does

### `.bat` Files (Command Prompt)
| File | What It Does |
|------|--------------|
| `START_HERE.bat` | Interactive menu - pick any project |
| `run-practice01.bat` | Build & run Practice 01 |
| `run-lab01.bat` | Build & run Lab 01 |
| `run-lab02.bat` | Build & run Lab 02 |
| `test-lab02.bat` | Run 9 automated API tests |

### `.ps1` Files (PowerShell)
| File | What It Does |
|------|--------------|
| `demo-practice01.ps1` | Run with colored output |
| `demo-lab01.ps1` | Run with colored output |
| `demo-lab02.ps1` | Run with colored output |
| `test-api-lab02.ps1` | Detailed API testing with colors |

---

## 🎬 Perfect Expo Flow

### Step 1: Start Main App
```batch
run-lab02.bat
```
You'll see:
```
Lab 02: Users App - Complete CRUD API

Base URL: http://localhost:8080

CRUD Endpoints:
  GET    /users
  GET    /users/{email}
  POST   /users
  PUT    /users/{email}
  DELETE /users/{email}
  GET    /users/health

Press Ctrl+C to stop
```

### Step 2: Open Browser
- http://localhost:8080/users
- Show the JSON data

### Step 3: Show CRUD Operations
Type these commands:
```bash
# READ
curl http://localhost:8080/users

# CREATE
curl -X POST http://localhost:8080/users -H "Content-Type: application/json" -d "{\"email\":\"alice@email.com\",\"name\":\"Alice\"}"

# UPDATE
curl -X PUT http://localhost:8080/users/ximena@email.com -H "Content-Type: application/json" -d "{\"email\":\"ximena@email.com\",\"name\":\"Ximena Updated\"}"

# DELETE
curl -X DELETE http://localhost:8080/users/norma@email.com
```

### Step 4: Run Automated Tests (Grand Finale!)
Open **another** Command Prompt:
```batch
test-lab02.bat
```

You'll see:
```
[Test 1] GET /users
  [PASS] Returns users list

[Test 2] GET /users/ximena@email.com
  [PASS] Returns single user

...

TEST SUMMARY
  PASS: 9
  FAIL: 0
  Total: 9
  
  ALL TESTS PASSED!
```

---

## 🆘 If Something Goes Wrong

### "gradlew not found"
→ Use `.\gradlew.bat` or just use `START_HERE.bat`

### "Port 8080 in use"
→ Close other Java apps or change port in `application.properties`

### PowerShell won't run scripts
→ Run: `Set-ExecutionPolicy -ExecutionPolicy Bypass -Scope Process`

### Java not found
→ Scripts auto-detect Java from IntelliJ installation

---

## 📁 Files You Need to Know

```
JavaEE/
│
├── 🚀 START_HERE.bat          ← DOUBLE CLICK TO START!
├── 📖 HOW_TO_USE_SCRIPTS.md   ← Full documentation
├── 🎬 PRESENTATION_GUIDE.md   ← Expo tips
│
├── .bat files (Command Prompt)
│   ├── run-practice01.bat
│   ├── run-lab01.bat
│   ├── run-lab02.bat
│   └── test-lab02.bat
│
├── .ps1 files (PowerShell)
│   ├── demo-practice01.ps1
│   ├── demo-lab01.ps1
│   ├── demo-lab02.ps1
│   └── test-api-lab02.ps1
│
└── 📁 Projects
    ├── practice01-hello-springboot/
    ├── lab01-student-info/
    └── lab02-users-app/
```

---

## 🎯 One-Liner Commands

### For Quick Demo
```batch
START_HERE.bat
```

### For Impressive Presentation
```batch
:: Terminal 1
run-lab02.bat

:: Terminal 2 (while Lab 02 runs)
test-lab02.bat
```

### For Development
```batch
:: Open IntelliJ IDEA
code .  :: or open folder manually
```

---

**That's it! Your project is 110% ready to impress! 🚀🎓**
