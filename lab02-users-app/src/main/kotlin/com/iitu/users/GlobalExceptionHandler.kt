package com.iitu.users

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.server.ResponseStatusException
import java.time.LocalDateTime

/**
 * BONUS TASK: Global Exception Handler
 * 
 * This class provides centralized exception handling for the entire application.
 * It catches exceptions thrown by controllers and formats them into consistent
 * error responses.
 * 
 * @RestControllerAdvice:
 * - Combines @ControllerAdvice and @ResponseBody
 * - Applies to all controllers in the application
 * - Allows global exception handling
 */
@RestControllerAdvice
class GlobalExceptionHandler {

    /**
     * Handle validation errors (when @Valid fails)
     * 
     * This method catches MethodArgumentNotValidException which is thrown
     * when request body validation fails (e.g., blank email, invalid format)
     * 
     * @param ex The validation exception
     * @return ResponseEntity with error details and 400 Bad Request status
     */
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationExceptions(ex: MethodArgumentNotValidException): ResponseEntity<Map<String, Any>> {
        // Collect all validation errors
        val errors = mutableMapOf<String, String?>()
        ex.bindingResult.allErrors.forEach { error ->
            val fieldName = (error as FieldError).field
            val errorMessage = error.defaultMessage
            errors[fieldName] = errorMessage
        }

        // Build error response
        val response = buildErrorResponse(
            status = HttpStatus.BAD_REQUEST.value(),
            error = "Validation Failed",
            message = "Input validation failed",
            details = errors
        )

        return ResponseEntity(response, HttpStatus.BAD_REQUEST)
    }

    /**
     * Handle ResponseStatusException (custom HTTP status errors)
     * 
     * This handles exceptions thrown with specific HTTP status codes
     * like our 404 Not Found for missing users
     * 
     * @param ex The response status exception
     * @return ResponseEntity with error details
     */
    @ExceptionHandler(ResponseStatusException::class)
    fun handleResponseStatusException(ex: ResponseStatusException): ResponseEntity<Map<String, Any>> {
        val response = buildErrorResponse(
            status = ex.statusCode.value(),
            error = ex.statusCode.toString(),
            message = ex.reason ?: "An error occurred"
        )

        return ResponseEntity(response, ex.statusCode as HttpStatus)
    }

    /**
     * Handle all other exceptions
     * 
     * This is a catch-all for unexpected errors
     * 
     * @param ex The exception
     * @return ResponseEntity with 500 Internal Server Error
     */
    @ExceptionHandler(Exception::class)
    fun handleAllExceptions(ex: Exception): ResponseEntity<Map<String, Any>> {
        val response = buildErrorResponse(
            status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
            error = "Internal Server Error",
            message = ex.message ?: "An unexpected error occurred"
        )

        return ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    /**
     * Helper method to build consistent error response
     * 
     * @param status HTTP status code
     * @param error Error type
     * @param message Error message
     * @param details Additional error details (optional)
     * @return Map containing error information
     */
    private fun buildErrorResponse(
        status: Int,
        error: String,
        message: String,
        details: Map<String, String?>? = null
    ): Map<String, Any> {
        val response = mutableMapOf<String, Any>(
            "timestamp" to LocalDateTime.now().toString(),
            "status" to status,
            "error" to error,
            "message" to message
        )
        
        details?.let { response["details"] = it }
        
        return response
    }
}
