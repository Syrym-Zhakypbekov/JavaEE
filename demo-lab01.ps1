# =====================================================
# Lab 01 - Student Info App Demo Script
# =====================================================

Write-Host @"
╔══════════════════════════════════════════════════════════════╗
║                                                              ║
║   Lab 01: Student Info App                                   ║
║   Web Component Development (Java EE) - Week 1              ║
║                                                              ║
╚══════════════════════════════════════════════════════════════╝
"@ -ForegroundColor Green

$env:JAVA_HOME = "C:\Program Files\JetBrains\IntelliJ IDEA 2025.2.5\jbr"
$env:Path = "$env:JAVA_HOME\bin;$env:Path"

cd "$PSScriptRoot\lab01-student-info"

Write-Host "`n📦 Building project..." -ForegroundColor Yellow
.\gradlew.bat build --no-daemon --quiet -x test

if ($LASTEXITCODE -eq 0) {
    Write-Host "✅ Build successful!`n" -ForegroundColor Green
    
    Write-Host "🚀 Starting application..." -ForegroundColor Yellow
    Write-Host "📍 Base URL: http://localhost:8080/api"
    Write-Host "`n📋 Available Endpoints:"
    Write-Host "   GET  /api/students      - Get all students"
    Write-Host "   GET  /api/students/S001 - Get student by ID"
    Write-Host "   POST /api/students      - Create new student"
    Write-Host "   GET  /api/students/health - Health check`n"
    
    .\gradlew.bat bootRun --no-daemon --quiet
} else {
    Write-Host "❌ Build failed!" -ForegroundColor Red
}
