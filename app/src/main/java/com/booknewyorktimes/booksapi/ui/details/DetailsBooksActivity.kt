package com.booknewyorktimes.booksapi.ui.details

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.booknewyorktimes.booksapi.R
import kotlinx.android.synthetic.main.activity_details_books.*
import kotlinx.android.synthetic.main.include_toolbar_linear.*


class DetailsBooksActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_books)

        toolbar_main.title = getString(R.string.Details_title)
        setSupportActionBar(toolbar_main)

        details_title_text.text = intent.getStringExtra(EXTRA_TITLE)
        details_description_text.text =  intent.getStringExtra(EXTRA_DESCRIPTION)
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