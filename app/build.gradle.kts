plugins {
    id("com.android.application")
    id("kotlin-android")

}

android {
    compileSdk = 33

    defaultConfig {
        applicationId = "dev.idee.cicdandroid"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        //buildConfigField("String", "API_KEY", "8bc707ec970aa53d70ad42114e472e85")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
    namespace = "dev.idee.cicdandroid"

}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.9.21")
    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation("androidx.core:core-ktx:1.1.0")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation("com.google.android.material:material:1.0.0")
    implementation("androidx.lifecycle:lifecycle-extensions:2.1.0")
    implementation("com.squareup.retrofit2:retrofit:2.6.0")
    implementation("com.squareup.retrofit2:converter-gson:2.6.0")
    implementation("com.squareup.okhttp3:logging-interceptor:3.10.0")
    implementation("com.github.bumptech.glide:glide:4.9.0")
    
    testImplementation("junit:junit:4.12")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    androidTestImplementation("androidx.test:runner:1.5.2")
    androidTestImplementation("androidx.test:rules:1.5.0")
    androidTestImplementation("androidx.test:core:1.2.0")
    androidTestImplementation("androidx.arch.core:core-testing:2.1.0")
    androidTestImplementation("androidx.test.ext:junit:1.0.0")
    androidTestImplementation("androidx.test.ext:truth:1.0.0")

    androidTestImplementation("com.google.truth:truth:0.42")
    androidTestImplementation("androidx.arch.core:core-testing:2.1.0")

    implementation("com.google.guava:guava:26.0-android") {
        exclude(group = "com.google.guava", module = "listenablefuture")
    }
}
