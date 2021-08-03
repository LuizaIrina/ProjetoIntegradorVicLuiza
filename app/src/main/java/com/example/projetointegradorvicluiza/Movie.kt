package com.example.projetointegradorvicluiza

data class Movie(
    val adult: Boolean,
    val backdrop_path: String,
    val genre_ids: List<Int>,
    val id: Int,
    val overview: String,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val vote_average: Float

    //val name: String,
    //val id: String,
    //val image: String
)

data class ResponseList(
    val page: Int,
    val results: List<Movie>
)