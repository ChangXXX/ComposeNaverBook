plugins {
    id(Plugins.JavaLibrary)
    kotlin(Plugins.KotlinKapt)
}

java {
    sourceCompatibility = Application.sourceCompat
    targetCompatibility = Application.targetCompat
}

dependencies {

    listOf(
        Dependencies.AndroidX.DataStore.Preferences.Core,
        Dependencies.AndroidX.DataStore.Proto.Core,
    ).forEach(::implementation)
}
