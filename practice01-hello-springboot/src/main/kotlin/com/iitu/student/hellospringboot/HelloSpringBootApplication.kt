package com.iitu.student.hellospringboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * Practice 01: Hello Spring Boot
 * 
 * This is the main entry point of the Spring Boot application.
 * 
 * @SpringBootApplication is a convenience annotation that combines:
 * - @Configuration: Marks this class as a source of bean definitions
 * - @EnableAutoConfiguration: Enables Spring Boot's auto-configuration mechanism
 * - @ComponentScan: Scans for components in the current package and sub-packages
 * 
 * The auto-configuration feature automatically configures Spring components
 * based on the dependencies present in the classpath.
 */
@SpringBootApplication
class HelloSpringBootApplication

/**
 * Main function - Entry point of the application
 * 
 * runApplication<HelloSpringBootApplication>(*args) does the following:
 * 1. Creates an ApplicationContext (the Spring container)
 * 2. Registers all beans (components, services, controllers)
 * 3. Starts the embedded Tomcat server
 * 4. Runs the application
 * 
 * @param args Command line arguments passed to the application
 */
fun main(args: Array<String>) {
    val context = runApplication<HelloSpringBootApplication>(*args)
    
    // Display startup banner
    val port = context.environment.getProperty("server.port") ?: "8080"
    println("""
        
        ╔══════════════════════════════════════════════════════════════╗
        ║                                                              ║
        ║   🚀 Practice 01: Hello Spring Boot Started!                 ║
        ║                                                              ║
        ║   📍 Application URL: http://localhost:$port                 ║
        ║                                                              ║
        ║   📋 Available Endpoints:                                    ║
        ║      GET http://localhost:$port/                             ║
        ║      GET http://localhost:$port/greeting                     ║
        ║                                                              ║
        ╚══════════════════════════════════════════════════════════════╝
        
    """.trimIndent())
}
