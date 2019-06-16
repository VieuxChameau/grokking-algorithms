import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    var kotlin_version: String by extra
    kotlin_version = "1.3.31"

    repositories {
        mavenCentral()
    }
    dependencies {
        classpath(kotlin("gradle-plugin", version = kotlin_version))
    }
}

group = "org.vieuxchameau"
version = "1.0.0-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_12
java.targetCompatibility = JavaVersion.VERSION_12

plugins {
    kotlin("jvm") version "1.3.31"
}

val kotlin_version: String by extra

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.google.guava:guava:28.0-jre")
    val junit5Version = "5.2.0"
    testCompile("org.junit.jupiter", "junit-jupiter-api", junit5Version)
    testCompile("org.junit.jupiter", "junit-jupiter-engine", junit5Version)
    testCompile("org.junit.jupiter", "junit-jupiter-params", junit5Version)
    testCompile("org.assertj", "assertj-core", "3.12.2")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "12"
}