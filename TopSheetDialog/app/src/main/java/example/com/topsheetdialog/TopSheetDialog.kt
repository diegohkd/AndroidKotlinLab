package example.com.topsheetdialog

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

class TopSheetDialog : DialogFragment() {

    private val statusBarColorRes = R.color.colorPrimaryDark
    private var previousSystemUiVisibility: Int? = null

    override fun getTheme(): Int = R.style.NoMarginsDialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.dialog_fragment_top_sheet, container)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    override fun onDestroy() {
        previousSystemUiVisibility?.let(::setActivitySystemUiVisibility)
        super.onDestroy()
    }

    // region private

    private fun setupView() {
        setupToShowAtTheTop()
        setupWidthToMatchParent()
        setupSlideFromTopAnimation()
        setupStatusBarColor()

        // workaround to fix slide animation repeating when activity resumes
        dialog?.setOnShowListener { Handler().post { setupSlideToTopAnimation() } }
    }

    private fun setupStatusBarColor() {
        previousSystemUiVisibility = getActivitySystemUiVisibility()
        setStatusBarColor(statusBarColorRes)
    }

    // endregion private

    companion object {
        fun newInstance(): TopSheetDialog = TopSheetDialog()
    }
}