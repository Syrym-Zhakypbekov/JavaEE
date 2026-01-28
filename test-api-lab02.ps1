# =====================================================
# Lab 02 - API Testing Script (Run while app is running)
# =====================================================

param(
    [switch]$Continuous
)

$baseUrl = "http://localhost:8080"

function Test-Endpoint {
    param($Method, $Uri, $Body, $ExpectedStatus)
    
    try {
        $params = @{
            Uri = $Uri
            Method = $Method
            UseBasicParsing = $true
            TimeoutSec = 5
        }
        if ($Body) { $params.Body = $Body; $params.ContentType = "application/json" }
        
        $response = Invoke-WebRequest @params
        $status = $response.StatusCode
        $content = $response.Content
        
        if ($ExpectedStatus -and $status -ne $ExpectedStatus) {
            Write-Host "⚠️  $Method $Uri - Expected $ExpectedStatus, got $status" -ForegroundColor Yellow
        } else {
            Write-Host "✅ $Method $Uri - $status" -ForegroundColor Green
        }
        if ($content) { Write-Host "   📄 $content`n" -ForegroundColor Gray }
        return $true
    } catch {
        $status = $_.Exception.Response.StatusCode.value__
        if ($ExpectedStatus -and $status -eq $ExpectedStatus) {
            Write-Host "✅ $Method $Uri - $status (Expected)" -ForegroundColor Green
            return $true
        } else {
            Write-Host "❌ $Method $Uri - Error: $status" -ForegroundColor Red
            return $false
        }
    }
}

Write-Host @"
╔══════════════════════════════════════════════════════════════╗
║          Lab 02 - Automated API Testing                       ║
╚══════════════════════════════════════════════════════════════╝
"@ -ForegroundColor Cyan

$passCount = 0
$failCount = 0

# Test 1: GET all users
Write-Host "`n--- Test 1: Get All Users ---" -ForegroundColor Yellow
if (Test-Endpoint -Method GET -Uri "$baseUrl/users") { $passCount++ } else { $failCount++ }
Start-Sleep -Milliseconds 500

# Test 2: GET user by email
Write-Host "--- Test 2: Get User by Email ---" -ForegroundColor Yellow
if (Test-Endpoint -Method GET -Uri "$baseUrl/users/ximena@email.com") { $passCount++ } else { $failCount++ }
Start-Sleep -Milliseconds 500

# Test 3: POST create new user
Write-Host "--- Test 3: Create New User ---" -ForegroundColor Yellow
$body = '{"email":"test@email.com","name":"Test User"}'
if (Test-Endpoint -Method POST -Uri "$baseUrl/users" -Body $body) { $passCount++ } else { $failCount++ }
Start-Sleep -Milliseconds 500

# Test 4: Verify user created
Write-Host "--- Test 4: Verify User Created ---" -ForegroundColor Yellow
if (Test-Endpoint -Method GET -Uri "$baseUrl/users/test@email.com") { $passCount++ } else { $failCount++ }
Start-Sleep -Milliseconds 500

# Test 5: PUT update user
Write-Host "--- Test 5: Update User ---" -ForegroundColor Yellow
$body = '{"email":"test@email.com","name":"Updated Name"}'
if (Test-Endpoint -Method PUT -Uri "$baseUrl/users/test@email.com" -Body $body) { $passCount++ } else { $failCount++ }
Start-Sleep -Milliseconds 500

# Test 6: DELETE user
Write-Host "--- Test 6: Delete User ---" -ForegroundColor Yellow
if (Test-Endpoint -Method DELETE -Uri "$baseUrl/users/test@email.com" -ExpectedStatus 204) { $passCount++ } else { $failCount++ }
Start-Sleep -Milliseconds 500

# Test 7: Verify deletion (404 expected)
Write-Host "--- Test 7: Verify Deletion (Expect 404) ---" -ForegroundColor Yellow
if (Test-Endpoint -Method GET -Uri "$baseUrl/users/test@email.com" -ExpectedStatus 404) { $passCount++ } else { $failCount++ }
Start-Sleep -Milliseconds 500

# Test 8: Validation error (400 expected)
Write-Host "--- Test 8: Validation Error (Expect 400) ---" -ForegroundColor Yellow
$body = '{"email":"","name":""}'
if (Test-Endpoint -Method POST -Uri "$baseUrl/users" -Body $body -ExpectedStatus 400) { $passCount++ } else { $failCount++ }
Start-Sleep -Milliseconds 500

# Test 9: Health check
Write-Host "--- Test 9: Health Check ---" -ForegroundColor Yellow
if (Test-Endpoint -Method GET -Uri "$baseUrl/users/health") { $passCount++ } else { $failCount++ }

# Summary
Write-Host "`n╔══════════════════════════════════════════════════════════════╗" -ForegroundColor Cyan
Write-Host "║                    TEST SUMMARY                              ║" -ForegroundColor Cyan
Write-Host "╠══════════════════════════════════════════════════════════════╣" -ForegroundColor Cyan
Write-Host "║  ✅ Passed: $passCount                                              ║" -ForegroundColor Green
Write-Host "║  ❌ Failed: $failCount                                              ║" -ForegroundColor $(if($failCount -gt 0){"Red"}else{"Green"})
Write-Host "║  📊 Total:  $passCount                                               ║" -ForegroundColor Cyan
Write-Host "╚══════════════════════════════════════════════════════════════╝" -ForegroundColor Cyan

if ($Continuous) {
    Write-Host "`n🔄 Continuous mode - Press Ctrl+C to stop`n" -ForegroundColor Yellow
    while ($true) {
        Start-Sleep -Seconds 5
        Test-Endpoint -Method GET -Uri "$baseUrl/users/health" | Out-Null
    }
}
