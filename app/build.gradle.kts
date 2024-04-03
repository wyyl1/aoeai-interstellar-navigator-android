import com.android.build.gradle.internal.api.ApkVariantOutputImpl

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

tasks.withType<Test> {
    extensions.configure<JacocoTaskExtension> {}
}

tasks.withType<JacocoReport> {
    executionData.setFrom(fileTree(mapOf("dir" to "${project.layout.buildDirectory.get().asFile}", "includes" to listOf("jacoco/test.exec"))))
    reports {
        html
        xml
    }
}

tasks.register<JacocoReport>("jacocoTestReport") {
    group = "Verification"
    description = "Generates Jacoco coverage reports after running tests."

    dependsOn("test")
    dependsOn("createDebugCoverageReport")

    val debugTree = fileTree(mapOf("dir" to "${project.layout.buildDirectory.get().asFile}/tmp/kotlin-classes/debug"))
    val mainSrc = "${project.projectDir}/src/main/java"

    classDirectories.setFrom(files(debugTree))
    sourceDirectories.setFrom(files(mainSrc))
    executionData.setFrom(fileTree(mapOf("dir" to "${project.layout.buildDirectory.get().asFile}", "includes" to listOf("jacoco/test.exec"))))

    doLast {
        println("View coverage report at file://${reports.html.outputLocation.get().asFile}/index.html")
    }
}

android {
    namespace = "com.aoeai.qg"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.aoeai.qg"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
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

    applicationVariants.all {
        val variant = this
        variant.outputs.all {
            val output = this as ApkVariantOutputImpl
            output.outputFileName = "qigua-${variant.versionName}-${variant.buildType.name}.apk"
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
    implementation(libs.androidx.navigation.compose)

    testImplementation(libs.assertj.core)
    testImplementation(libs.junit.jupiter.api)
    testImplementation(libs.junit.jupiter)
    testRuntimeOnly(libs.junit.jupiter.engine)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)

    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}