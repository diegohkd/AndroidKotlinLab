package example.com.toolbarmenuitemwithanimation

import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var notificationsActionView: NotificationsActionView? = null
    private var notificationsCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupClickListeners()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        val notificationItem = menu?.findItem(R.id.notification)?.actionView
        notificationsActionView = notificationItem as? NotificationsActionView
        notificationsActionView?.setOnClickListener {
            Toast.makeText(this, "Not implemented", Toast.LENGTH_SHORT).show()
        }
        return super.onPrepareOptionsMenu(menu)
    }

    private fun setupClickListeners() {
        decreaseTenButton.setOnClickListener {
            notificationsCount -= 10
            notificationsActionView?.setNotificationsCount(notificationsCount)
        }
        decreaseButton.setOnClickListener {
            notificationsActionView?.setNotificationsCount(--notificationsCount)
        }
        increaseButton.setOnClickListener {
            notificationsActionView?.setNotificationsCount(++notificationsCount)
        }
        increaseTenButton.setOnClickListener {
            notificationsCount += 10
            notificationsActionView?.setNotificationsCount(notificationsCount)
        }
    }
}