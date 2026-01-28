package com.iitu.users

import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

/**
 * Lab 2.1 & 2.2: Users Controller - Complete CRUD Implementation
 * 
 * This controller implements all CRUD operations for User management:
 * - C (Create): POST /users - Create new user
 * - R (Read):   GET /users - Get all users, GET /users/{email} - Get user by email
 * - U (Update): PUT /users/{email} - Update existing user
 * - D (Delete): DELETE /users/{email} - Delete user by email
 * 
 * ANNOTATION EXPLANATIONS:
 * 
 * @RestController:
 * - Marks this class as a REST controller
 * - Combines @Controller and @ResponseBody
 * - Return values are automatically converted to JSON
 * 
 * @RequestMapping("/users"):
 * - Sets the base URL path for all endpoints
 * - All endpoints will be under /users
 */
@RestController
@RequestMapping("/users")
class UsersController {

    /**
     * In-memory storage using Map (HashMap)
     * Key: User email (String)
     * Value: User object
     * 
     * WHY Map<String, User>:
     * - Fast lookup by email (O(1) time complexity)
     * - Email is unique, so it's perfect as a key
     * - Simple and efficient for this lab
     * 
     * LIMITATION:
     * - Data is lost when application restarts
     * - Not thread-safe for concurrent access
     * - In production, use a database
     */
    private val users: MutableMap<String, User> = HashMap()

    /**
     * Constructor - Initialize with sample data as specified in the book
     * This init block runs when the controller is created
     */
    init {
        // Add initial sample users
        users["ximena@email.com"] = User(
            email = "ximena@email.com",
            name = "Ximena"
        )
        users["norma@email.com"] = User(
            email = "norma@email.com",
            name = "Norma"
        )
    }

    // ============================================================
    // READ OPERATIONS (Lab 2.1 Task 3)
    // ============================================================

    /**
     * GET /users - Get all users
     * 
     * @GetMapping:
     * - Maps HTTP GET requests to this method
     * - URL: http://localhost:8080/users
     * - Returns a collection of all users
     * 
     * Collection<User> vs List<User>:
     * - Collection is more generic interface
     * - users.values() returns a Collection view of the map values
     */
    @GetMapping
    fun getAllUsers(): Collection<User> {
        return users.values
    }

    /**
     * GET /users/{email} - Get user by email
     * 
     * @GetMapping("/{email}"):
     * - Maps HTTP GET with path variable
     * - Example: GET /users/ximena@email.com
     * 
     * @PathVariable:
     * - Extracts {email} from the URL path
     * - Binds it to the method parameter
     * 
     * ERROR HANDLING:
     * - Returns 404 Not Found if user doesn't exist
     * - Uses ResponseStatusException for proper HTTP status codes
     * 
     * @param email The email from the URL path
     * @return The user if found
     * @throws ResponseStatusException with 404 if not found
     */
    @GetMapping("/{email}")
    fun findUserByEmail(@PathVariable email: String): User {
        return users[email] 
            ?: throw ResponseStatusException(
                HttpStatus.NOT_FOUND, 
                "User with email '$email' not found"
            )
    }

    // ============================================================
    // CREATE OPERATION (Lab 2.2 Task 1)
    // ============================================================

    /**
     * POST /users - Create new user
     * 
     * @PostMapping:
     * - Maps HTTP POST requests to this method
     * - URL: http://localhost:8080/users
     * - Used for creating new resources
     * 
     * @RequestBody:
     * - Binds HTTP request body to the method parameter
     * - Automatically converts JSON to User object
     * - Example request body:
     *   {"email": "alice@email.com", "name": "Alice"}
     * 
     * @Valid:
     * - Triggers validation of the User object
     * - Checks @NotBlank and @Email annotations
     * - Returns 400 Bad Request if validation fails
     * 
     * BEHAVIOR:
     * - If user with same email exists, it will be overwritten
     * - Returns the created user
     * - HTTP status: 200 OK (or 201 Created if we returned ResponseEntity)
     * 
     * @param user The user object from request body
     * @return The created user
     */
    @PostMapping
    fun save(@Valid @RequestBody user: User): User {
        // Store user with email as key
        // If email already exists, this will update the existing entry
        users[user.email!!] = user
        return user
    }

    // ============================================================
    // DELETE OPERATION (Lab 2.2 Task 2)
    // ============================================================

    /**
     * DELETE /users/{email} - Delete user by email
     * 
     * @DeleteMapping:
     * - Maps HTTP DELETE requests to this method
     * - Example: DELETE /users/ximena@email.com
     * 
     * WHY RETURN VOID:
     * - DELETE operation typically doesn't return a body
     * - HTTP 204 No Content is the standard success response
     * - Client only needs to know the operation succeeded
     * 
     * BEHAVIOR IF EMAIL DOESN'T EXIST:
     * - Map.remove() returns null but doesn't throw error
     * - HTTP status will still be 200 OK by default
     * - For stricter handling, we could check if user existed first
     * 
     * HTTP STATUS CODES:
     * - 200 OK: Operation succeeded (or 204 No Content)
     * - 404 Not Found: If we want to report non-existent users
     * 
     * @param email The email of user to delete
     */
    @DeleteMapping("/{email}")
    @ResponseStatus(HttpStatus.NO_CONTENT)  // Returns 204 No Content
    fun deleteByEmail(@PathVariable email: String) {
        users.remove(email)
        // No return value = HTTP 204 No Content
    }

    // ============================================================
    // BONUS: UPDATE OPERATION (Bonus Task)
    // ============================================================

    /**
     * PUT /users/{email} - Update existing user
     * 
     * @PutMapping:
     * - Maps HTTP PUT requests to this method
     * - Example: PUT /users/ximena@email.com
     * - Used for updating existing resources
     * 
     * HTTP SEMANTICS:
     * - PUT means replace the entire resource
     * - Client must send complete user data
     * - Partial updates should use PATCH (not implemented here)
     * 
     * ERROR HANDLING:
     * - Returns 404 if user doesn't exist
     * - Returns 200 OK with updated user on success
     * 
     * @param email The email from URL path
     * @param user The updated user data from request body
     * @return The updated user
     * @throws ResponseStatusException with 404 if user not found
     */
    @PutMapping("/{email}")
    fun updateUser(
        @PathVariable email: String,
        @Valid @RequestBody user: User
    ): User {
        // Check if user exists
        if (!users.containsKey(email)) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "User with email '$email' not found"
            )
        }
        
        // Update the user
        // Note: If the request body has a different email, 
        // we use the URL email as the key
        users[email] = user.copy(email = email)
        return users[email]!!
    }

    /**
     * GET /users/health - Health check endpoint
     * Useful for monitoring and load balancers
     * 
     * @return Health status message
     */
    @GetMapping("/health")
    fun health(): String {
        return "Users API is running! Total users: ${users.size}"
    }
}

/**
 * SUMMARY OF HTTP METHODS AND ANNOTATIONS:
 * 
 * HTTP METHOD | ANNOTATION        | PURPOSE
 * ------------|-------------------|-----------------------------------
 * GET         | @GetMapping       | Retrieve data
 * POST        | @PostMapping      | Create new resource
 * PUT         | @PutMapping       | Update existing resource
 * DELETE      | @DeleteMapping    | Delete resource
 * 
 * PARAMETER ANNOTATIONS:
 * - @PathVariable: Extract values from URL path (/users/{email})
 * - @RequestBody: Bind JSON request body to object
 * - @Valid: Trigger validation on the object
 * 
 * RESPONSE STATUS CODES:
 * - 200 OK: Success
 * - 201 Created: Resource created (can be used for POST)
 * - 204 No Content: Success with no body (good for DELETE)
 * - 400 Bad Request: Validation error
 * - 404 Not Found: Resource not found
 */
