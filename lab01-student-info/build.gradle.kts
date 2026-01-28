plugins {
    kotlin("jvm") version "1.9.23"
    kotlin("plugin.spring") version "1.9.23"
    id("org.springframework.boot") version "3.2.5"
    id("io.spring.dependency-management") version "1.1.4"
}

group = "com.iitu.webdev"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    // Spring Boot Starter Web - provides web development support
    // Includes: Spring MVC, embedded Tomcat, JSON serialization
    implementation("org.springframework.boot:spring-boot-starter-web")
    
    // Spring Boot DevTools - provides automatic restart during development
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    
    // Kotlin support for Jackson (JSON serialization/deserialization)
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    
    // Kotlin reflection support
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    
    // Testing dependencies
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}
