object Configs {
    const val minSdkVersion = 21
    const val targetSdkVersion = 28
    const val compileSdkVersion = 28
    const val buildToolsVersion = "29.0.2"
}

object Versions {
    const val androidGradlePlugin = "3.5.0"
    const val googleServicesPlugin = "4.3.0"
    const val crashlyticsPlugin = "1.31.0"
    const val versionsGradlePlugin = "0.22.0"

    const val kotlin = "1.3.50"
    const val kotlinCoroutines = "1.3.0"
    const val constraintLayout = "1.1.3"
    const val appCompat = "1.0.2"
    const val lifecycleRuntimeKtx = "2.2.0-alpha02"
    const val retrofit = "2.6.1"
    const val moshi = "1.8.0"
    const val rxJava = "2.2.10"
    const val dagger = "2.24"
    const val okHttp = "4.1.0"
    const val flipper = "0.23.4"
    const val soLoader = "0.7.0"
    const val leakCanary = "2.0-beta-1"
    const val timber = "4.7.1"
    const val firebaseCore = "17.1.0"
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
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val kotlinCoroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}"
    const val kotlinCoroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinCoroutines}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntimeKtx}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitRxJavaAdapter = "com.squareup.retrofit2:adapter-rxjava:${Versions.retrofit}"
    const val retrofitMoshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val moshi = "com.squareup.moshi:moshi:${Versions.moshi}"
    const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    const val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxJava}"
    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val okHttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
    const val flipper = "com.facebook.flipper:flipper:${Versions.flipper}"
    const val soLoader = "com.facebook.soloader:soloader:${Versions.soLoader}"
    const val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    const val firebaseCore = "com.google.firebase:firebase-core:${Versions.firebaseCore}"
    const val crashlytics = "com.crashlytics.sdk.android:crashlytics:${Versions.crashlytics}"
}
