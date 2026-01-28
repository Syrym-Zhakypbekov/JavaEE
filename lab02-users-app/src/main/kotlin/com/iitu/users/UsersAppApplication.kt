package com.iitu.users

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * Lab 2: Users App - Main Application Class
 * 
 * This application demonstrates a complete CRUD (Create, Read, Update, Delete) API
 * for managing users with email and name fields.
 * 
 * CHAPTER 1 CONCEPTS FROM THE BOOK:
 * - Spring Boot auto-configuration
 * - Embedded Tomcat server
 * - REST controller development
 * - HTTP method mapping
 * - JSON serialization/deserialization
 */
@SpringBootApplication
class UsersAppApplication

fun main(args: Array<String>) {
    val context = runApplication<UsersAppApplication>(*args)
    
    // Display startup banner
    val port = context.environment.getProperty("server.port") ?: "8080"
    val baseUrl = "http://localhost:$port"
    
    println("""
        
        ╔══════════════════════════════════════════════════════════════╗
        ║                                                              ║
        ║   🚀 Lab 02: Users App Started!                              ║
        ║   Complete CRUD API Implementation                           ║
        ║                                                              ║
        ║   📍 Base URL: $baseUrl                                   ║
        ║                                                              ║
        ║   📋 Available Endpoints (CRUD):                             ║
        ║      GET    $baseUrl/users                                   ║
        ║      GET    $baseUrl/users/{email}                           ║
        ║      POST   $baseUrl/users                                   ║
        ║      PUT    $baseUrl/users/{email}                           ║
        ║      DELETE $baseUrl/users/{email}                           ║
        ║      GET    $baseUrl/users/health                            ║
        ║                                                              ║
        ║   👥 Initial Users:                                          ║
        ║      ximena@email.com: Ximena                                ║
        ║      norma@email.com: Norma                                  ║
        ║                                                              ║
        ║   🎯 Bonus Features:                                         ║
        ║      ✅ Input Validation (@Valid, @NotBlank, @Email)         ║
        ║      ✅ Error Handling (404, 400 responses)                  ║
        ║      ✅ Global Exception Handler                             ║
        ║                                                              ║
        ╚══════════════════════════════════════════════════════════════╝
        
    """.trimIndent())
}
