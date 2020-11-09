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
        const val roomRunTime = "androidx.room:room-runtime:2.2.5"
        const val roomCompiler = "androidx.room:room-compiler:2.2.5"
        const val roomKtx = "androidx.room:room-ktx:2.2.5"
        const val paging = "androidx.paging:paging-runtime:2.1.2"
        const val fragmentKtx = "androidx.fragment:fragment-ktx:1.2.5"
        const val viewmodelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0"
        const val livedataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:2.2.0"
        const val lifecycleCommonJava = "androidx.lifecycle:lifecycle-common-java8:2.2.0"
        const val swiperefreshlayout = "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"
        const val bronwser = "androidx.browser:browser:1.2.0"
    }
    object DaggerHilt {
        const val core = "com.google.dagger:hilt-android:2.28-alpha"
        const val compiler = "com.google.dagger:hilt-android-compiler:2.28-alpha"
        const val viewModel = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha01"
        const val kotlin = "androidx.hilt:hilt-compiler:1.0.0-alpha01"
    }
    object OkHttp {
        const val core = "com.squareup.okhttp3:okhttp:4.9.0"
        const val logging = "com.squareup.okhttp3:logging-interceptor:4.9.0"
    }

    object Retrofit {
        const val core = "com.squareup.retrofit2:retrofit:2.9.0"
        const val converterMoshi = "com.squareup.retrofit2:converter-moshi:2.9.0"
    }

    object Moshi {
        const val core = "com.squareup.moshi:moshi:1.11.0"
        const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:1.11.0"
        const val kotlinCodegen = "com.squareup.moshi:moshi-kotlin-codegen:1.11.0"
    }
}