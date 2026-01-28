@echo off
chcp 65001 >nul
title Lab 01 - Student Info App
cls

echo.
echo ╔══════════════════════════════════════════════════════════════╗
echo ║                                                              ║
echo ║   Lab 01: Student Info App                                   ║
echo ║   Web Component Development (Java EE) - Week 1              ║
echo ║                                                              ║
echo ╚══════════════════════════════════════════════════════════════╝
echo.

REM Set Java environment from IntelliJ
set "JAVA_HOME=C:\Program Files\JetBrains\IntelliJ IDEA 2025.2.5\jbr"
set "PATH=%JAVA_HOME%\bin;%PATH%"

cd /d "%~dp0lab01-student-info"

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
echo ║  Base URL: http://localhost:8080/api                         ║
echo ║                                                              ║
echo ║  Endpoints:                                                  ║
echo ║    GET  /api/students                                        ║
echo ║    GET  /api/students/S001                                   ║
echo ║    POST /api/students                                        ║
echo ║    GET  /api/students/health                                 ║
echo ╚══════════════════════════════════════════════════════════════╝
echo.
echo Initial Data: S001 - Alice Johnson, S002 - Bob Smith
echo.
echo Press Ctrl+C to stop the server
echo.

gradlew.bat bootRun --quiet

pause
