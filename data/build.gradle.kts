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
}

dependencies {

    implementation(project(":domain"))

    listOf(
        Dependencies.AndroidX.Core.CoreKtx,
        Dependencies.ThirdParty.Timber,
        Dependencies.AndroidX.DataStore.Preferences.DataStore,
        Dependencies.Kotlin.Coroutines.Core,
    ).forEach(::implementation)

    implementation(Dependencies.ThirdParty.Dagger.HiltAndroid)
    kapt(Dependencies.ThirdParty.Dagger.HiltCompiler)
}
