plugins {
    kotlin("jvm") version "2.0.21"
}

group = "com.concorde"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":core"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib:2.0.20")
    implementation("org.jetbrains.kotlin:kotlin-reflect:2.0.20")

    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5:2.0.20")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}