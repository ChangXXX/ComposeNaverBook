object Dependencies {

    object Kotlin {

        object Coroutines {
            const val Core =
                "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Kotlin.Coroutines}"
            const val Android =
                "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Kotlin.Coroutines}"

            val Bundle = listOf(
                Coroutines.Core,
                Coroutines.Android
            )
            const val Test =
                "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.Kotlin.Coroutines}"
        }

        const val Serialization =
            "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.Kotlin.KotlinSerializationJson}"
    }

    object AndroidX {

        object Core {
            const val CoreKtx = "androidx.core:core-ktx:${Versions.AndroidX.Core}"
            const val Splash =  "androidx.core:core-splashscreen:${Versions.AndroidX.Splash}"

            val Bundle = listOf(
                Core.CoreKtx,
                Core.Splash
            )
        }
        const val Appcompat = "androidx.appcompat:appcompat:${Versions.AndroidX.Appcompat}"

        object Activity {
            const val Ktx = "androidx.activity:activity-ktx:${Versions.AndroidX.Activity}"
            const val Compose = "androidx.activity:activity-compose:${Versions.AndroidX.Activity}"

            val Bundle = listOf(
                Activity.Ktx,
                Activity.Compose
            )
        }

        object DataStore {

            object Preferences {
                const val Core = "androidx.datastore:datastore-preferences-core:${Versions.AndroidX.DataStore}"
                const val DataStore = "androidx.datastore:datastore-preferences:${Versions.AndroidX.DataStore}"

                val Bundle = listOf(
                    Preferences.Core,
                    Preferences.DataStore
                )
            }
        }

        object Compose {
            const val Bom = "androidx.compose:compose-bom:${Versions.AndroidX.Compose.ComposeBom}"
            const val HiltComposeNavigation =
                "androidx.hilt:hilt-navigation-compose:${Versions.AndroidX.ComposeHiltNavigation}"
            const val NavigationCompose =
                "androidx.navigation:navigation-compose:${Versions.AndroidX.Navigation}"

            val Bundle = listOf(
                "androidx.compose.ui:ui",
                "androidx.compose.ui:ui-tooling-preview",
                "androidx.activity:activity-compose",
                "androidx.compose.animation:animation",
                "androidx.compose.foundation:foundation",
                "androidx.compose.runtime:runtime",
                "androidx.compose.runtime:runtime-livedata",
                "androidx.compose.material:material-icons-core",
                "androidx.compose.material:material-icons-extended",
                "androidx.compose.material3:material3",
                "androidx.compose.material3:material3-window-size-class",
            )

            val Debug = listOf(
                "androidx.compose.ui:ui-tooling",
                //"androidx.compose.ui:ui-test-manifest"
            )
        }

        object Room {
            const val Runtime = "androidx.room:room-runtime:${Versions.AndroidX.Room}"
            const val Compiler = "androidx.room:room-compiler:${Versions.AndroidX.Room}"
            const val Ktx = "androidx.room:room-ktx:${Versions.AndroidX.Room}"

            val Bundle = listOf(
                Room.Runtime,
                Room.Ktx
            )
        }

        object Lifecycle {
            const val ViewModel =
                "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.AndroidX.Lifecycle}"
            const val ViewModelCompose =
                "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.AndroidX.Lifecycle}"
            const val RuntimeTesting =
                "androidx.lifecycle:lifecycle-runtime-testing:${Versions.AndroidX.Lifecycle}"

            val Bundle = listOf(
                Lifecycle.ViewModel,
                Lifecycle.ViewModelCompose
            )

            val Test = listOf(
                Lifecycle.RuntimeTesting
            )
        }
    }

    object Google {
        const val Ksp = "com.google.devtools.ksp:symbol-processing-api:${Versions.Google.Ksp}"
        const val Mateiral = "com.google.android.material:material:${Versions.Google.Material}"
    }

    object ThirdParty {

        object Coil {
            const val Core = "io.coil-kt:coil:${Versions.ThirdParty.Coil}"
            const val Compose = "io.coil-kt:coil-compose:${Versions.ThirdParty.Coil}"

            val Bundle = listOf(
                Coil.Core,
                Coil.Compose
            )
        }

        object Dagger {
            const val HiltAndroid = "com.google.dagger:hilt-android:${Versions.ThirdParty.Dagger}"
            const val HiltCompiler =
                "com.google.dagger:hilt-android-compiler:${Versions.ThirdParty.Dagger}"
        }

        const val Timber = "com.jakewharton.timber:timber:${Versions.ThirdParty.Timber}"

        const val LeakCanary =
            "com.squareup.leakcanary:leakcanary-android:${Versions.ThirdParty.LeakCanary}"
    }
}
