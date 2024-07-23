plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.dagger.hilt)
    alias(libs.plugins.google.services)
    alias(libs.plugins.kotlin.parcelize)
    id("kotlin-kapt")

}

android {
    namespace = "com.lucas.whitelabelapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.lucas.whitelabelapp"
        minSdk = 24
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
    buildFeatures {
        buildConfig = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    viewBinding {
        enable = true
    }
    flavorDimensions += listOf<String>("product","sidePersona")

    productFlavors {
        create("bike") {
            dimension = "product"
            applicationIdSuffix = ".bike"
            manifestPlaceholders["appName"] = "Bike"
            buildConfigField("String", "FIREBASE_FLAVOR_COLLECTION", "\"bike\"")
        }
        create("car"){
            dimension = "product"
            applicationIdSuffix = ".car"
            manifestPlaceholders["appName"] = "Car"
            buildConfigField("String", "FIREBASE_FLAVOR_COLLECTION", "\"car\"")

        }
        create("client"){
            dimension = "sidePersona"
            manifestPlaceholders["appNameSuffix"] = ""
        }
        create("admin"){
            dimension = "sidePersona"
            applicationIdSuffix = ".admin"
            manifestPlaceholders["appNameSuffix"] = ".Admin"
        }
    }
    packaging {
        resources {
            excludes.add("META-INF/gradle/incremental.annotation.processors")
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.runtime.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)
    //firebase
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.firestore.ktx)
    implementation(libs.firebase.storage.ktx)

    // dagger-hilt
    implementation(libs.dagger.hilt)
    kapt(libs.hilt.compiler)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}