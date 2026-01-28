@echo off
chcp 65001 >nul
title Lab 02 - Users App (Full CRUD)
cls

echo.
echo ╔══════════════════════════════════════════════════════════════╗
echo ║                                                              ║
echo ║   Lab 02: Users App - Complete CRUD API                      ║
echo ║   Web Component Development (Java EE) - Week 1              ║
echo ║                                                              ║
echo ╚══════════════════════════════════════════════════════════════╝
echo.

REM Set Java environment from IntelliJ
set "JAVA_HOME=C:\Program Files\JetBrains\IntelliJ IDEA 2025.2.5\jbr"
set "PATH=%JAVA_HOME%\bin;%PATH%"

cd /d "%~dp0lab02-users-app"

echo [1/3] Checking Java...
java -version 2>&1 | findstr "version" >nul
if errorlevel 1 (
    echo [ERROR] Java not found!
    pause
    exit /b 1
)

echo [2/3] Building project...
gradlew.bat build --quiet -x test 2>nul
if errorlevel 1 (
    echo [ERROR] Build failed!
    pause
    exit /b 1
)

echo [3/3] Starting application...
echo.
echo ╔══════════════════════════════════════════════════════════════╗
echo ║  Base URL: http://localhost:8080                             ║
echo ║                                                              ║
echo ║  CRUD Endpoints:                                             ║
echo ║    GET    /users                  - Read all                 ║
echo ║    GET    /users/{email}          - Read one                 ║
echo ║    POST   /users                  - Create                   ║
echo ║    PUT    /users/{email}          - Update                   ║
echo ║    DELETE /users/{email}          - Delete                   ║
echo ║    GET    /users/health           - Health check             ║
echo ║                                                              ║
echo ║  Bonus: Validation, Error Handling, HTTP Status Codes        ║
echo ╚══════════════════════════════════════════════════════════════╝
echo.
echo Initial Users: ximena@email.com, norma@email.com
echo.
echo To test, open another terminal and run: test-lab02.bat
echo.
echo Press Ctrl+C to stop the server
echo.

gradlew.bat bootRun --quiet

pause
