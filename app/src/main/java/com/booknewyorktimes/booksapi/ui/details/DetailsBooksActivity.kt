package com.booknewyorktimes.booksapi.ui.details

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.booknewyorktimes.booksapi.R
import kotlinx.android.synthetic.main.activity_details_books.*
import kotlinx.android.synthetic.main.include_toolbar_linear.*
import java.net.URLEncoder


class DetailsBooksActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_books)

        toolbar()

        details_title_text.text = intent.getStringExtra(EXTRA_TITLE)
        details_description_text.text =  intent.getStringExtra(EXTRA_DESCRIPTION)

        viewSearchGoogle()
    }

    private fun toolbar() {
        toolbar_main.title = getString(R.string.Details_title)
        setSupportActionBar(toolbar_main)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun viewSearchGoogle() {
        val titleExtra = intent.getStringExtra(EXTRA_TITLE)
        button_google.setOnClickListener {
            val titleString: String = URLEncoder.encode(titleExtra, "UTF-8")
            val uri = Uri.parse("https://www.google.com/#q=$titleString")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }

    companion object {

        private const val EXTRA_TITLE = "EXTRA_TITLE"
        private const val EXTRA_DESCRIPTION = "EXTRA_DESCRIPTION"
        fun getStartIntent(context : Context, title :String, description : String) : Intent {
            return Intent(context , DetailsBooksActivity::class.java).apply {
                putExtra(EXTRA_TITLE, title)
                putExtra(EXTRA_DESCRIPTION, description)
            }
        }
    }
}