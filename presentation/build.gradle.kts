plugins {
    kotlin(Plugins.KotlinAndroid)
    kotlin(Plugins.KotlinKapt)
    id(Plugins.DaggerHilt)
    id(Plugins.AndroidLibrary)
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
        kotlinCompilerExtensionVersion = Versions.AndroidX.Compose.Compiler
    }

    kapt {
        correctErrorTypes = true
    }

    kotlinOptions {
        jvmTarget = Application.jvmTarget
    }
}

dependencies {

    implementation(project(":data"))
    implementation(project(":domain"))

    val composeBom = platform(Dependencies.AndroidX.Compose.Bom)
    implementation(composeBom)
    androidTestImplementation(composeBom)
    Dependencies.AndroidX.Compose.Bundle.forEach(::implementation)
    Dependencies.AndroidX.Compose.Debug.forEach(::debugImplementation)

    listOf(
        Dependencies.AndroidX.Appcompat,
        Dependencies.Google.Ksp,
        Dependencies.Google.SystemUiController,
        Dependencies.ThirdParty.Timber,
        Dependencies.AndroidX.Compose.NavigationCompose,
        Dependencies.AndroidX.Compose.HiltComposeNavigation,
    ).forEach(::implementation)

    Dependencies.AndroidX.Core.Bundle.forEach(::implementation)
    Dependencies.AndroidX.Activity.Bundle.forEach(::implementation)
    Dependencies.AndroidX.Lifecycle.Bundle.forEach(::implementation)
    Dependencies.AndroidX.Lifecycle.Test.forEach(::testImplementation)
    Dependencies.AndroidX.DataStore.Preferences.Bundle.forEach(::implementation)
    Dependencies.Kotlin.Coroutines.Bundle.forEach(::implementation)
    Dependencies.ThirdParty.Coil.Bundle.forEach(::implementation)

    implementation(Dependencies.ThirdParty.Dagger.HiltAndroid)
    kapt(Dependencies.ThirdParty.Dagger.HiltCompiler)
}
