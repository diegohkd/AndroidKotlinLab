package example.com.topsheetdialog

import android.os.Build
import android.view.*
import android.view.View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment

val DialogFragment.window: Window? get() = dialog?.window
val DialogFragment.activityDecorView: View? get() = activity?.window?.decorView

fun DialogFragment.setupToShowAtTheTop() {
    window?.setGravity(Gravity.CENTER_HORIZONTAL or Gravity.TOP)
}

fun DialogFragment.setupWidthToMatchParent() {
    window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
}

fun DialogFragment.setupTopSlideAnimation() {
    window?.attributes?.windowAnimations = R.style.DialogAnimation
}

fun DialogFragment.getActivitySystemUiVisibility(): Int? =
    window?.decorView?.systemUiVisibility

fun DialogFragment.setActivitySystemUiVisibility(flags: Int) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        activityDecorView?.systemUiVisibility = flags
    }
}

fun DialogFragment.setStatusBarColor(@ColorRes colorRes: Int) {
    window?.run {
        addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        val color = ContextCompat.getColor(context, colorRes)
        statusBarColor = color

        // does not work if dim is enabled
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val decorView = activityDecorView ?: return
            if (!color.isDark) {
                decorView.systemUiVisibility =
                    decorView.systemUiVisibility or SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
        }
    }
}

fun DialogFragment.setupToolbarCloseButton(toolbar: Toolbar, @StringRes titleRes: Int?) {
    titleRes?.let(toolbar::setTitle)
    toolbar.navigationIcon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_close)
    toolbar.setNavigationOnClickListener {
        dismiss()
    }
}