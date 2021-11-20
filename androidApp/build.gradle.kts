import KotlinPlugins.kapt

plugins {
    id(Plugins.androidApplication)
    kotlin(KotlinPlugins.android)
    kotlin(KotlinPlugins.kapt)
    id(Plugins.hilt)
    kotlin(KotlinPlugins.serialization) version Kotlin.version
}



android {
    compileSdkVersion(31)
    defaultConfig {
        applicationId = Application.appId
        minSdkVersion(Application.minSdkVersion)
        targetSdkVersion(Application.targetSdk)
        versionCode = Application.versionCode
        versionName = Application.versionName
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        compose = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        useIR = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Compose.composeVersion
    }
}

dependencies {
    implementation(project(":shared"))

    addAndroidXDependencies()

    addNetworkAndroidDependencies()
    addComposeDependencies()

    addHiltDependencies()

    addTestingDependencies()
}