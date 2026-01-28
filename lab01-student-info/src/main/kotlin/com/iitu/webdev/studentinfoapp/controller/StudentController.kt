package com.iitu.webdev.studentinfoapp.controller

import com.iitu.webdev.studentinfoapp.model.Student
import org.springframework.web.bind.annotation.*

/**
 * Lab 1.2 Task 2: REST Controller for Student Management
 * 
 * This controller handles HTTP requests for student-related operations.
 * It provides endpoints for CRUD (Create, Read, Update, Delete) operations.
 * 
 * ANNOTATION EXPLANATION:
 * 
 * @RestController:
 * - Combines @Controller and @ResponseBody
 * - Marks this class as a REST API controller
 * - Return values are automatically serialized to JSON (or XML)
 * - Each method's return value goes directly to the HTTP response body
 * 
 * @RequestMapping("/students"):
 * - Sets the base URL path for all endpoints in this controller
 * - All methods will have URLs starting with /students
 * - Combined with server.servlet.context-path=/api from properties
 * - Full base path: http://localhost:8080/api/students
 */
@RestController
@RequestMapping("/students")
class StudentController {

    /**
     * In-memory storage for students
     * Using HashMap where key = student ID, value = Student object
     * 
     * NOTE: This is temporary storage. Data will be lost when:
     * - Application restarts
     * - Server shuts down
     * 
     * In production, you would use a database (MySQL, PostgreSQL, MongoDB)
     */
    private val students: MutableMap<String, Student> = HashMap()

    /**
     * Constructor - Initialize with sample data
     * This block runs when the controller is created (at application startup)
     */
    init {
        // Add sample students to the map
        students["S001"] = Student(
            id = "S001",
            name = "Alice Johnson",
            email = "alice@iitu.edu.kz",
            major = "Computer Science"
        )
        students["S002"] = Student(
            id = "S002",
            name = "Bob Smith",
            email = "bob@iitu.edu.kz",
            major = "Software Engineering"
        )
    }

    /**
     * GET /api/students - Get all students
     * 
     * @GetMapping:
     * - Maps HTTP GET requests to this method
     * - URL: http://localhost:8080/api/students
     * - Used for retrieving data
     * 
     * @return List of all students
     */
    @GetMapping
    fun getAllStudents(): List<Student> {
        return ArrayList(students.values)
    }

    /**
     * GET /api/students/{id} - Get student by ID
     * 
     * @GetMapping("/{id}"):
     * - Maps HTTP GET requests to this method with a path variable
     * - Example URL: http://localhost:8080/api/students/S001
     * 
     * @PathVariable:
     * - Extracts values from the URL path
     * - Binds the {id} from URL to the method parameter
     * - Example: URL /students/S001 -> id parameter = "S001"
     * 
     * @param id The student ID from the URL
     * @return The student with the given ID, or null if not found
     */
    @GetMapping("/{id}")
    fun getStudentById(@PathVariable id: String): Student? {
        return students[id]
    }

    /**
     * POST /api/students - Create a new student
     * 
     * @PostMapping:
     * - Maps HTTP POST requests to this method
     * - URL: http://localhost:8080/api/students
     * - Used for creating new resources
     * 
     * @RequestBody:
     * - Binds the HTTP request body to the method parameter
     * - Automatically converts JSON in the request body to Student object
     * - Example request body:
     *   {
     *     "id": "S003",
     *     "name": "Charlie Brown",
     *     "email": "charlie@iitu.edu.kz",
     *     "major": "Information Systems"
     *   }
     * 
     * @param student The student object from request body
     * @return The created student
     */
    @PostMapping
    fun createStudent(@RequestBody student: Student): Student {
        // Store the student using their ID as the key
        students[student.id!!] = student
        return student
    }

    /**
     * GET /api/students/health - Health check endpoint
     * 
     * This endpoint is useful for:
     * - Checking if the API is running
     * - Load balancer health checks
     * - Monitoring tools
     * 
     * @return Status message indicating the API is operational
     */
    @GetMapping("/health")
    fun health(): String {
        return "Student API is running!"
    }
}

/**
 * SUMMARY OF ANNOTATIONS:
 * 
 * 1. @RestController - Marks class as REST controller, return values go to response body
 * 
 * 2. @RequestMapping("/students") - Sets base URL path for all endpoints
 * 
 * 3. @GetMapping - Handles HTTP GET requests (read operations)
 *    Variants: @GetMapping, @GetMapping("/{id}"), @GetMapping("/health")
 * 
 * 4. @PostMapping - Handles HTTP POST requests (create operations)
 * 
 * 5. @PathVariable - Extracts values from URL path (e.g., /students/{id})
 * 
 * 6. @RequestBody - Binds HTTP request body to method parameter (JSON -> Object)
 */
