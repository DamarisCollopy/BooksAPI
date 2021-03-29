package com.booknewyorktimes.booksapi.data.response

import com.squareup.moshi.JsonClass
// Esse JSONCLASS e usado para fazer a conversao em json pelo moshi, Codegen do moshi e usado aqui
// Documentacao https://github.com/square/moshi/
@JsonClass(generateAdapter = true)
data class BookDetailsResponse (

    // Nessa classe nao fiz a anotacao de @JSON porque usei os mesmos nomes das variaveis na api, ele entende aut e mapeia
    val title : String,
    val author : String,
    val description : String
)