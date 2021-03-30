package com.booknewyorktimes.booksapi.ui.book

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.booknewyorktimes.booksapi.R
import kotlinx.android.synthetic.main.activity_books.*
import kotlinx.android.synthetic.main.fragment_books_list.*
import kotlinx.android.synthetic.main.include_toolbar_constrante.*

class BooksActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)

        toolbar_title()
    }

    private fun toolbar_title() {
        toolbar_main.title = getString(R.string.Books_title)
        setSupportActionBar(toolbar_main)
    }
}