import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.ktlint)
}

val properties = Properties().apply {
    val file = rootProject.file("local.properties")
    if (file.exists()) {
        load(file.inputStream())
    }
}

android {
    namespace = "dev.marcosfarias.pokedex"

    compileSdk {
        version = release(version = 36)
    }

    defaultConfig {
        applicationId = "dev.marcosfarias.pokedex"
        minSdk = 23
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    ktlint {
        android.set(true)
        ignoreFailures.set(true)
        reporters {
            reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.PLAIN)
            reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE) // Для отчетов в Jenkins/Gitlab
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    buildFeatures {
        android.buildFeatures.buildConfig = true
        viewBinding = true
    }

    signingConfigs {
        getByName("debug") {
            storeFile = file("pokemon_keystore.jks")
            storePassword = properties["KEY_STORE_PASSWORD"] as String?
            keyAlias = "key0"
            keyPassword = properties["KEY_PASSWORD"] as String?
        }

        create("release") {
            storeFile = file("pokemon_keystore.jks")
            storePassword = properties["KEY_STORE_PASSWORD"] as String?
            keyAlias = "key0"
            keyPassword = properties["KEY_PASSWORD"] as String?
        }
    }

    buildTypes {
        getByName("debug") {
            buildConfigField("String", "BASE_URL", "\"${properties["BASE_URL_DEBUG"]}\"")
            signingConfig = signingConfigs.getByName("debug")
            isMinifyEnabled = false
            isDebuggable = true
        }

        getByName("release") {
            buildConfigField("String", "BASE_URL", "\"${properties["BASE_URL_RELEASE"]}\"")
            signingConfig = signingConfigs.getByName("release")
            isMinifyEnabled = false
            isDebuggable = false

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    // AndroidX & UI
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.google.material)
    implementation(libs.bundles.navigation)
    implementation(libs.bundles.lifecycle)
    implementation(libs.ui.speed.dial)

    // Network & DI
    implementation(libs.bundles.retrofit)
    implementation(libs.koin.android)

    // Room
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    ksp(libs.room.compiler) // ПЕРЕШЛИ НА KSP

    // Glide
    implementation(libs.glide.core)
    ksp(libs.glide.compiler) // ПЕРЕШЛИ НА KSP

    // Testing
    testImplementation(libs.test.junit)
    testImplementation(libs.test.mockk)
    androidTestImplementation(libs.android.test.espresso)
}
