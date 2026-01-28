# =====================================================
# Setup Java Permanently on Windows
# Run this as Administrator in PowerShell
# =====================================================

$javaPath = "C:\Program Files\JetBrains\IntelliJ IDEA 2025.2.5\jbr"

Write-Host "======================================================" -ForegroundColor Cyan
Write-Host "  Setting Java Environment Variables Permanently" -ForegroundColor Cyan
Write-Host "======================================================" -ForegroundColor Cyan
Write-Host ""

# Check if running as Administrator
$currentPrincipal = New-Object Security.Principal.WindowsPrincipal([Security.Principal.WindowsIdentity]::GetCurrent())
$isAdmin = $currentPrincipal.IsInRole([Security.Principal.WindowsBuiltInRole]::Administrator)

if (-not $isAdmin) {
    Write-Host "❌ ERROR: Please run PowerShell as Administrator!" -ForegroundColor Red
    Write-Host ""
    Write-Host "   Right-click PowerShell → 'Run as administrator'" -ForegroundColor Yellow
    Write-Host ""
    exit 1
}

# Check if Java exists at that path
if (-not (Test-Path "$javaPath\bin\java.exe")) {
    Write-Host "❌ ERROR: Java not found at: $javaPath" -ForegroundColor Red
    Write-Host ""
    exit 1
}

Write-Host "✅ Found Java at: $javaPath" -ForegroundColor Green
Write-Host ""

# Set JAVA_HOME for User
Write-Host "[1/3] Setting JAVA_HOME..." -ForegroundColor Yellow
[Environment]::SetEnvironmentVariable("JAVA_HOME", $javaPath, "User")
Write-Host "      ✅ JAVA_HOME set for current user" -ForegroundColor Green
Write-Host ""

# Set JAVA_HOME for Machine (System-wide)
Write-Host "[2/3] Setting JAVA_HOME system-wide..." -ForegroundColor Yellow
[Environment]::SetEnvironmentVariable("JAVA_HOME", $javaPath, "Machine")
Write-Host "      ✅ JAVA_HOME set for all users" -ForegroundColor Green
Write-Host ""

# Update PATH for User
Write-Host "[3/3] Updating PATH..." -ForegroundColor Yellow
$userPath = [Environment]::GetEnvironmentVariable("Path", "User")
if ($userPath -notlike "*$javaPath*") {
    $newUserPath = "$userPath;$javaPath\bin"
    [Environment]::SetEnvironmentVariable("Path", $newUserPath, "User")
    Write-Host "      ✅ PATH updated for current user" -ForegroundColor Green
} else {
    Write-Host "      ℹ️  PATH already contains Java" -ForegroundColor Yellow
}

# Update PATH for Machine
$machinePath = [Environment]::GetEnvironmentVariable("Path", "Machine")
if ($machinePath -notlike "*$javaPath*") {
    $newMachinePath = "$machinePath;$javaPath\bin"
    [Environment]::SetEnvironmentVariable("Path", $newMachinePath, "Machine")
    Write-Host "      ✅ PATH updated for all users" -ForegroundColor Green
} else {
    Write-Host "      ℹ️  PATH already contains Java" -ForegroundColor Yellow
}

Write-Host ""
Write-Host "======================================================" -ForegroundColor Cyan
Write-Host "  ✅ Java Configuration Complete!" -ForegroundColor Green
Write-Host "======================================================" -ForegroundColor Cyan
Write-Host ""
Write-Host "IMPORTANT: Close this PowerShell and open a NEW one!" -ForegroundColor Yellow
Write-Host ""
Write-Host "Then test with:" -ForegroundColor Cyan
Write-Host "   java -version" -ForegroundColor White
Write-Host ""
Write-Host "After that, your JavaEE projects will work!" -ForegroundColor Green
Write-Host ""

# Also update current session
$env:JAVA_HOME = $javaPath
$env:PATH = "$javaPath\bin;$env:PATH"

# Test in current session
try {
    $javaVersion = java -version 2>&1 | Select-String "version" | Select-Object -First 1
    Write-Host "Verification in current session:" -ForegroundColor Cyan
    Write-Host "   $javaVersion" -ForegroundColor Green
} catch {
    Write-Host "   (Will work after opening new PowerShell)" -ForegroundColor Yellow
}

Write-Host ""
