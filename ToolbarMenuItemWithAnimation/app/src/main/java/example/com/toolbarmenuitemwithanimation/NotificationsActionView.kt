package example.com.toolbarmenuitemwithanimation

import android.content.Context
import android.util.AttributeSet
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.action_view_notifications.view.*

class NotificationsActionView(
    context: Context, attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {

    private val bounceAnimation: Animation by lazy {
        AnimationUtils.loadAnimation(context, R.anim.bounce_interpolar)
    }

    fun setNotificationsCount(count: Int) {
        if (count <= 0) {
            notificationsTextView.text = ""
            notificationsTextView.isVisible = false
        } else {
            notificationsTextView.text = if (count > 99) {
                resources.getString(R.string.max_count_plus)
            } else {
                count.toString()
            }
            notificationsTextView.isVisible = true
            notificationsTextView.startAnimation(bounceAnimation)
        }
    }

}