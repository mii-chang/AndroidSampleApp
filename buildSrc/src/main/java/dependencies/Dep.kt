package dependencies

object Dep {

    object Kotlin {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.4.10"
        const val stdlib8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.4.10"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.9"
        const val coroutinesAndroid =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9"
    }

    object AndroidX {
        const val appcompat = "androidx.appcompat:appcompat:1.2.0"
        const val coreKtx = "androidx.core:core-ktx:1.3.2"
        const val material = "com.google.android.material:material:1.1.0"
        const val constraint = "androidx.constraintlayout:constraintlayout:2.0.2"
    }
}