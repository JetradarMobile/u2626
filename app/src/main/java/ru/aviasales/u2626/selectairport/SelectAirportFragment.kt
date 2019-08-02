package ru.aviasales.u2626.selectairport

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import kotlinx.android.synthetic.main.fragment_select_airport.*
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import ru.aviasales.core.autocomplete.AutocompleteApi
import ru.aviasales.u2626.R


class SelectAirportFragment : Fragment(), SelectCityView {

    //TODO: inject. This will crash only in case of process death
    private lateinit var autocompleteApi: AutocompleteApi

    private val actionsChannel: BroadcastChannel<Action> = BroadcastChannel(Channel.CONFLATED)
    private val adapter by lazy { CityAdapter { city -> actionsChannel.offer(CitySelected(city)) } }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_select_airport, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView.adapter = adapter
        queryView.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                actionsChannel.offer(QueryChanged(queryView.text.toString()))
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
        connectPresenter()
    }

    override fun bindTo(model: SelectCityViewModel) {
        progressView.isVisible = model.isLoading
        adapter.submitList(model.items)
    }

    override fun actions(): Flow<Action> = actionsChannel.asFlow()

    private fun connectPresenter(): SelectCityPresenter {
        val presenter: SelectCityPresenter =
            ViewModelProviders.of(this, object : ViewModelProvider.Factory {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return SelectCityPresenterImpl(
                        SelectCityInteractorImpl(autocompleteApi),
                        SelectCityRouterImpl(requireContext())
                    ) as T
                }
            }).get<SelectCityPresenterImpl>()
        lifecycle.addObserver(object : LifecycleObserver {
            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            fun onDestroy() {
                presenter.clearView()
            }
        })
        presenter.setView(this)
        return presenter
    }


    companion object {
        fun create(autocompleteApi: AutocompleteApi): Fragment = SelectAirportFragment().apply {
            this.autocompleteApi = autocompleteApi
        }
    }

}