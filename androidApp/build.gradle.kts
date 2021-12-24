plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = 31
    defaultConfig {
        applicationId = "com.kmm.playground.appcomponents.android"
        minSdk = 21
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.appcompat:appcompat:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.2")

    // DI
    implementation("io.insert-koin:koin-core:3.1.4")
    implementation("io.insert-koin:koin-android:3.1.4")

    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0")

    implementation("androidx.core:core-ktx:1.7.0")
//    implementation("androidx.fragment:fragment-ktx:1.3.6")
}