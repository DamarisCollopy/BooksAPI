package com.booknewyorktimes.booksapi.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

// Na ordem essa classe e a 2 na chamada depois parte para bookdetailsresponse classe
// Esse JSONCLASS e usado para fazer a conversao em json pelo moshi, Codegen do moshi e usado aqui
// Documentacao https://github.com/square/moshi/
@JsonClass(generateAdapter = true)
data class ResultResponse (
    @Json(name = "book_details")
    val bookDetails : List<BookDetailsResponse>
)
