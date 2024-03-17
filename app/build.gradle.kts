plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    // use JUnit5 for tests
    id("de.mannodermaus.android-junit5") version "1.10.0.0"
    jacoco
}

jacoco {
    toolVersion = "0.8.11"
}

tasks.register("generateJacocoTestReport") {
    dependsOn("testDebugUnitTest")
    dependsOn("createDebugCoverageReport")
}


//tasks.register("uploadCoverageToCodecov") {
//    doLast {
////        val codecovToken: String? = System.getenv("CODECOV_TOKEN")
//        val codecovToken: String = "60411876-3693-4fe8-9a1f-8245d9255c1a"
//        if (codecovToken != null) {
//            val processBuilder = ProcessBuilder(
//                "bash",
//                "-c",
//                "curl -s https://codecov.io/bash | bash -s -- -t $codecovToken"
//            )
//            processBuilder.directory(project.rootDir)
//            val process = processBuilder.start()
//            process.waitFor()
//            if (process.exitValue() != 0) {
//                throw GradleException("Failed to upload coverage to Codecov")
//            }
//        } else {
//            throw GradleException("CODECOV_TOKEN environment variable is not set")
//        }
//    }
//}
//tasks.named("check") {
//    dependsOn("uploadCoverageToCodecov")
//}

android {
    namespace = "com.aoeai.qg"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.aoeai.qg"
        minSdk = 21
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
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("debug") {
            testCoverage {
                enableUnitTestCoverage = true
                enableAndroidTestCoverage = true
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
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
    buildToolsVersion = "34.0.0"
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
    implementation(libs.androidx.navigation.compose)

    testImplementation(libs.assertj.core)
    testImplementation(libs.junit.jupiter.api)
    testRuntimeOnly(libs.junit.jupiter.engine)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)

    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}