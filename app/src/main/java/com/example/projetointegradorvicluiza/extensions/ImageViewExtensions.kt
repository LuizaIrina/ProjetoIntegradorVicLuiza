package com.example.projetointegradorvicluiza.extensions

import android.widget.ImageView
import coil.load

private const val BASEIMG = "https://image.tmdb.org/t/p/w780"

fun ImageView.loadMovieImage(path: String){
    load(BASEIMG+path)
}
//val backdrop_sizes: List<String> = listOf("w300", "w780", "w1280", "original")
//val poster_sizes: List<String> = listOf("w92", "w154", "w185", "w342", "w500", "w780", "original")