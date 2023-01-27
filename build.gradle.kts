plugins {
    id("com.android.application") version "7.3.1" apply false
    id("com.android.library") version "7.3.1" apply false
    kotlin("android") version "1.5.31" apply false
    kotlin("kapt") version "1.7.20" apply false
    id("com.google.dagger.hilt.android") version Versions.Jetpack.Hilt apply false
    id("name.remal.check-dependency-updates") version Versions.Util.CheckDependencyUpdates
    id("org.jetbrains.kotlin.jvm") version "1.7.20" apply false
}

buildscript {
    dependencies {
        classpath("com.android.tools.build:gradle:7.2.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.Essential.Kotlin}")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
