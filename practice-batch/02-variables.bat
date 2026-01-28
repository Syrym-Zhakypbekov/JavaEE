@echo off
:: Learning variables

echo === Variables Demo ===
echo.

:: Set variables
set NAME=Student
set PROJECT=JavaEE
set YEAR=2026

echo Hello, %NAME%!
echo Welcome to %PROJECT%
echo Year: %YEAR%
echo.

:: Ask user for input
set /p YOUR_NAME="Enter your name: "
set /p YOUR_AGE="Enter your age: "

echo.
echo Nice to meet you, %YOUR_NAME%!
echo You are %YOUR_AGE% years old.
echo.

pause
