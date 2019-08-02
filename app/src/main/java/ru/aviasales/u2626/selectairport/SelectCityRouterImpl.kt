package ru.aviasales.u2626.selectairport

import android.content.Context
import android.widget.Toast
import ru.aviasales.core.autocomplete.model.City


class SelectCityRouterImpl(private val context: Context) : SelectCityRouter {

    override fun navigate(city: City) {
        Toast.makeText(context, "Navigate ${city.fullName}", Toast.LENGTH_SHORT).show()
    }
}