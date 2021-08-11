package com.example.projetointegradorvicluiza

data class MovieList(
    val id: Int,
    val poster_path: String,
    val title: String,
    val vote_average: Float

)

data class ResponseList(
    val page: Int,
    val results: List<MovieList>
)