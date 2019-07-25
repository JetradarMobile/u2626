package ru.aviasales.u2626

import android.content.Context
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.plugins.network.FlipperOkhttpInterceptor
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber

object OkhttpClientInitializer {

    fun initInterceptors(context: Context, clientBuilder: OkHttpClient.Builder) {
        clientBuilder
            .addInterceptor(okHttpLoggingInterceptor())
            .addNetworkInterceptor(flipperOkHttpInterceptor(context))
    }

    private fun okHttpLoggingInterceptor(): Interceptor =
        HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                Timber.tag("OkHttp").d(message)
            }
        }).apply { level = HttpLoggingInterceptor.Level.BASIC }

    private fun flipperOkHttpInterceptor(context: Context): Interceptor =
        FlipperOkhttpInterceptor(
            AndroidFlipperClient.getInstance(context).getPlugin(
                NetworkFlipperPlugin.ID
            )
        )
}
