plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("kotlin-allopen")
}

android {
    compileSdk = 30
    buildToolsVersion = "30.0.3"

    defaultConfig {
        applicationId = "com.example.composeapp"
        minSdk = 23
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            buildConfigField("String", "restApiServer", "\"http://google.com/api/\"")
        }
        release {
            buildConfigField("String", "restApiServer", "\"http://google.com/api/\"")

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
        useIR = true
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = rootProject.extra["compose_version"] as String
//        kotlinCompilerVersion = "1.4.32"
    }

    packagingOptions {
        resources.excludes += "META-INF/AL2.0"
        resources.excludes += "META-INF/LGPL2.1"
    }
}

kapt {
    javacOptions {
        option("-Xmaxerrs", 1000)
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.6.0")
    implementation("androidx.appcompat:appcompat:1.3.0")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.compose.ui:ui:${rootProject.extra["compose_version"]}")
    implementation("androidx.compose.material:material:${rootProject.extra["compose_version"]}")
    implementation("androidx.compose.ui:ui-tooling:${rootProject.extra["compose_version"]}")

    implementation("androidx.activity:activity-compose:1.3.0-rc01")
    implementation("androidx.activity:activity-ktx:1.3.0-rc01")
    implementation("androidx.navigation:navigation-compose:2.4.0-alpha04")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:${rootProject.extra["compose_version"]}")


    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-common-java8:2.3.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
    implementation("androidx.lifecycle:lifecycle-reactivestreams-ktx:2.3.1")

    implementation("com.google.dagger:dagger:${rootProject.extra["dagger_version"]}")
    implementation("com.google.dagger:dagger-android:${rootProject.extra["dagger_version"]}")
    implementation("com.google.dagger:dagger-android-support:${rootProject.extra["dagger_version"]}")
    annotationProcessor("com.google.dagger:dagger-android-processor:${rootProject.extra["dagger_version"]}")
    kapt("com.google.dagger:dagger-compiler:${rootProject.extra["dagger_version"]}")
    kapt("com.google.dagger:dagger-android-processor:${rootProject.extra["dagger_version"]}")

    implementation("androidx.multidex:multidex:2.0.1")
    implementation("com.github.bumptech.glide:glide:4.12.0")
    implementation("com.github.bumptech.glide:annotations:4.12.0")
    kapt("com.github.bumptech.glide:compiler:4.12.0")

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.2")
    implementation("com.squareup.okhttp3:okhttp-urlconnection:5.0.0-alpha.2")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")

    implementation("com.jakewharton.timber:timber:4.7.1")
    implementation("com.orhanobut:logger:2.2.0")
}