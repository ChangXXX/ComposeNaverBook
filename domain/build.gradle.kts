plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    kotlin("kapt")
}

java {
    sourceCompatibility = Application.sourceCompat
    targetCompatibility = Application.targetCompat
}
