package example.com.spinnerwithdisabledoptions

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class CityAdapter(
    var cities: List<City>,
    context: Context
) : ArrayAdapter<City>(
    context,
    android.R.layout.simple_spinner_item,
    cities
) {

    init {
        setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View =
        (super.getDropDownView(position, convertView, parent) as TextView).apply {
            val city = cities[position]
            text = city.name
            isEnabled = city.isEnabled
        }

    override fun isEnabled(position: Int): Boolean = cities[position].isEnabled
}