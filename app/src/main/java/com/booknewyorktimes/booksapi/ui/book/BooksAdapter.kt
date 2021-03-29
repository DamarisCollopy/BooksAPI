package com.booknewyorktimes.booksapi.ui.book

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.booknewyorktimes.booksapi.R
import com.booknewyorktimes.booksapi.data.model.Book
import kotlinx.android.synthetic.main.list_books.view.*

class BooksAdapter(
    val books : List<Book>

) : RecyclerView.Adapter<BooksAdapter.BookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.list_books, parent,false)
        return BookViewHolder(view)
    }

    override fun getItemCount() = books.count()


    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bindView(books[position])
    }



    class BookViewHolder(view : View) :RecyclerView.ViewHolder(view){

        private val title = view.Title
        private val author = view.Author

        fun bindView(book :Book){
            title.text = book.title
            author.text = book.author
        }
    }
}