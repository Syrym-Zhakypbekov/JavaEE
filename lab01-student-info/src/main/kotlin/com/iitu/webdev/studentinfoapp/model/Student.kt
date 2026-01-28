package com.iitu.webdev.studentinfoapp.model

/**
 * Lab 1.2 Task 1: Student Model Class
 * 
 * This class represents a Student entity in our application.
 * It contains the data structure for student information.
 * 
 * In Kotlin, we use data classes for model classes because they automatically provide:
 * - equals() and hashCode() methods
 * - toString() method
 * - copy() method
 * - componentN() methods for destructuring
 * 
 * DATA CLASS vs REGULAR CLASS:
 * - Data class is ideal for classes that primarily hold data
 * - Regular class would require manually writing getters, setters, equals, hashCode
 * - Kotlin generates all boilerplate code for data classes
 */
data class Student(
    /**
     * Student unique identifier
     * Example: "S001", "S002"
     */
    var id: String? = null,
    
    /**
     * Student full name
     * Example: "Alice Johnson", "Bob Smith"
     */
    var name: String? = null,
    
    /**
     * Student email address
     * Example: "alice@iitu.edu.kz"
     */
    var email: String? = null,
    
    /**
     * Student major/field of study
     * Example: "Computer Science", "Software Engineering"
     */
    var major: String? = null
)

/**
 * WHY GETTERS AND SETTERS ARE IMPORTANT:
 * 
 * 1. Encapsulation: They hide the internal representation of data
 *    - Internal data structure can change without affecting external code
 * 
 * 2. Validation: Setters can validate data before setting it
 *    Example: Check if email format is valid
 * 
 * 3. Computed Properties: Getters can return computed values
 *    Example: getFullName() could combine first and last names
 * 
 * 4. Framework Integration: Many frameworks (like Spring, Jackson) require
 *    getters/setters for serialization/deserialization
 * 
 * KOTLIN ADVANTAGE:
 * In Java, you would write:
 *   private String id;
 *   public String getId() { return id; }
 *   public void setId(String id) { this.id = id; }
 * 
 * In Kotlin, data class automatically generates these!
 * The properties are accessible directly but use getters/setters internally.
 */
