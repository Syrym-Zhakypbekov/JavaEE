@echo off
:: Simple menu system

:MENU
cls
echo ============================
echo      MY APPLICATION
echo ============================
echo.
echo [1] Say Hello
echo [2] Show Date and Time
echo [3] List Files
echo [4] Exit
echo.
echo ============================

set /p CHOICE="Enter your choice (1-4): "

if "%CHOICE%"=="1" goto HELLO
if "%CHOICE%"=="2" goto DATETIME
if "%CHOICE%"=="3" goto LISTFILES
if "%CHOICE%"=="4" goto EXIT

echo Invalid choice! Try again.
timeout /t 2 /nobreak >nul
goto MENU

:HELLO
cls
echo ============================
echo Hello! Have a great day!
echo ============================
pause
goto MENU

:DATETIME
cls
echo ============================
echo Current Date: %date%
echo Current Time: %time%
echo ============================
pause
goto MENU

:LISTFILES
echo.
echo Files in current folder:
dir /b
echo.
pause
goto MENU

:EXIT
echo Goodbye!
timeout /t 1 /nobreak >nul
exit /b 0
