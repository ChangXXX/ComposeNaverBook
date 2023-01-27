plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "team.study.composenavermovie"
    compileSdk = Application.compileSdk
    buildToolsVersion = Application.buildGradleVersion

    defaultConfig {
        minSdk = Application.minSdk
        targetSdk = Application.targetSdk
        versionCode = Application.versionCode
        versionName = Application.versionName
        multiDexEnabled = true
    }

    buildTypes {
        release {
            isDebuggable = false
            isMinifyEnabled = true
        }
    }

    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin")
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

    implementation(project(":presentation"))
    implementation(project(":domain"))

    Dependencies.Compose.forEach(::implementation)
    Dependencies.Compiler.forEach(::kapt)
    Dependencies.Jetpack.forEach(::implementation)
}

kapt {

    correctErrorTypes = true
}
