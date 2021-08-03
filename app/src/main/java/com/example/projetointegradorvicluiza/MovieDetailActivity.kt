package com.example.projetointegradorvicluiza

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import coil.load
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

//const val apiKey = "262ce18b881e25dfd45c091768444218"

class MovieDetailActivity : AppCompatActivity() {

    private lateinit var overviewMovie: TextView
    private lateinit var titleMovie: TextView
    private lateinit var backdropMovie: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        titleMovie = findViewById<TextView>(R.id.titleMovie)
        overviewMovie = findViewById<TextView>(R.id.overviewMovie)
        backdropMovie = findViewById<ImageView>(R.id.backdropMovie)

        var movieChoosed: Movie
        var idMovieChoosed = intent.getStringExtra(CHOOSED_MOVIE_ID)
        if (idMovieChoosed != null)
            getMovieDetail(idMovieChoosed, "https://image.tmdb.org/t/p/w780")
        else
            Toast.makeText(this,"erro ao escolher",Toast.LENGTH_SHORT).show()
        //carregar a tela de "o sistema falhou"


    }

    fun getMovieDetail(id: String, baseImg: String){
        NetworkTMDB.getMovies().detailMovie(id.toInt(),apiKey, "pt-BR")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError {
                //Log.e()
                // carregar a tela de "o sistema falhou"
            }
            .subscribe { resposta ->
                titleMovie.text = resposta.title
                overviewMovie.text = resposta.overview
                backdropMovie.load(baseImg+resposta.backdrop_path)
                //moviesAdapter.dataset.addAll(resposta.results)
                //moviesAdapter.notifyDataSetChanged()
            }
    }

}