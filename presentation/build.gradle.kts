import name.remal.gradle_plugins.dsl.extensions.flattenAny

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("name.remal.check-dependency-updates") version Versions.Util.CheckDependencyUpdates
}

android {
    namespace = "team.study.presentation"
    compileSdk = Application.compileSdk

    defaultConfig {
        minSdk = Application.minSdk
        targetSdk = Application.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = Application.sourceCompat
        targetCompatibility = Application.targetCompat
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Application.composeCompilerVersion
    }

    kotlinOptions {
        jvmTarget = Application.jvmTarget
    }
}

dependencies {

    val dependencies = listOf(
        Dependencies.Ui,
        Dependencies.Ktx,
        Dependencies.Util,
        Dependencies.Firebase,
        Dependencies.Essential,
        Dependencies.Jetpack,
        Dependencies.Compose,
        platform(Dependencies.FirebaseBom)
    ).flattenAny()

    dependencies.forEach(::implementation)
    Dependencies.Debug.forEach(::debugImplementation)

    Dependencies.Compiler.forEach(::kapt)
}

kapt {
    correctErrorTypes = true
}
