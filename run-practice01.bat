@echo off
chcp 65001 >nul
title Practice 01 - Hello Spring Boot
cls

echo.
echo ╔══════════════════════════════════════════════════════════════╗
echo ║                                                              ║
echo ║   Practice 01: Hello Spring Boot                             ║
echo ║   Web Component Development (Java EE) - Week 1              ║
echo ║                                                              ║
echo ╚══════════════════════════════════════════════════════════════╝
echo.

REM Set Java environment from IntelliJ
set "JAVA_HOME=C:\Program Files\JetBrains\IntelliJ IDEA 2025.2.5\jbr"
set "PATH=%JAVA_HOME%\bin;%PATH%"

cd /d "%~dp0practice01-hello-springboot"

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
echo ║  URLs:                                                       ║
echo ║    http://localhost:8080/                                    ║
echo ║    http://localhost:8080/greeting                            ║
echo ╚══════════════════════════════════════════════════════════════╝
echo.
echo Press Ctrl+C to stop the server
echo.

gradlew.bat bootRun --quiet

pause
