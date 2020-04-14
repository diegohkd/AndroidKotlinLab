package example.com.spinnerwithdisabledoptions

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupSpinner()
    }

    private fun setupSpinner() {
        spinner.adapter = CityAdapter(
            listOf(
                City("Florianópolis", true),
                City("Buenos Aires", false),
                City("New York", true),
                City("Toronto", false),
                City("Halifax", false),
                City("London", true),
                City("Lisboa", true)
            ),
            this
        )
    }

}