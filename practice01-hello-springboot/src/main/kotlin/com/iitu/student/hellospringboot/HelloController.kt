package com.iitu.student.hellospringboot

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Practice 01: Hello World Controller
 * 
 * This controller demonstrates basic REST endpoint creation in Spring Boot.
 * 
 * @RestController is a convenience annotation that combines:
 * - @Controller: Marks the class as a Spring MVC controller
 * - @ResponseBody: Binds the return value directly to the HTTP response body
 * 
 * This means methods in this class will return data (JSON, XML, or plain text)
 * rather than views.
 */
@RestController
class HelloController {

    /**
     * Root endpoint - Returns a simple hello message
     * 
     * @GetMapping("/") maps HTTP GET requests to the root path "/" to this method.
     * When you access http://localhost:8080/, this method will be called.
     * 
     * @return A welcome message string
     */
    @GetMapping("/")
    fun hello(): String {
        return "Hello, Spring Boot!"
    }

    /**
     * Greeting endpoint - Returns a course welcome message
     * 
     * @GetMapping("/greeting") maps HTTP GET requests to "/greeting" path.
     * When you access http://localhost:8080/greeting, this method will be called.
     * 
     * @return A greeting message for the Web Component Development course
     */
    @GetMapping("/greeting")
    fun greeting(): String {
        return "Welcome to Web Component Development!"
    }
}
