package com.example.projetointegradorvicluiza

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

const val apiKey = "262ce18b881e25dfd45c091768444218"
//const val languageBrazil = "pt-BR"

class MainActivity : AppCompatActivity() {

private lateinit var moviesAdapter: MoviesAdapter
private lateinit var rvMoviesList: RecyclerView

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    rvMoviesList = findViewById(R.id.recyclerView)
    moviesAdapter = MoviesAdapter(this)
    rvMoviesList.adapter = moviesAdapter
    rvMoviesList.layoutManager = LinearLayoutManager(this,
        LinearLayoutManager.HORIZONTAL,false)

    getMoviesList()

}


fun getMoviesList(){
    NetworkTMDB.getMovies().listingMovies(apiKey, "pt-BR")
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