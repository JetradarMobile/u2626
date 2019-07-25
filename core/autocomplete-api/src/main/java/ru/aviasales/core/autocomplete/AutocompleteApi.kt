package ru.aviasales.core.autocomplete

import retrofit2.http.GET
import retrofit2.http.Query
import ru.aviasales.core.autocomplete.model.AutocompleteResponse

interface AutocompleteApi {

    @GET("autocomplete")
    suspend fun autocomplete(
        @Query("term") term: String,
        @Query("lang") lang: String
    ): AutocompleteResponse

    companion object {
        const val BASE_URL = "https://yasen.hotellook.com/"
    }
}
