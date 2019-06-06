import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    var kotlin_version: String by extra
    kotlin_version = "1.2.21"

    repositories {
        mavenCentral()
    }
    dependencies {
        classpath(kotlinModule("gradle-plugin", kotlin_version))
    }
}

group = "org.vieuxchameau"
version = "1.0.0-SNAPSHOT"

apply {
    plugin("kotlin")
}

val kotlin_version: String by extra

repositories {
    mavenCentral()
}

dependencies {
    compile(kotlinModule("stdlib-jdk8", kotlin_version))
    val junit5Version = "5.2.0"
    testCompile("org.junit.jupiter", "junit-jupiter-api", junit5Version)
    testCompile("org.junit.jupiter", "junit-jupiter-engine", junit5Version)
    testCompile("org.junit.jupiter", "junit-jupiter-params", junit5Version)
    testCompile("org.assertj", "assertj-core", "3.9.0")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}