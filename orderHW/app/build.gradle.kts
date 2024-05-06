plugins {
    alias(libs.plugins.androidApplication)
}

android {
<<<<<<<< HEAD:orderHW/app/build.gradle.kts
    namespace = "com.example.orderhw"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.orderhw"
========
    namespace = "com.example.tickethw"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.tickethw"
>>>>>>>> 3ad892ed46a52245ac9d2de1f15a90b953f6b10b:new_ticketHW/app/build.gradle.kts
        minSdk = 30
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
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

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}