# =====================================================
# Lab 02 - Users App Demo Script (Full CRUD)
# =====================================================

Write-Host @"
╔══════════════════════════════════════════════════════════════╗
║                                                              ║
║   Lab 02: Users App - Complete CRUD API                      ║
║   Web Component Development (Java EE) - Week 1              ║
║                                                              ║
╚══════════════════════════════════════════════════════════════╝
"@ -ForegroundColor Magenta

$env:JAVA_HOME = "C:\Program Files\JetBrains\IntelliJ IDEA 2025.2.5\jbr"
$env:Path = "$env:JAVA_HOME\bin;$env:Path"

cd "$PSScriptRoot\lab02-users-app"

Write-Host "`n📦 Building project..." -ForegroundColor Yellow
.\gradlew.bat build --no-daemon --quiet -x test

if ($LASTEXITCODE -eq 0) {
    Write-Host "✅ Build successful!`n" -ForegroundColor Green
    
    Write-Host "🚀 Starting application..." -ForegroundColor Yellow
    Write-Host "📍 Base URL: http://localhost:8080"
    Write-Host "`n📋 Available Endpoints (CRUD):"
    Write-Host "   GET    /users              - Read all users"
    Write-Host "   GET    /users/{email}      - Read one user"
    Write-Host "   POST   /users              - Create user"
    Write-Host "   PUT    /users/{email}      - Update user"
    Write-Host "   DELETE /users/{email}      - Delete user"
    Write-Host "   GET    /users/health       - Health check"
    Write-Host "`n🎯 Bonus Features:"
    Write-Host "   ✅ Input Validation (400 Bad Request)"
    Write-Host "   ✅ Error Handling (404 Not Found)"
    Write-Host "   ✅ HTTP Status Codes (200, 201, 204)`n"
    
    .\gradlew.bat bootRun --no-daemon --quiet
} else {
    Write-Host "❌ Build failed!" -ForegroundColor Red
}
