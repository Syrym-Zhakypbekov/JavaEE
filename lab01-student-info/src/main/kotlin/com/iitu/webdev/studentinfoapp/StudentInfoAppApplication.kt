package com.iitu.webdev.studentinfoapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * Lab 1.1: Student Info App - Main Application Class
 * 
 * This is the entry point for the Student Information Application.
 * 
 * ANNOTATION EXPLANATION:
 * @SpringBootApplication is a meta-annotation that combines three annotations:
 * 
 * 1. @Configuration - Marks this class as a configuration class that can define
 *    beans using @Bean methods
 * 
 * 2. @EnableAutoConfiguration - Enables Spring Boot's auto-configuration mechanism
 *    which automatically configures the application based on classpath dependencies
 *    Example: If spring-boot-starter-web is in classpath, it auto-configures Tomcat
 * 
 * 3. @ComponentScan - Scans for Spring components (@Component, @Service, @Repository,
 *    @Controller) in the current package and all sub-packages
 * 
 * MAIN METHOD EXPLANATION:
 * The main() method uses runApplication<StudentInfoAppApplication>(*args) which:
 * 1. Bootstraps the Spring application
 * 2. Creates the ApplicationContext (Spring container)
 * 3. Performs classpath scanning to find components
 * 4. Starts the embedded Tomcat server
 * 5. Runs the application
 */
@SpringBootApplication
class StudentInfoAppApplication

fun main(args: Array<String>) {
    val context = runApplication<StudentInfoAppApplication>(*args)
    
    // Display startup banner
    val port = context.environment.getProperty("server.port") ?: "8080"
    val contextPath = context.environment.getProperty("server.servlet.context-path") ?: ""
    val baseUrl = "http://localhost:$port$contextPath"
    
    println("""
        
        ╔══════════════════════════════════════════════════════════════╗
        ║                                                              ║
        ║   🚀 Lab 01: Student Info App Started!                       ║
        ║                                                              ║
        ║   📍 Base URL: $baseUrl                            ║
        ║                                                              ║
        ║   📋 Available Endpoints:                                    ║
        ║      GET  $baseUrl/students                                  ║
        ║      GET  $baseUrl/students/S001                             ║
        ║      POST $baseUrl/students                                  ║
        ║      GET  $baseUrl/students/health                           ║
        ║                                                              ║
        ║   👥 Initial Data:                                           ║
        ║      S001: Alice Johnson (Computer Science)                  ║
        ║      S002: Bob Smith (Software Engineering)                  ║
        ║                                                              ║
        ╚══════════════════════════════════════════════════════════════╝
        
    """.trimIndent())
}
