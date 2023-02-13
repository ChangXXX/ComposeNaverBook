import org.gradle.api.JavaVersion

object Application {
    const val minSdk = 26
    const val targetSdk = 33
    const val compileSdk = 33
    const val jvmTarget = "1.8"
    const val versionCode = 1
    const val versionName = "1.0.0"
    const val composeCompilerVersion = "1.4.0"
    const val buildGradleVersion = "30.0.3"

    val targetCompat = JavaVersion.VERSION_1_8
    val sourceCompat = JavaVersion.VERSION_1_8
}
