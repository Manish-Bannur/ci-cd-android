// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    ext.kotlin_version = '1.9.21'
    repositories {
        google()
        mavenCentral()
        
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:7.4.2'
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        
    }
}

tasks.register('clean', Delete) {
    delete rootProject.buildDir
}
