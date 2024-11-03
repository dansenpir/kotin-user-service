plugins {
    kotlin("jvm") version "2.0.20"
}

group = "com.concorde"
version = "0.0.1"
description = "Authentication and Authorization"

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:2.0.20")
    implementation("org.jetbrains.kotlin:kotlin-reflect:2.0.20")

    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5:2.0.20")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "21"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}