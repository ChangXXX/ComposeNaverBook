import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    kotlin(Plugins.KotlinKapt)
    kotlin(Plugins.KotlinAndroid)
    id(Plugins.HiltPlugin)
    id(Plugins.AndroidLibrary)
}

android {

    namespace = "team.study.data"
    compileSdk = Application.compileSdk

    compileOptions {
        sourceCompatibility = Application.sourceCompat
        targetCompatibility = Application.targetCompat
    }

    kapt {
        correctErrorTypes = true
    }

    kotlinOptions {
        jvmTarget = Application.jvmTarget
    }

    val clientId = gradleLocalProperties(rootDir).getProperty("clientId")
    val apiKey = gradleLocalProperties(rootDir).getProperty("apiKey")

    defaultConfig {
        buildConfigField("String", "API_KEY", "\"$apiKey\"")
        buildConfigField("String", "CLIENT_ID", "\"$clientId\"")
    }
}

dependencies {

    implementation(project(":domain"))

    listOf(
        Dependencies.AndroidX.Core.CoreKtx,
        Dependencies.ThirdParty.Timber,
        Dependencies.AndroidX.DataStore.Preferences.DataStore,
        Dependencies.Kotlin.Coroutines.Core,
        Dependencies.Kotlin.Serialization,
    ).forEach(::implementation)

    Dependencies.ThirdParty.Network.Bundle.forEach(::implementation)

    implementation(Dependencies.ThirdParty.Dagger.HiltAndroid)
    kapt(Dependencies.ThirdParty.Dagger.HiltCompiler)
}
