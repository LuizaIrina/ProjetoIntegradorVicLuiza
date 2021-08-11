package com.example.projetointegradorvicluiza

data class MovieCast (
    val name: String,
    val known_for_department: String, // procura por directoring e actering??
    val job: String, // procurar por "job": "Director" pra colocar como primeiro e por na foto
    val character: String, //colocar o "character": "Frank Wolff" e por na foto
    val profile_path: String   //fotinha
    )
//cada Movie tem uma lista de MovieCast, de 4 (ou mais?) objetos

data class ResponseMovieCast (
    val id: Int,
    val cast: List<MovieCast>
    )
