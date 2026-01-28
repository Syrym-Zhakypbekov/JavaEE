package com.iitu.student.hellospringboot

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

/**
 * Integration test for the Hello Spring Boot application.
 * 
 * @SpringBootTest loads the full application context for testing.
 * This ensures that the application starts up correctly.
 */
@SpringBootTest
class HelloSpringBootApplicationTests {

    @Test
    fun contextLoads() {
        // This test verifies that the Spring context loads successfully
        // If there are any configuration issues, this test will fail
    }
}
