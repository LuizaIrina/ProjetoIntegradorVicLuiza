package com.example.projetointegradorvicluiza

import com.example.projetointegradorvicluiza.features.moviedetail.MovieDetail
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val APIKEY = "262ce18b881e25dfd45c091768444218"
private const val LANGUAGEBRAZIL = "pt-BR"
var searchFilteredGener = "/?api_key=262ce18b881e25dfd45c091768444218&with_genres=14&"

interface MovieInfoService {
    @GET("movie/popular")
    fun listingMovies(@Query("api_key") key: String = APIKEY,
                      @Query("language") len: String = LANGUAGEBRAZIL): Observable<ResponseList>

    @GET("genre/movie/list")
    fun listingGenresMovies(@Query("api_key") key: String = APIKEY,
                            @Query("language") len: String = LANGUAGEBRAZIL): Observable<ResponseListMovieGenre>

    @GET("discover/movie")
    fun moviesFilteredGener(@Path("with_genres") genres : String,
                            @Query("api_key") key: String = APIKEY,
                            @Query("language") len: String = LANGUAGEBRAZIL): Observable<ResponseList>

    @GET("movie/{movie_id}")
    fun detailMovie(@Path("movie_id") id: Int, @Query("api_key") key: String = APIKEY,
                    @Query("language") len: String = LANGUAGEBRAZIL): Observable<MovieDetail>

    @GET("movie/{movie_id}/credits")
    fun listingCastMovie(@Path("movie_id") id: Int, @Query("api_key") key: String = APIKEY,
                         @Query("language") len: String = LANGUAGEBRAZIL): Observable<ResponseMovieCast>

}