package com.booknewyorktimes.booksapi.ui.book

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.booknewyorktimes.booksapi.data.ApiService
import com.booknewyorktimes.booksapi.data.model.Book
import com.booknewyorktimes.booksapi.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class BooksViewModel : ViewModel() {

    val booksLiveData : MutableLiveData<List<Book>> = MutableLiveData()

    fun getBookLiveData(){
        //booksLiveData.value = getBook()
        ApiService.service.listRepos().enqueue(object : Callback<BookBodyResponse> {

            // Esses metodos tratam erros
            override fun onResponse(call: Call<BookBodyResponse>, response: Response<BookBodyResponse>) {
                if(response.isSuccessful){
                    val books : MutableList<Book> = mutableListOf()

                    response.body()?.let {BookBodyResponse ->
                        for (result in BookBodyResponse.resultBook){
                            val book = Book(
                                title = result.bookDetails[0].title,
                                author = result.bookDetails[0].author
                            )
                            books.add(book)
                        }
                    }
                    booksLiveData.value = books
                }
            }
            override fun onFailure(call: Call<BookBodyResponse>, t: Throwable) {

            }

        })
    }
}


