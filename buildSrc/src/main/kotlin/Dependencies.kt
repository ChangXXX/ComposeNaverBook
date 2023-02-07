object Dependencies {
    const val FirebaseBom = "com.google.firebase:firebase-bom:${Versions.FirebaseBom}"

    val Firebase = listOf(
        "com.google.firebase:firebase-firestore-ktx"
    )

    val Essential = listOf(
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Essential.Coroutines}"
    )

    val Ktx = listOf(
        "androidx.core:core-ktx:${Versions.Ktx.Core}",
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.Ktx.LifeCycle}",
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Ktx.ViewModel}",
    )

    val Ui = listOf(
        "androidx.appcompat:appcompat:${Versions.Ui.AppCompat}"
    )

    val Compose = listOf(
        "androidx.compose.ui:ui:${Versions.Ui.Compose}",
        "androidx.compose.ui:ui-tooling:${Versions.Ui.Compose}",
        "androidx.compose.runtime:runtime:${Versions.Ui.Compose}",
        "androidx.compose.animation:animation:${Versions.Ui.Compose}",
        "androidx.compose.foundation:foundation:${Versions.Ui.Foundation}",
        "androidx.activity:activity-compose:${Versions.Ui.ActivityCompose}",
        "androidx.compose.material:material:${Versions.Ui.Material}",
        "androidx.compose.material:material-icons-extended:${Versions.Ui.Material}",
        "androidx.compose.material3:material3:${Versions.Ui.Material3}",
        "androidx.compose.material3:material3-window-size-class:${Versions.Ui.Material3}",
        "androidx.navigation:navigation-compose:${Versions.Ui.Navigation}",
        "androidx.hilt:hilt-navigation-compose:${Versions.Ui.ComposeHiltNavigation}"
    )

    val Util = listOf(
        "com.kakao.sdk:v2-user:${Versions.Kakao}",
        "com.github.bumptech.glide:compose:${Versions.Util.Glide}"
    )

    val Jetpack = listOf(
        "androidx.room:room-ktx:${Versions.Jetpack.Room}",
        "com.google.dagger:hilt-android:${Versions.Jetpack.Hilt}"
    )

    val Compiler = listOf(
        "androidx.room:room-compiler:${Versions.Jetpack.Room}",
//        "com.github.bumptech.glide:compiler:${Versions.Util.Glide}",
        "com.google.dagger:hilt-android-compiler:${Versions.Jetpack.Hilt}",
        "androidx.compose.compiler:compiler:${Versions.Ui.Compose}"
    )

    val Debug = listOf(
        "com.squareup.leakcanary:leakcanary-android:${Versions.Util.LeakCanary}"
    )
}
