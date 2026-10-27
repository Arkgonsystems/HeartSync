plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.arkgon.heartsync"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.arkgon.heartsync"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0.0"
    }
    buildFeatures { compose = true }
}
