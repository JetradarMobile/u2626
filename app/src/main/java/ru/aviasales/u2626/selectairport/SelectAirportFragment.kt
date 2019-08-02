package ru.aviasales.u2626.selectairport

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.aviasales.u2626.R


class SelectAirportFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_select_airport, container, false)

    companion object {
        fun create(): Fragment = SelectAirportFragment()
    }

}