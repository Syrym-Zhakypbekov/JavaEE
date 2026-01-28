# 🔧 Permanently Set Java (JAVA_HOME) on Windows

## ✅ Method 1: Using System Properties (GUI - Easiest)

### Step 1: Open System Properties
1. Press `Win + R` (Run dialog)
2. Type: `sysdm.cpl`
3. Press Enter

### Step 2: Open Environment Variables
1. Click **"Advanced"** tab
2. Click **"Environment Variables"** button (bottom right)

### Step 3: Add JAVA_HOME
1. Under **"System variables"** section, click **"New..."**
2. Enter:
   - **Variable name:** `JAVA_HOME`
   - **Variable value:** `C:\Program Files\JetBrains\IntelliJ IDEA 2025.2.5\jbr`
3. Click **OK**

### Step 4: Update PATH
1. Find **"Path"** in the System variables list
2. Click **"Edit..."**
3. Click **"New"**
4. Add: `%JAVA_HOME%\bin`
5. Click **OK** → **OK** → **OK**

### Step 5: Verify (Open NEW PowerShell/CMD)
```powershell
java -version
echo $env:JAVA_HOME
```

✅ If you see Java version, it's working!

---

## ✅ Method 2: Using PowerShell (Quick - One Command)

### Run PowerShell as Administrator
1. Press `Win + X`
2. Select **"Windows PowerShell (Admin)"** or **"Terminal (Admin)"**

### Run These Commands:
```powershell
# Set JAVA_HOME permanently
[Environment]::SetEnvironmentVariable("JAVA_HOME", "C:\Program Files\JetBrains\IntelliJ IDEA 2025.2.5\jbr", "Machine")

# Get current PATH
$currentPath = [Environment]::GetEnvironmentVariable("Path", "Machine")

# Add Java bin to PATH
$newPath = $currentPath + ";%JAVA_HOME%\bin"
[Environment]::SetEnvironmentVariable("Path", $newPath, "Machine")

# Verify
Write-Host "Java home set to: $env:JAVA_HOME"
```

### Close and reopen PowerShell, then test:
```powershell
java -version
```

---

## ✅ Method 3: Using Command Prompt (Admin)

### Run CMD as Administrator
1. Press `Win + R`
2. Type: `cmd`
3. Press `Ctrl + Shift + Enter` (opens as Admin)

### Run These Commands:
```batch
:: Set JAVA_HOME
setx /M JAVA_HOME "C:\Program Files\JetBrains\IntelliJ IDEA 2025.2.5\jbr"

:: Add to PATH
setx /M PATH "%PATH%;%%JAVA_HOME%%\bin"
```

### Close and reopen CMD, then test:
```batch
java -version
echo %JAVA_HOME%
```

---

## ✅ Method 4: Add to PowerShell Profile (Auto-set every time)

This method sets Java every time you open PowerShell:

### Step 1: Open PowerShell Profile
```powershell
notepad $PROFILE
```

If it says file doesn't exist, create it:
```powershell
New-Item -Path $PROFILE -Type File -Force
notepad $PROFILE
```

### Step 2: Add These Lines
```powershell
# Java Configuration
$env:JAVA_HOME = "C:	ools	est	est_helper.rbProgram Files\JetBrains\IntelliJ IDEA 2025.2.5\jbr"
$env:PATH = "$env:JAVA_HOME\bin;$env:PATH"
```

### Step 3: Save and Close
- Save file: `Ctrl + S`
- Close Notepad

### Step 4: Test (Open NEW PowerShell)
```powershell
java -version
echo $env:JAVA_HOME
```

---

## 🎯 Recommended: Quick Fix Script

I've created a script that sets Java permanently. Run as Administrator:

```powershell
# Run this in PowerShell as Administrator
[Environment]::SetEnvironmentVariable("JAVA_HOME", "C:\Program Files\JetBrains\IntelliJ IDEA 2025.2.5\jbr", "User")

$path = [Environment]::GetEnvironmentVariable("Path", "User")
if ($path -notlike "*%JAVA_HOME%*") {
    [Environment]::SetEnvironmentVariable("Path", "$path;%JAVA_HOME%\bin", "User")
}

Write-Host "✅ Java configured! Close and reopen PowerShell." -ForegroundColor Green
```

---

## 🧪 Verify Installation

After setting up (in a NEW PowerShell/CMD window):

```powershell
# Test 1: Java version
java -version
# Expected: openjdk version "21.0.9"...

# Test 2: JAVA_HOME variable
echo $env:JAVA_HOME
# Expected: C:\Program Files\JetBrains\IntelliJ IDEA 2025.2.5\jbr

# Test 3: javac exists
javac -version
# Expected: javac 21.0.9...
```

---

## 🚀 Now Run Your Project!

After Java is set permanently:

```powershell
cd C:\Users\syrym\IdeaProjects\JavaEE\lab02-users-app
.\gradlew.bat bootRun
```

✅ It should work without any JAVA_HOME errors!

---

## 🔧 Troubleshooting

### "Access Denied" Error
→ Run PowerShell/CMD as **Administrator**

### Changes Don't Apply
→ Close ALL PowerShell/CMD windows and open NEW ones

### Java Still Not Found
→ Restart your computer (some Windows versions need this)

### Check Which Java
```powershell
Get-Command java | Select-Object Source
```

---

## 📊 What We Did

| Variable | Value | Purpose |
|----------|-------|---------|
| `JAVA_HOME` | `C:\Program Files\JetBrains\IntelliJ IDEA 2025.2.5\jbr` | Tells programs where Java is |
| `PATH` | `%JAVA_HOME%\bin` | Makes `java` command work everywhere |

---

**After setting this up, Java will work permanently in all terminals! 🎉**
