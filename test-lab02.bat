@echo off
chcp 65001 >nul
title Lab 02 - API Test
cls

echo.
echo ============================================
echo     Lab 02 - API Testing
echo ============================================
echo.

set BASE_URL=http://localhost:8080
set PASS=0
set FAIL=0

REM Check if server is running
echo [*] Checking if server is running...
curl -s %BASE_URL%/users/health >nul 2>&1
if errorlevel 1 (
    echo [ERROR] Server is not running!
    echo.
    echo Please start the server first by running: run-lab02.bat
    pause
    exit /b 1
)
echo [OK] Server is running
echo.

echo Running tests...
echo.

REM Test 1: Get all users
echo [Test 1] GET /users
curl -s %BASE_URL%/users | findstr "ximena" >nul
if errorlevel 1 (
    echo   [FAIL]
    set /a FAIL+=1
) else (
    echo   [PASS] Returns users list
    set /a PASS+=1
)
timeout /t 1 /nobreak >nul

REM Test 2: Get user by email
echo [Test 2] GET /users/ximena@email.com
curl -s %BASE_URL%/users/ximena@email.com | findstr "Ximena" >nul
if errorlevel 1 (
    echo   [FAIL]
    set /a FAIL+=1
) else (
    echo   [PASS] Returns single user
    set /a PASS+=1
)
timeout /t 1 /nobreak >nul

REM Test 3: Create user
echo [Test 3] POST /users (Create)
curl -s -X POST -H "Content-Type: application/json" -d "{\"email\":\"test@email.com\",\"name\":\"Test User\"}" %BASE_URL%/users | findstr "test@email.com" >nul
if errorlevel 1 (
    echo   [FAIL]
    set /a FAIL+=1
) else (
    echo   [PASS] User created
    set /a PASS+=1
)
timeout /t 1 /nobreak >nul

REM Test 4: Verify creation
echo [Test 4] GET /users/test@email.com
curl -s %BASE_URL%/users/test@email.com | findstr "Test User" >nul
if errorlevel 1 (
    echo   [FAIL]
    set /a FAIL+=1
) else (
    echo   [PASS] User found
    set /a PASS+=1
)
timeout /t 1 /nobreak >nul

REM Test 5: Update user
echo [Test 5] PUT /users/test@email.com
curl -s -X PUT -H "Content-Type: application/json" -d "{\"email\":\"test@email.com\",\"name\":\"Updated Name\"}" %BASE_URL%/users/test@email.com | findstr "Updated Name" >nul
if errorlevel 1 (
    echo   [FAIL]
    set /a FAIL+=1
) else (
    echo   [PASS] User updated
    set /a PASS+=1
)
timeout /t 1 /nobreak >nul

REM Test 6: Delete user
echo [Test 6] DELETE /users/test@email.com
curl -s -X DELETE -w "%%{http_code}" %BASE_URL%/users/test@email.com | findstr "204" >nul
if errorlevel 1 (
    echo   [FAIL]
    set /a FAIL+=1
) else (
    echo   [PASS] User deleted (204)
    set /a PASS+=1
)
timeout /t 1 /nobreak >nul

REM Test 7: Verify deletion (404 expected)
echo [Test 7] GET deleted user (expect 404)
curl -s -w "%%{http_code}" %BASE_URL%/users/test@email.com | findstr "404" >nul
if errorlevel 1 (
    echo   [FAIL]
    set /a FAIL+=1
) else (
    echo   [PASS] Returns 404
    set /a PASS+=1
)
timeout /t 1 /nobreak >nul

REM Test 8: Validation error (400 expected)
echo [Test 8] POST invalid data (expect 400)
curl -s -X POST -H "Content-Type: application/json" -d "{\"email\":\"\",\"name\":\"\"}" -w "%%{http_code}" %BASE_URL%/users | findstr "400" >nul
if errorlevel 1 (
    echo   [FAIL]
    set /a FAIL+=1
) else (
    echo   [PASS] Returns 400
    set /a PASS+=1
)
timeout /t 1 /nobreak >nul

REM Test 9: Health check
echo [Test 9] GET /users/health
curl -s %BASE_URL%/users/health | findstr "running" >nul
if errorlevel 1 (
    echo   [FAIL]
    set /a FAIL+=1
) else (
    echo   [PASS] Health OK
    set /a PASS+=1
)

echo.
echo ============================================
echo     TEST SUMMARY
echo ============================================
echo   PASS: %PASS%
echo   FAIL: %FAIL%
echo   Total: 9
echo ============================================

if %FAIL%==0 (
    echo   ALL TESTS PASSED!
) else (
    echo   SOME TESTS FAILED!
)

pause
