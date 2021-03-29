package com.booknewyorktimes.booksapi.ui.book

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.booknewyorktimes.booksapi.R
import kotlinx.android.synthetic.main.activity_books.*

class BooksActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)

        toolbar_main.title = getString(R.string.Books_title)
        setSupportActionBar(toolbar_main)

        // Criacao do viewModel
        val viewModel : BooksViewModel = ViewModelProviders.of(this).get(BooksViewModel ::class.java)
        // viewModel escutando por um livedata
        viewModel.booksLiveData.observe(this,Observer {
            //let substitui a chamada do if(...== null), ele ja faz a checagem
            it?.let { books ->
                with(recycler_main) {
                    layoutManager =
                        LinearLayoutManager(this@BooksActivity, RecyclerView.VERTICAL, false)
                    setHasFixedSize(true)
                    adapter = BooksAdapter(books)
                }
            }
        })
        // Chamo o viewModel
        viewModel.getBookLiveData()
    }
}