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
    runApplication<UsersAppApplication>(*args)
}
