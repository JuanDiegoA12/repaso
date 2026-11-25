plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.repaso"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "com.example.repaso"
        minSdk = 24
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)
    implementation("androidx.navigation:navigation-compose:2.9.0")
    // Retrofit: permite realizar peticiones HTTP
    implementation("com.squareup.retrofit2:retrofit:2.11.0")

    // Gson: convierte JSON en objetos Kotlin y viceversa
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")

    // Permite utilizar ViewModel desde Jetpack Compose
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.9.0")

    // Permite utilizar corrutinas dentro del ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.9.0")

    // Permite observar StateFlow respetando el ciclo de vida
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.9.0")
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    debugImplementation(libs.androidx.compose.ui.tooling)
}