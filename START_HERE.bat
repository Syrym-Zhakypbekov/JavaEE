@echo off
chcp 65001 >nul
title JavaEE Week 1 Labs - Launcher
cls

:MENU
echo.
echo ╔══════════════════════════════════════════════════════════════╗
echo ║                                                              ║
echo ║     🎓 JavaEE Web Component Development - Week 1             ║
echo ║                    Project Launcher                          ║
echo ║                                                              ║
echo ╚══════════════════════════════════════════════════════════════╝
echo.
echo   Choose a project to run:
echo.
echo   [1] Practice 01 - Hello Spring Boot (Simplest)echo        Simple REST API with 2 endpointsecho.
echo   [2] Lab 01 - Student Info App (Intermediate)echo        CRUD with configuration and models
echo.
echo   [3] Lab 02 - Users App (Full CRUD - MOST IMPRESSIVE!)echo        Complete CRUD + Validation + Error Handling
echo.
echo   [4] Test Lab 02 API (Run while Lab 02 is running)echo        Automated API testing with 9 tests
echo.
echo   [5] Open GitHub Repositoryecho        View source code online
echo.
echo   [0] Exit
echo.
echo ═══════════════════════════════════════════════════════════════
set /p choice="Enter your choice (0-5): "

if "%choice%"=="1" goto PRACTICE01
if "%choice%"=="2" goto LAB01
if "%choice%"=="3" goto LAB02
if "%choice%"=="4" goto TESTLAB02
if "%choice%"=="5" goto GITHUB
if "%choice%"=="0" goto EXIT

echo.
echo [ERROR] Invalid choice! Please try again.
timeout /t 2 /nobreak >nul
goto MENU

:PRACTICE01
echo.
echo Starting Practice 01 - Hello Spring Boot...
start "Practice 01" cmd /k "run-practice01.bat"
timeout /t 3 /nobreak >nul
echo.
echo [OK] Practice 01 started in new window!
echo    Open browser: http://localhost:8080/
pause
goto MENU

:LAB01
echo.
echo Starting Lab 01 - Student Info App...
start "Lab 01" cmd /k "run-lab01.bat"
timeout /t 3 /nobreak >nul
echo.
echo [OK] Lab 01 started in new window!
echo    Open browser: http://localhost:8080/api/students
pause
goto MENU

:LAB02
echo.
echo Starting Lab 02 - Users App (Full CRUD)...
start "Lab 02" cmd /k "run-lab02.bat"
timeout /t 3 /nobreak >nul
echo.
echo [OK] Lab 02 started in new window!
echo    Open browser: http://localhost:8080/users
echo.
echo    TIP: Open another terminal and run:
echo         test-lab02.bat
echo    to see automated API testing!
pause
goto MENU

:TESTLAB02
echo.
echo Testing Lab 02 API...
test-lab02.bat
goto MENU

:GITHUB
echo.
echo Opening GitHub Repository...
start https://github.com/Syrym-Zhakypbekov/JavaEE
goto MENU

:EXIT
echo.
echo Thanks for using JavaEE Labs! Goodbye!
timeout /t 2 /nobreak >nul
exit /b 0
