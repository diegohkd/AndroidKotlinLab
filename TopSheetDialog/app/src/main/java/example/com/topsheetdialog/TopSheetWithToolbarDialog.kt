package example.com.topsheetdialog

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.dialog_fragment_top_sheet_with_toolbar.*

class TopSheetWithToolbarDialog : DialogFragment() {

    private val statusBarColorRes = R.color.colorPrimaryDark
    private var previousSystemUiVisibility: Int? = null

    override fun getTheme(): Int = R.style.NoMarginsDialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.dialog_fragment_top_sheet_with_toolbar, container)

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
        setupToolbar()

        // workaround to fix slide animation repeating when activity resumes
        dialog?.setOnShowListener { Handler().post { setupSlideToTopAnimation() } }
    }

    private fun setupStatusBarColor() {
        previousSystemUiVisibility = getActivitySystemUiVisibility()
        setStatusBarColor(statusBarColorRes)
    }

    private fun setupToolbar() {
        setupToolbarCloseButton(toolbar, R.string.my_top_sheet)
        setupToolbarMenu()
    }

    private fun setupToolbarMenu() {
        toolbar.inflateMenu(R.menu.menu_top_sheet)
        toolbar.setOnMenuItemClickListener { menuItem ->
            if (menuItem.itemId == R.id.share) {
                Toast.makeText(requireContext(), "Not implemented", Toast.LENGTH_LONG).show()
            }
            true
        }
    }

    // endregion private

    companion object {
        fun newInstance(): TopSheetWithToolbarDialog = TopSheetWithToolbarDialog()
    }
}