@echo off
:: Setup Java Permanently - Simple Version
:: Right-click → Run as administrator

echo ======================================================
echo   Setting Java Environment Variablesecho ======================================================
echo.

:: Check if admin
net session >nul 2>&1
if errorlevel 1 (
    echo [ERROR] Please run as Administrator!
    echo Right-click this file → "Run as administrator"
    pause
    exit /b 1
)

echo [1/3] Setting JAVA_HOME...
setx JAVA_HOME "C:\Program Files\JetBrains\IntelliJ IDEA 2025.2.5\jbr" /M
if errorlevel 1 (
    echo [ERROR] Failed to set JAVA_HOME
    pause
    exit /b 1
)
echo [OK] JAVA_HOME set
echo.

echo [2/3] Adding Java to PATH...
setx PATH "%PATH%;%%JAVA_HOME%%\bin" /M
if errorlevel 1 (
    echo [WARNING] Could not update PATH, but JAVA_HOME is set
) else (
    echo [OK] PATH updated
echo.

echo [3/3] Verifying...
echo.

:: Refresh environment
set "JAVA_HOME=C:\Program Files\JetBrains\IntelliJ IDEA 2025.2.5\jbr"
set "PATH=%JAVA_HOME%\bin;%PATH%"

echo Testing Java...
java -version 2>&1 | findstr "version" >nul
if errorlevel 1 (
    echo [WARNING] Java test failed, but settings were saved
    echo.
    echo Close this window and open NEW Command Prompt to test:
    echo   java -version
) else (
    echo [OK] Java is working!
    java -version 2>&1 | findstr "version"
)

echo.
echo ======================================================
echo   SETUP COMPLETE!
echo ======================================================
echo.
echo IMPORTANT: Close ALL Command Prompt/PowerShell windows
echo and open NEW ones for changes to take effect!
echo.
pause
