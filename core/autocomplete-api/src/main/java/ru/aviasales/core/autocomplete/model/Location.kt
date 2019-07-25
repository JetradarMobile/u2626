package ru.aviasales.core.autocomplete.model

import com.squareup.moshi.Json

data class Location(
    @Json(name = "lat") val latitude: Double,
    @Json(name = "lon") val longitude: Double
)
