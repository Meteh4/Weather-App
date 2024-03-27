plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.metoly.weather"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.metoly.weather"
        minSdk = 32
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    val koin_android_version = "3.4.0"
    val koin_android_compose_version = "3.4.4"
    val retrofit_version = "2.9.0"
    val nav_version = "2.6.0"

    // Koin
    implementation ("io.insert-koin:koin-android:$koin_android_version")
    implementation ("io.insert-koin:koin-androidx-compose:$koin_android_compose_version")

    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:$retrofit_version")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    // Coil
    implementation("io.coil-kt:coil-compose:2.4.0")

    // System Ui Controller
    implementation ("com.google.accompanist:accompanist-systemuicontroller:0.30.1")

    // Navigation
    implementation ("androidx.navigation:navigation-compose:$nav_version")

    implementation ("androidx.compose.material:material-icons-extended:1.4.3")
}