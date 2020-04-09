package example.com.topsheetdialog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val topSheetDialogTag = "top_sheet_dialog"
    private val topSheetWithToolbarDialogTag = "topSheetWithToolbarDialogTag"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonShowTopSheet.setOnClickListener { showTopSheetDialog() }
        buttonShowTopSheetWithToolbar.setOnClickListener { showTopSheetWithToolbarDialog() }
    }

    private fun showTopSheetDialog() {
        val topSheetDialog = TopSheetDialog.newInstance()
        topSheetDialog.show(supportFragmentManager, topSheetDialogTag)
    }

    private fun showTopSheetWithToolbarDialog() {
        val topSheetDialog = TopSheetWithToolbarDialog.newInstance()
        topSheetDialog.show(supportFragmentManager, topSheetWithToolbarDialogTag)
    }
}