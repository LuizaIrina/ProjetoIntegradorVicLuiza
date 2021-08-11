package com.example.projetointegradorvicluiza.features.movielist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetointegradorvicluiza.features.movielist.MoviesAdapter
import com.example.projetointegradorvicluiza.features.movielist.GenresAdapter
import com.example.projetointegradorvicluiza.NetworkTMDB
import com.example.projetointegradorvicluiza.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class MainActivity : AppCompatActivity() {

private lateinit var moviesAdapter: MoviesAdapter
private lateinit var rvMoviesList: RecyclerView
private lateinit var genresAdapter: GenresAdapter
private lateinit var rvGenresList: RecyclerView

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    rvMoviesList = findViewById(R.id.rvMovies)
    rvGenresList = findViewById(R.id.rvGenres)
    moviesAdapter = MoviesAdapter(this)
    genresAdapter = GenresAdapter(this)
    rvMoviesList.adapter = moviesAdapter
    rvGenresList.adapter = genresAdapter
    rvMoviesList.layoutManager = LinearLayoutManager(this,
        LinearLayoutManager.HORIZONTAL,false)
    rvGenresList.layoutManager = LinearLayoutManager(this,
        LinearLayoutManager.HORIZONTAL,false)


    getGenresList()
    getMoviesList()

    // se botao de genero ON, chama moviesFilteredGener(idGener)
    var idGenersChoosed : MutableList<Int> = mutableListOf()
    intent.getStringExtra(CHOOSED_GENERS_ID)?.let { idGenersChoosed.add(it.toInt()) }

    getMoviesFilteredGenre(idGenersChoosed[0].toString())

}

    fun getMoviesList(){
    NetworkTMDB.getMovies().listingMovies()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .doOnError {
            //Log.e()
            // carregar a tela de "o sistema falhou"
        }
        .subscribe { resposta ->
            moviesAdapter.dataset.addAll(resposta.results)
            moviesAdapter.notifyDataSetChanged()
        }
    }

    fun getGenresList(){
        NetworkTMDB.getMovies().listingGenresMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError {
                //Log.e()
                // carregar a tela de "o sistema falhou"
            }
            .subscribe { resposta ->
                genresAdapter.dataset.addAll(resposta.genres)
                genresAdapter.notifyDataSetChanged()
            }
    }

    fun getMoviesFilteredGenre(idGenre: String){
        NetworkTMDB.getMovies().moviesFilteredGener(idGenre)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError {
                //Log.e()
                // carregar a tela de "o sistema falhou"
            }
            .subscribe { resposta ->
                moviesAdapter.dataset.addAll(resposta.results)
                moviesAdapter.notifyDataSetChanged()
            }
    }

}