package ru.aviasales.u2626.selectairport

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import ru.aviasales.core.autocomplete.model.City
import timber.log.Timber
import java.lang.Exception


class SelectCityPresenterImpl(
    private val interactor: SelectCityInteractor,
    private val router: SelectCityRouter
) : ViewModel(), SelectCityPresenter {

    private val actionsChannel: BroadcastChannel<Action> = BroadcastChannel(Channel.BUFFERED)
    private val queryChannel: BroadcastChannel<String> = BroadcastChannel(Channel.BUFFERED)

    private var view: SelectCityView? = null
    private var receiveActionsJob: Job? = null

    init {
        //process input
        viewModelScope.launch {
            actionsChannel.consumeEach { action ->
                when (action) {
                    is CitySelected -> router.navigate(action.city)
                    is QueryChanged -> queryChannel.offer(action.query)
                }
            }
        }

        val progressChannel = ConflatedBroadcastChannel(false)
        val citiesFlow = queryChannel.asFlow()
            .debounce(200L)
            .switchMap {
                progressChannel.offer(true)
                val cities = try {
                    interactor.autocomplete(it)
                } catch (e: Exception) {
                    //TODO: wrap to express error
                    emptyList<City>()
                }
                progressChannel.offer(false)
                flowOf(cities)
            }

        //setup state
        citiesFlow
            .combineLatest(progressChannel.asFlow()) { cities, progress ->
                SelectCityViewModel(cities, progress)
            }
            .onStart { emit(SelectCityViewModel(emptyList(), false)) }
            .onEach { view?.bindTo(it) }
            .catch { Timber.e(it) }
            .launchIn(viewModelScope)
    }

    override fun setView(view: SelectCityView) {
        this.view = view
        //TODO: maybe there is a better way to pass actions
        //TODO: restore saved state
        receiveActionsJob = view.actions()
            .onEach { actionsChannel.offer(it) }
            .launchIn(viewModelScope)
    }

    override fun clearView() {
        view = null
        receiveActionsJob?.cancel()
        receiveActionsJob = null
    }
}