import dependencies.Dep
import dependencies.Versions
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}
tasks.withType<KotlinCompile> {
    sourceCompatibility = "1.8"
    targetCompatibility = "1.8"
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

android {
    compileSdkVersion(Versions.androidCompileSdkVersion)

    defaultConfig {
        applicationId = "com.miichang.androidsampleapp"
        minSdkVersion(Versions.androidMinSdkVersion)
        targetSdkVersion(Versions.androidTargetSdkVersion)
        versionCode = Versions.versionCode
        versionName = Versions.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    }
    flavorDimensions("version")
    productFlavors {
        create("demo") {
            buildConfigField("String", "API_URL", "\"https://qiita.com/api/v2/\"")
        }
    }
    buildFeatures {
        dataBinding = true
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(Dep.Kotlin.stdlib)
    implementation(Dep.Kotlin.stdlib8)
    implementation(Dep.AndroidX.coreKtx)
    implementation(Dep.AndroidX.appcompat)
    implementation(Dep.AndroidX.material)
    implementation(Dep.AndroidX.constraint)
    implementation(Dep.AndroidX.fragmentKtx)
    implementation(Dep.AndroidX.viewmodelKtx)
    implementation(Dep.AndroidX.livedataKtx)
    implementation(Dep.AndroidX.lifecycleCommonJava)
    implementation(Dep.AndroidX.roomRunTime)
    implementation(Dep.AndroidX.roomKtx)
    kapt(Dep.AndroidX.roomCompiler)
    implementation(Dep.AndroidX.swiperefreshlayout)
    implementation(Dep.AndroidX.bronwser)
    implementation(Dep.DaggerHilt.core)
    kapt(Dep.DaggerHilt.compiler)
    implementation(Dep.DaggerHilt.viewModel)
    kapt(Dep.DaggerHilt.kotlin)
    implementation(Dep.AndroidX.paging)
    implementation(Dep.Moshi.core)
    kapt(Dep.Moshi.kotlinCodegen)
    implementation(Dep.Moshi.moshiKotlin)
    implementation(Dep.Retrofit.core)
    implementation(Dep.Retrofit.converterMoshi)
    implementation(Dep.OkHttp.core)
    implementation(Dep.OkHttp.logging)
}