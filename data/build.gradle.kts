plugins {
    kotlin(Plugins.KotlinKapt)
    kotlin(Plugins.KotlinAndroid)
    id(Plugins.HiltPlugin)
    id(Plugins.AndroidLibrary)
}

android {

    namespace = "team.study.data"
    compileSdk = Application.compileSdk
}

dependencies {

    listOf(
        Dependencies.ThirdParty.Timber,
        Dependencies.AndroidX.DataStore.Preferences.DataStore,
        Dependencies.Kotlin.Coroutines.Core,
    ).forEach(::implementation)

    implementation(Dependencies.ThirdParty.Dagger.HiltAndroid)
    kapt(Dependencies.ThirdParty.Dagger.HiltCompiler)
}
