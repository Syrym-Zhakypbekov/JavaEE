# 🎓 BAT FILE MASTER CLASS
## Complete Guide to Windows Batch Files (.bat)

---

# PART 1: WHAT IS A .BAT FILE? 🤔

## Definition
A **.bat file** (batch file) is a text file containing multiple Windows commands that can be executed together.

Think of it as:
- A **script** that automates tasks
- A **shortcut** that runs multiple commands
- A **program** written in Windows command language

## Why Use .bat Files?
```
❌ Without .bat: Type 10 commands manually every time
✅ With .bat: Double-click one file, all 10 commands run automatically
```

## Example
Instead of typing:
```batch
cd C:\Users\YourName\JavaEE\lab02-users-app
set JAVA_HOME=C:\Program Files\Java\jdk-21
set PATH=%JAVA_HOME%\bin;%PATH%
.\gradlew.bat bootRun
```

Just double-click `run-lab02.bat` and it does everything!

---

# PART 2: HOW TO RUN .BAT FILES 🚀

## Method 1: Double-Click (Easiest)

### Step-by-Step:
1. Open **File Explorer**
2. Navigate to folder with .bat file
3. **Double-click** the .bat file
   ```
   📁 JavaEE/
   └── 📄 START_HERE.bat  ← DOUBLE CLICK!
   ```

4. A **black window** (Command Prompt) will open
5. The commands execute automatically

### ⚠️ Important:
- Don't close the black window while it's running
- The window closes automatically when done (unless there's `pause`)
- If you see "Press any key to continue..." - press a key!

---

## Method 2: Right-Click → Run (Alternative)

1. Right-click on the .bat file
2. Select **"Open"** or **"Run as administrator"**

```
When to use "Run as administrator":
- When the script needs to install software
- When it modifies system settings
- When it says "Access denied"
```

---

## Method 3: Command Prompt (Advanced)

### Step 1: Open Command Prompt
Press `Win + R`, type `cmd`, press Enter

Or:
- Right-click Start button → "Command Prompt"
- Search "cmd" in Start menu

### Step 2: Navigate to Folder
```batch
:: Type this in Command Prompt
cd C:\Users\YourName\IdeaProjects\JavaEE
```

### Step 3: Run the .bat File
```batch
:: Type the filename
START_HERE.bat

:: Or with full path
C:\Users\YourName\IdeaProjects\JavaEE\START_HERE.bat
```

### Why Use Command Prompt?
- See error messages if something goes wrong
- Keep window open after execution
- Run multiple scripts in sequence

---

## Method 4: PowerShell (Modern Windows)

### Step 1: Open PowerShell
- Right-click Start button → "Windows PowerShell"
- Or: Press `Win + X`, then `I`

### Step 2: Navigate and Run
```powershell
# Navigate to folder
cd C:\Users\YourName\IdeaProjects\JavaEE

# Run the batch file
.\START_HERE.bat

# Or with full path
& "C:\Users\YourName\IdeaProjects\JavaEE\START_HERE.bat"
```

### PowerShell Bonus Features:
```powershell
# See output in colors
.\test-lab02.bat | Out-Host

# Run and save output to file
.\run-lab02.bat > output.txt

# Run in background
Start-Process .\run-lab02.bat -WindowStyle Hidden
```

---

# PART 3: UNDERSTANDING .BAT FILE COMMANDS 📚

## Essential Commands Explained

### 1. `@echo off` - Hide Commands
```batch
@echo off
:: This hides the commands from showing
:: Only the OUTPUT is displayed
```

**Without @echo off:**
```
C:\>echo Hello
Hello
C:\>echo World
World
```

**With @echo off:**
```
Hello
World
```

---

### 2. `echo` - Print Text
```batch
echo Hello World          :: Prints: Hello World
echo.                      :: Prints empty line
echo [OK] Build complete   :: Prints: [OK] Build complete
```

**Special Characters:**
```batch
echo.                      :: Empty line
echo [1/3] Loading...      :: Progress indicator
echo =================    :: Separator line
```

---

### 3. `set` - Create Variables
```batch
:: Set a variable
set NAME=Syrym

:: Use a variable (wrap in % %)
echo Hello %NAME%         :: Prints: Hello Syrym

:: Set Java path
set "JAVA_HOME=C:\Program Files\Java\jdk-21"
set "PATH=%JAVA_HOME%\bin;%PATH%"
```

---

### 4. `cd` - Change Directory
```batch
:: Change to specific folder
cd C:\Users\Syrym\JavaEE

:: Go up one folder
cd ..

:: Go to root of current drive
cd \

:: Change drive (important!)
D:                        :: Switch to D: drive
cd D:\Projects            :: Now navigate

:: Best practice - use /d for drive changes
cd /d D:\Projects         :: Changes drive AND folder
```

---

### 5. `%~dp0` - Magic Current Folder
```batch
:: %~dp0 means "folder where this .bat file is located"
:: Super useful for portable scripts!

cd /d "%~dp0"            :: Go to script's folder
cd /d "%~dp0lab02-users-app"  :: Go to subfolder
```

**Example:**
```batch
@echo off
cd /d "%~dp0"            :: Always starts in script's folder
echo Running from: %CD%  :: Shows current folder
```

---

### 6. `if` - Conditional Logic
```batch
:: Check if file exists
if exist "file.txt" (
    echo File found!
) else (
    echo File not found!
)

:: Check error level (return code)
gradlew.bat build
if errorlevel 1 (
    echo [ERROR] Build failed!
    pause
    exit /b 1
) else (
    echo [OK] Build successful!
)

:: Compare strings
if "%choice%"=="1" goto OPTION1
if "%choice%"=="2" goto OPTION2
```

---

### 7. `goto` - Jump to Labels
```batch
@echo off
:MENU
echo [1] Start Server
echo [2] Run Tests
echo [3] Exit
set /p choice="Enter choice: "

if "%choice%"=="1" goto START
if "%choice%"=="2" goto TEST
if "%choice%"=="3" goto EXIT

echo Invalid choice!
goto MENU

:START
echo Starting server...
goto MENU

:TEST
echo Running tests...
goto MENU

:EXIT
echo Goodbye!
exit /b 0
```

---

### 8. `pause` - Wait for Key Press
```batch
echo Press any key to continue...
pause >nul          :: Silent pause (no message)

:: Or just:
pause               :: Shows "Press any key to continue . . ."
```

---

### 9. `timeout` - Wait Specific Time
```batch
:: Wait 5 seconds
timeout /t 5

:: Wait 2 seconds without showing countdown
timeout /t 2 /nobreak >nul
```

---

### 10. `start` - Open New Window
```batch
:: Open website
start https://github.com

:: Open program
start notepad.exe

:: Open new Command Prompt window
start cmd /k "run-lab02.bat"

:: Open with specific title
start "My Server" cmd /k "run-lab02.bat"
```

---

### 11. `call` - Run Another .bat
```batch
:: Runs another .bat and comes back
call other-script.bat

:: After other-script.bat finishes, continues here
echo Back to main script!
```

**Difference `call` vs direct execution:**
```batch
:: Without call - script ends after other-script.bat
other-script.bat
echo This never prints!  ❌

:: With call - returns to continue
call other-script.bat
echo This prints!  ✅
```

---

### 12. `exit /b` - Exit with Code
```batch
:: Exit successfully (code 0)
exit /b 0

:: Exit with error (code 1)
exit /b 1

:: Exit specific code
exit /b 42
```

**Common Exit Codes:**
- `0` = Success ✅
- `1` = General error ❌
- `2` = Misuse of command
- `9009` = Program not found

---

# PART 4: PRACTICAL EXAMPLES 🛠️

## Example 1: Simple Launcher
```batch
@echo off
echo =========================
echo   My Application
echo =========================
echo.
echo [1] Start App
echo [2] Run Tests
echo [3] Exit
echo.
set /p choice="Choose: "

if "%choice%"=="1" start app.exe
if "%choice%"=="2" call run-tests.bat
if "%choice%"=="3" exit

pause
```

---

## Example 2: Java Project Runner
```batch
@echo off
echo [1/3] Setting up Java...
set "JAVA_HOME=C:\Program Files\Java\jdk-21"
set "PATH=%JAVA_HOME%\bin;%PATH%"

echo [2/3] Building project...
cd /d "%~dp0my-project"
call gradlew.bat build

if errorlevel 1 (
    echo [ERROR] Build failed!
    pause
    exit /b 1
)

echo [3/3] Starting application...
call gradlew.bat bootRun

pause
```

---

## Example 3: Backup Script
```batch
@echo off
echo Starting backup...

:: Create backup folder with date
set BACKUP_DIR=C:\Backups\%date:~-4,4%-%date:~-10,2%-%date:~-7,2%
mkdir "%BACKUP_DIR%"

:: Copy files
xcopy "C:\ImportantFiles\*" "%BACKUP_DIR%" /s /e /y

echo Backup complete: %BACKUP_DIR%
pause
```

---

# PART 5: ADVANCED TECHNIQUES 🔥

## 1. Colored Output in Command Prompt
```batch
@echo off
:: ANSI color codes (Windows 10+)
:: 32m = Green, 31m = Red, 33m = Yellow

echo [92m[OK] Success![0m    :: Green
echo [91m[ERROR] Failed![0m  :: Red
echo [93m[WARNING] Careful![0m :: Yellow
```

**Enable ANSI colors first:**
```batch
reg add HKCU\Console /v VirtualTerminalLevel /t REG_DWORD /d 1 /f
```

---

## 2. Progress Indicators
```batch
@echo off
echo [1/5] Initializing...
timeout /t 1 /nobreak >nul

echo [2/5] Loading config...
timeout /t 1 /nobreak >nul

echo [3/5] Connecting...
timeout /t 1 /nobreak >nul

echo [4/5] Verifying...
timeout /t 1 /nobreak >nul

echo [5/5] Done!
```

---

## 3. Logging to File
```batch
@echo off
echo %date% %time% - Script started >> log.txt

echo Doing work...
echo %date% %time% - Work done >> log.txt

echo Script complete!
echo %date% %time% - Script completed >> log.txt
```

**Or capture ALL output:**
```batch
@echo off
my-script.bat > output.log 2>&1
:: > redirects output
:: 2>&1 redirects errors too
```

---

## 4. Check Admin Rights
```batch
@echo off
net session >nul 2>&1
if errorlevel 1 (
    echo [ERROR] Please run as Administrator!
    pause
    exit /b 1
)
echo [OK] Running as Administrator
```

---

## 5. User Input with Validation
```batch
@echo off
:ASK
set /p name="Enter your name: "

if "%name%"=="" (
    echo Name cannot be empty!
    goto ASK
)

echo Hello, %name%!
```

---

# PART 6: TROUBLESHOOTING 🐛

## Problem: "Command not found"
**Solution:** Check PATH variable
```batch
set PATH=%PATH%;C:\Program Files\MyApp\bin
```

---

## Problem: Window closes too fast
**Solution:** Add `pause` at the end
```batch
@echo off
my-command
pause  :: Window stays open until key press
```

---

## Problem: "Access denied"
**Solution:** Run as Administrator
- Right-click .bat file
- Select "Run as administrator"

---

## Problem: Special characters break script
**Solution:** Use quotes
```batch
:: Bad
cd C:\Program Files\My App

:: Good
cd "C:\Program Files\My App"
```

---

## Problem: Script won't run (Windows blocks it)
**Solution:** Unblock in properties
1. Right-click .bat file
2. Properties
3. Check "Unblock" at bottom
4. Click OK

---

# PART 7: BEST PRACTICES ⭐

## ✅ DO:
```batch
:: 1. Always use @echo off at start
@echo off

:: 2. Use quotes around paths
set "FOLDER=C:\Program Files\App"

:: 3. Check for errors
if errorlevel 1 (
    echo Error occurred
    exit /b 1
)

:: 4. Use descriptive messages
echo [OK] Build completed successfully

:: 5. Use pause to see results
pause
```

## ❌ DON'T:
```batch
:: Don't use spaces in variable assignment (WRONG!)
set NAME = John    ❌ This creates "NAME " variable

:: Do this instead (CORRECT!)
set NAME=John      ✅

:: Don't forget quotes for paths with spaces
cd C:\Program Files\Java    ❌ Fails!

:: Do this:
cd "C:\Program Files\Java"   ✅
```

---

# PART 8: QUICK REFERENCE CARD 📋

| Command | Purpose | Example |
|---------|---------|---------|
| `@echo off` | Hide commands | `@echo off` |
| `echo` | Print text | `echo Hello` |
| `set` | Create variable | `set NAME=John` |
| `%VAR%` | Use variable | `echo %NAME%` |
| `cd` | Change folder | `cd "C:\Folder"` |
| `%~dp0` | Script's folder | `cd /d "%~dp0"` |
| `if` | Condition | `if exist file.txt (...)` |
| `goto` | Jump to label | `goto MENU` |
| `pause` | Wait for key | `pause` |
| `timeout` | Wait seconds | `timeout /t 5` |
| `start` | New window | `start cmd` |
| `call` | Run .bat | `call other.bat` |
| `exit /b` | Exit with code | `exit /b 0` |

---

# PART 9: YOUR SCRIPTS EXPLAINED 🔍

## START_HERE.bat Explained Line by Line

```batch
@echo off              ← Hide commands from showing
chcp 65001 >nul        ← Use UTF-8 for special characters
title JavaEE Labs      ← Set window title
cls                    ← Clear screen

:MENU                  ← Label called "MENU"
echo.                  ← Print empty line
echo ╔════════════╗     ← Draw box
echo ║  Options   ║     ← Menu title
echo ╚════════════╝     ← Close box

set /p choice="Enter: "  ← Ask for input

if "%choice%"=="1" goto PRACTICE01  ← Check choice

:PRACTICE01            ← Label for option 1
start "Practice 01" cmd /k "run-practice01.bat"  ← Run in new window
goto MENU              ← Go back to menu
```

---

## run-lab02.bat Explained

```batch
@echo off
chcp 65001 >nul        ← Support Unicode (for box drawing)
title Lab 02           ← Window title
cls                    ← Clear screen

:: Draw cool banner
echo ╔════════════╗
echo ║  Lab 02    ║
echo ╚════════════╝

:: Set Java from IntelliJ
set "JAVA_HOME=C:\...\jbr"
set "PATH=%JAVA_HOME%\bin;%PATH%"

:: Go to project folder
cd /d "%~dp0lab02-users-app"

:: Check Java works
java -version 2>&1 | findstr "version" >nul
if errorlevel 1 (      ← If Java not found
    echo [ERROR] Java not found!
    pause
    exit /b 1         ← Exit with error code
)

:: Build project
echo [2/3] Building...
gradlew.bat build --quiet -x test 2>nul
if errorlevel 1 (      ← If build failed
    echo [ERROR] Build failed!
    pause
    exit /b 1
)

:: Start app
echo [3/3] Starting...
echo ╔════════════╗
echo ║ URLs here  ║
echo ╚════════════╝
gradlew.bat bootRun --quiet  ← Run the Spring Boot app

pause                  ← Wait before closing
```

---

# 🎓 CONCLUSION

## You Now Know:
1. ✅ How to run .bat files (4 methods)
2. ✅ What each command does
3. ✅ How to create your own scripts
4. ✅ How to troubleshoot problems
5. ✅ Best practices for clean scripts

## For Your JavaEE Project:
- **Easiest:** Double-click `START_HERE.bat`
- **Presentation:** Run `run-lab02.bat` + `test-lab02.bat`
- **Development:** Run from IntelliJ IDEA

---

**You're now a BAT FILE MASTER! 🚀**
