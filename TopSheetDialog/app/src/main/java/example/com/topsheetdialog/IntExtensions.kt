package example.com.topsheetdialog

import android.graphics.Color

val Int.isDark: Boolean
    get() {
        val red = Color.red(this)
        val green = Color.green(this)
        val blue = Color.blue(this)
        val darkness = 1 - (0.299 * red + 0.587 * green + 0.114 * blue) / 255
        return darkness >= 0.5
    }