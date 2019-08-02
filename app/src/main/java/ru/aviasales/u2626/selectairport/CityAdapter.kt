package ru.aviasales.u2626.selectairport

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.aviasales.core.autocomplete.model.City


class CityAdapter(
    private val listener: (City) -> Unit
) : ListAdapter<City, CityAdapter.ViewHolder>(CityDiffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                android.R.layout.simple_list_item_1,
                parent,
                false
            ),
            listener
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position))

    class ViewHolder(view: View, listener: (City) -> Unit) : RecyclerView.ViewHolder(view) {

        private val textView: TextView = view.findViewById(android.R.id.text1)
        private var model: City? = null

        init {
            view.setOnClickListener { model?.run { listener(this) } }
        }

        fun bind(item: City) {
            model = item

            textView.text = item.fullName
        }
    }

}

object CityDiffUtilCallback : DiffUtil.ItemCallback<City>() {
    override fun areItemsTheSame(oldItem: City, newItem: City): Boolean = oldItem == newItem

    override fun areContentsTheSame(oldItem: City, newItem: City): Boolean = oldItem == newItem
}