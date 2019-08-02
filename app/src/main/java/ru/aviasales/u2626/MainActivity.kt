package ru.aviasales.u2626

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import ru.aviasales.core.autocomplete.AutocompleteApi
import ru.aviasales.u2626.selectairport.SelectAirportFragment
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject lateinit var autocompleteApi: AutocompleteApi
    private val coroutineScope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependencies()
        setContentView(R.layout.activity_main)
        coroutineScope.launch { autocomplete("mow") }

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, SelectAirportFragment.create())
            commit()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        coroutineScope.cancel()
    }

    private fun injectDependencies() {
        App.from(this).appComponent.inject(this)
    }

    private suspend fun autocomplete(term: String) {
        try {
            val response = autocompleteApi.autocomplete(term, "ru")
            Timber.d(response.cities.joinToString(separator = "\n"))
        } catch (error: Throwable) {
            Timber.e(error, "Failed to execute autocomplete request")
        }
    }

    /*
    private fun autocomplete(term: String) =
        flow { emit(autocompleteApi.autocomplete(term, "ru")) }
            .flowOn(Dispatchers.IO)
            .onEach { response -> Timber.d(response.cities.joinToString(separator = "\n")) }
            .catch { error -> Timber.e(error, "Failed to execute autocomplete request") }
     */
}
