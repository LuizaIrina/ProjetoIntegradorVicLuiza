package com.example.projetointegradorvicluiza.features.moviedetail

import com.example.projetointegradorvicluiza.MovieGenre

data class MovieDetail(
    val backdrop_path: String,
    val genres: List<MovieGenre>,
    val id: Int,
    val overview: String,
    val release_date: String,
    val title: String,
    val vote_average: Float

    //val name: String,
    //val id: String,
    //val image: String
)
