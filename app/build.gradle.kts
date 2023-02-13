plugins {
    id(Plugins.AndroidApplication)
    kotlin(Plugins.KotlinAndroid)
    kotlin(Plugins.KotlinKapt)
    id(Plugins.HiltPlugin)
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

    implementation(project(":presentation"))
    implementation(project(":domain"))
    implementation(project(":data"))

    Dependencies.AndroidX.Activity.Bundle.forEach(::implementation)
    implementation(Dependencies.ThirdParty.Dagger.HiltAndroid)
    kapt(Dependencies.ThirdParty.Dagger.HiltCompiler)
    debugImplementation(Dependencies.ThirdParty.LeakCanary)
}
