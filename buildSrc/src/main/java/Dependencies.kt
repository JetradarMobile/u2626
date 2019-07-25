object Configs {
    const val minSdkVersion = 21
    const val targetSdkVersion = 28
    const val compileSdkVersion = 28
    const val buildToolsVersion = "29.0.1"
}

object Versions {
    const val androidGradlePlugin = "3.5.0-rc02"
    const val googleServicesPlugin = "4.3.0"
    const val crashlyticsPlugin = "1.31.0"
    const val versionsGradlePlugin = "0.21.0"

    const val kotlin = "1.3.41"
    const val kotlinCoroutines = "1.3.0-RC"
    const val constraintLayout = "1.1.3"
    const val appCompat = "1.0.2"
    const val retrofit = "2.6.1"
    const val moshi = "1.8.0"
    const val rxJava = "2.2.10"
    const val dagger = "2.24"
    const val okHttp = "4.0.1"
    const val flipper = "0.23.4"
    const val soLoader = "0.6.1"
    const val leakCanary = "2.0-beta-1"
    const val timber = "4.7.1"
    const val firebaseCore = "17.0.1"
    const val crashlytics = "2.10.1"
}

object GradlePlugins {
    const val android = "com.android.tools.build:gradle:${Versions.androidGradlePlugin}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val googleServices = "com.google.gms:google-services:${Versions.googleServicesPlugin}"
    const val crashlytics = "io.fabric.tools:gradle:${Versions.crashlyticsPlugin}"
    const val versions = "com.github.ben-manes:gradle-versions-plugin:${Versions.versionsGradlePlugin}"
}

object Libraries {
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val kotlinCoroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}"
    val kotlinCoroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinCoroutines}"
    val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofitRxJavaAdapter = "com.squareup.retrofit2:adapter-rxjava:${Versions.retrofit}"
    val retrofitMoshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    val moshi = "com.squareup.moshi:moshi:${Versions.moshi}"
    val moshiKotlin = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxJava}"
    val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    val okHttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
    val flipper = "com.facebook.flipper:flipper:${Versions.flipper}"
    val soLoader = "com.facebook.soloader:soloader:${Versions.soLoader}"
    val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}"
    val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    val firebaseCore = "com.google.firebase:firebase-core:${Versions.firebaseCore}"
    val crashlytics = "com.crashlytics.sdk.android:crashlytics:${Versions.crashlytics}"
}
