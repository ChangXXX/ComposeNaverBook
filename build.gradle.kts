plugins {
    kotlin(Plugins.KotlinSerialization) version Versions.Kotlin.Kotlin apply false
    kotlin(Plugins.KotlinAndroid) version Versions.Kotlin.KotlinAndroid apply false
    kotlin(Plugins.KotlinKapt) version Versions.Kotlin.Kapt apply false
    kotlin(Plugins.KotlinJvm) version Versions.Kotlin.Kotlin apply false
    id(Plugins.AndroidApplication) version Versions.ThirdParty.AndroidGradle apply false
    id(Plugins.AndroidLibrary) version Versions.ThirdParty.AndroidGradle apply false
    id(Plugins.DaggerHilt) version Versions.ThirdParty.Dagger apply false
    id(Plugins.SecretsGradlePlugin) version Versions.ThirdParty.SecretsGradle apply false
}

buildscript {

    dependencies {
        classpath("${Plugins.AndroidGradlePlugin}:${Versions.ThirdParty.AndroidGradle}")
        classpath("${Plugins.KotlinGradlePlugin}:${Versions.Kotlin.Kotlin}")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
