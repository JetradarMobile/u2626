package ru.aviasales.core.autocomplete.model

import com.squareup.moshi.Json

data class City(
    @Json(name = "fullname") val fullName: String,
    val location: Location
)
