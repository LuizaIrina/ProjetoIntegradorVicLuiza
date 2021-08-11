package com.example.projetointegradorvicluiza

data class MovieGenre(
    val id: Int,
    val name: String
)

data class ResponseListMovieGenre(
    val genres: List<MovieGenre>
)
