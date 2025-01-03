import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
}

val properties = Properties()
val propertiesFile = File("local.properties")
properties.load(propertiesFile.inputStream())

android {
    namespace = "com.example.kuit_4th_hackathon_team2_android"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.kuit_4th_hackathon_team2_android"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        val baseUrl = properties["BASE_URL"]?.toString() ?: "https://default-url.com/"
        buildConfigField("String", "BASE_URL", baseUrl)

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
    buildFeatures {
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    val room_version = "2.6.1"
    implementation("androidx.room:room-runtime:$room_version")
    kapt("androidx.room:room-compiler:$room_version")
    implementation("androidx.room:room-ktx:$room_version")

    val retrofit_version = "2.6.1"
// Retrofit 라이브러리
    implementation("com.squareup.retrofit2:retrofit:$retrofit_version")
// Gson Converter 라이브러리
    implementation("com.squareup.retrofit2:converter-gson:$retrofit_version")
// Scalars Converter 라이브러리
    implementation("com.squareup.retrofit2:converter-scalars:$retrofit_version")
}