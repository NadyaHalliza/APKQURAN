plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.alquran"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.ALQURAN"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        // ViewBinding
        buildConfigField("boolean", "VIEW_BINDING_ENABLED", "true")
    }

    buildFeatures {
        compose = true
        viewBinding = true
        buildConfig = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.12"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17

        kotlinOptions {
            jvmTarget = "17"
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
    }

    dependencies {
        val lifecycleVersion = "2.6.2"
        implementation("androidx.core:core-ktx:1.12.0")
        implementation("androidx.appcompat:appcompat:1.6.1")
        implementation("com.google.android.material:material:1.11.0")
        implementation("androidx.constraintlayout:constraintlayout:2.1.4")
        // RecyclerView
        implementation("androidx.recyclerview:recyclerview:1.3.2")
        // ViewModel & LiveData
        implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
        implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")
        // Retrofit & GSON
        implementation("com.squareup.retrofit2:retrofit:2.9.0")
        implementation("com.squareup.retrofit2:converter-gson:2.9.0")
        // OkHttp Logging
        implementation("com.squareup.okhttp3:logging-interceptor:4.9.3")
        // Coroutine
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
        // CardView
        implementation("androidx.cardview:cardview:1.0.0")
        implementation("androidx.activity:activity-ktx:1.7.2") // atau versi terbaru
        implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
        implementation("androidx.compose.ui:ui:1.5.4")
        implementation("androidx.compose.material:material:1.5.4")
        implementation("androidx.compose.ui:ui-tooling-preview:1.5.4")
        implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
        implementation("androidx.activity:activity-compose:1.8.0")
        // Google Sign In
        implementation("com.google.android.gms:play-services-auth:20.7.0")
        // DataStore
        implementation("androidx.datastore:datastore-preferences:1.0.0")
        // Lifecycle ViewModel
        implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
        implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")

        implementation("androidx.core:core-ktx:1.10.1")
        implementation("androidx.appcompat:appcompat:1.6.1")
        implementation("com.google.android.material:material:1.9.0")
        implementation("androidx.constraintlayout:constraintlayout:2.1.4")

        // Retrofit
        implementation("com.squareup.retrofit2:retrofit:2.9.0")
        implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    }
}
