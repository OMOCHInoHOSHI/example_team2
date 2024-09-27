plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)

    // Pythonの導入により追加
    id("com.chaquo.python")
}

android {
    namespace = "com.example.example"
    compileSdk = 34
    // Pytnonにより追加
    flavorDimensions += "pyVersion"
    productFlavors{
        create("py312"){dimension = "pyVersion"}
    }

    defaultConfig {
        // Pythonにより追加
        ndk{
            abiFilters += listOf("arm64-v8a", "x86_64")
        }

        applicationId = "com.example.example"
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

// Pythonにより追加
chaquopy{
    defaultConfig{
        buildPython("C:/Python/Python3/python.exe")
        version = "3.12"
    }
    productFlavors{
        getByName("py312"){version = "3.12"}
    }
    sourceSets{ }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}