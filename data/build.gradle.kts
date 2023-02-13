plugins {
    id(Plugins.JavaLibrary)
    kotlin(Plugins.KotlinKapt)
}

java {
    sourceCompatibility = Application.sourceCompat
    targetCompatibility = Application.targetCompat
}
