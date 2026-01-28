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
 * - Bootstraps the Spring application
 * - Creates the ApplicationContext (Spring container)
 * - Performs classpath scanning to find components
 * - Starts the embedded Tomcat server
 * - Runs the application
 */
@SpringBootApplication
class StudentInfoAppApplication

fun main(args: Array<String>) {
    runApplication<StudentInfoAppApplication>(*args)
}
