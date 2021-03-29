package com.booknewyorktimes.booksapi.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

// Esse JSONCLASS e usado para fazer a conversao em json pelo moshi, Codegen do moshi e usado aqui
// Documentacao https://github.com/square/moshi/

// Minha classe Start da api, depois ela parte para a classe ResultResponse

@JsonClass(generateAdapter = true)
data class BookBodyResponse (
    // name veio da api do nyt, dentro do body, fazendo isso estou mapeando minha api
    @Json(name = "results")
    val resultBook :List<ResultResponse>
)