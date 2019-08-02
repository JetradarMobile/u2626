package ru.aviasales.u2626.selectairport

import ru.aviasales.core.autocomplete.AutocompleteApi
import ru.aviasales.core.autocomplete.model.City


class SelectCityInteractorImpl(
    private val autocompleteApi: AutocompleteApi
) : SelectCityInteractor {

    override suspend fun autocomplete(query: String): List<City> =
        autocompleteApi.autocomplete(query, "ru").cities
}