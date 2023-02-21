plugins {
    id(Plugins.JavaLibrary)
    kotlin(Plugins.KotlinJvm)
}

java {
    sourceCompatibility = Application.sourceCompat
    targetCompatibility = Application.targetCompat
}

dependencies {

    implementation(Dependencies.Javax.Inject)
    implementation(Dependencies.Kotlin.Coroutines.Core)
}
