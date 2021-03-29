package com.booknewyorktimes.booksapi.data

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

// Objeto para uso de conexao com minha api
object ApiService {

    private fun iniRetrofit() : Retrofit{
        //val moshi = Moshi.Builder()
            //.add(KotlinJsonAdapterFactory())
            //.build()

        return Retrofit.Builder()
            .baseUrl("https://api.nytimes.com/svc/books/v3/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
    val service: NewYorkTimesService = iniRetrofit().create(NewYorkTimesService::class.java)
}
