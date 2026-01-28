package com.iitu.users

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

/**
 * Lab 2.1 Task 2: User Model Class
 * 
 * This class represents a User entity in our application.
 * Following the book's implementation, we use email as the unique identifier.
 * 
 * WHY EMAIL AS KEY:
 * - Email is naturally unique (no two users should have same email)
 * - Easy to remember and human-readable
 * - Commonly used in real-world applications for login
 * 
 * VALIDATION ANNOTATIONS:
 * - @NotBlank: Ensures the field is not null and not empty
 * - @Email: Validates that the field contains a valid email format
 */
data class User(
    
    /**
     * User email - used as unique identifier (key in the Map)
     * Must be a valid email format and not blank
     */
    @field:NotBlank(message = "Email is required")
    @field:Email(message = "Please provide a valid email address")
    var email: String? = null,
    
    /**
     * User name
     * Must not be blank
     */
    @field:NotBlank(message = "Name is required")
    var name: String? = null
)
