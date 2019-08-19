package ru.aviasales.u2626.di

import android.app.Application
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.brotli.BrotliInterceptor
import ru.aviasales.u2626.OkhttpClientInitializer
import java.io.File
import javax.inject.Singleton

@Module
object NetworkModule {
    private const val DISK_CACHE_SIZE = 10L * 1024 * 1024 // 10MB

    @JvmStatic
    @Provides
    @Singleton
    fun provideOkHttpClient(app: Application): OkHttpClient =
        OkHttpClient.Builder()
            .cache(httpCache(app))
            .addInterceptor(BrotliInterceptor)
            .apply { OkhttpClientInitializer.initInterceptors(app, this) }
            .build()

    private fun httpCache(app: Application): Cache {
        val cacheDir = File(app.cacheDir, "http")
        return Cache(cacheDir, DISK_CACHE_SIZE)
    }
}
