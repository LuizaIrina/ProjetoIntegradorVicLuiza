package com.example.projetointegradorvicluiza

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface MovieInfoService {
    @GET("movie/popular")
    fun listingMovies(@Query("api_key") key: String,
                      @Query("language") len: String): Observable<ResponseList>
    //@GET("movie/popular"+api_key+ language)
    //fun listingMovies(): Observable<ResponseList>

    @GET("movie/{movie_id}")
    fun detailMovie(@Path("movie_id") id: Int, @Query("api_key") key: String,
                    @Query("language") len: String): Observable<Movie>

    @GET("movie/{movie_id}/credits")
    fun listingCastMovie(@Path("movie_id") id: Int, @Query("api_key") key: String,
                         @Query("language") len: String): Observable<MovieCast>
}