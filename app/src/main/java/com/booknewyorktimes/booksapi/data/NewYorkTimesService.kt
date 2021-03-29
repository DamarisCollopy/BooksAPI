package com.booknewyorktimes.booksapi.data

import com.booknewyorktimes.booksapi.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewYorkTimesService {

    //https://developer.nytimes.com/docs/books-product/1/routes/lists.json/get
    // lists.json, metodo get inscrito no nyt
    @GET("lists.json")
    fun listRepos(
        @Query("api-key") apiKey : String = "nB6nPdTOzG41ZNNH8HlySjlXreXSzAvy",
        @Query("list") list : String = "hardcover-fiction"
    ): Call<BookBodyResponse>
    // Call e chamado na minha classe booksviewmodel quando uso callback
}