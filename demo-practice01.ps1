# =====================================================
# Practice 01 - Hello Spring Boot Demo Script
# =====================================================

Write-Host @"
╔══════════════════════════════════════════════════════════════╗
║                                                              ║
║   Practice 01: Hello Spring Boot                             ║
║   Web Component Development (Java EE) - Week 1              ║
║                                                              ║
╚══════════════════════════════════════════════════════════════╝
"@ -ForegroundColor Cyan

$env:JAVA_HOME = "C:\Program Files\JetBrains\IntelliJ IDEA 2025.2.5\jbr"
$env:Path = "$env:JAVA_HOME\bin;$env:Path"

cd "$PSScriptRoot\practice01-hello-springboot"

Write-Host "`n📦 Building project..." -ForegroundColor Yellow
.\gradlew.bat build --no-daemon --quiet -x test

if ($LASTEXITCODE -eq 0) {
    Write-Host "✅ Build successful!`n" -ForegroundColor Green
    
    Write-Host "🚀 Starting application..." -ForegroundColor Yellow
    Write-Host "📍 URL: http://localhost:8080/"
    Write-Host "📍 URL: http://localhost:8080/greeting`n"
    
    .\gradlew.bat bootRun --no-daemon --quiet
} else {
    Write-Host "❌ Build failed!" -ForegroundColor Red
}
