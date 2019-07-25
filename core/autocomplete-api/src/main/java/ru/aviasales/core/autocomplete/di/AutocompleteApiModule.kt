package ru.aviasales.core.autocomplete.di

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import ru.aviasales.core.autocomplete.AutocompleteApi
import javax.inject.Singleton

@Module
object AutocompleteApiModule {

    @JvmStatic
    @Provides
    @Singleton
    fun provideAutocompleteApi(client: OkHttpClient, moshi: Moshi): AutocompleteApi =
        Retrofit.Builder()
            .baseUrl(AutocompleteApi.BASE_URL)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create()
}
