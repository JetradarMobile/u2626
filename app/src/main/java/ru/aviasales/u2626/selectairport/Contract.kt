package ru.aviasales.u2626.selectairport

import kotlinx.coroutines.flow.Flow
import ru.aviasales.core.autocomplete.model.City


data class SelectCityViewModel(
    val items: List<City>,
    val isLoading: Boolean
)

sealed class Action

data class QueryChanged(val query: String) : Action()

data class CitySelected(val city: City) : Action()

interface SelectCityView {
    fun bindTo(model: SelectCityViewModel)
    fun actions(): Flow<Action>
}

interface SelectCityPresenter {
    fun setView(view: SelectCityView)
    fun clearView()
}

interface SelectCityRouter {
    fun navigate(city: City)
}

interface SelectCityInteractor {
    suspend fun autocomplete(query: String): List<City>
}