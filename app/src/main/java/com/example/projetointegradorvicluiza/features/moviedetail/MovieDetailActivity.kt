package com.example.projetointegradorvicluiza.features.moviedetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.projetointegradorvicluiza.features.movielist.CHOOSED_MOVIE_ID
import com.example.projetointegradorvicluiza.features.moviedetail.MovieDetail
import com.example.projetointegradorvicluiza.NetworkTMDB
import com.example.projetointegradorvicluiza.R
import com.example.projetointegradorvicluiza.extensions.loadMovieImage
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MovieDetailActivity : AppCompatActivity() {

    private lateinit var overviewMovie: TextView
    private lateinit var titleMovie: TextView
    private lateinit var backdropMovie: ImageView

    private lateinit var imageActor1: ImageView
    private lateinit var nameActor1: TextView
    private lateinit var chActor1: TextView

    private lateinit var imageActor2: ImageView
    private lateinit var nameActor2: TextView
    private lateinit var chActor2: TextView

    private lateinit var imageActor3: ImageView
    private lateinit var nameActor3: TextView
    private lateinit var chActor3: TextView

    private lateinit var imageActor4: ImageView
    private lateinit var nameActor4: TextView
    private lateinit var chActor4: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        titleMovie = findViewById(R.id.titleMovie)
        overviewMovie = findViewById(R.id.overviewMovie)
        backdropMovie = findViewById(R.id.backdropMovie)

        imageActor1 = findViewById(R.id.imageActor1)
        nameActor1 = findViewById(R.id.nameActor1)
        chActor1 = findViewById(R.id.chActor1)

        imageActor2 = findViewById(R.id.imageActor2)
        nameActor2 = findViewById(R.id.nameActor2)
        chActor2 = findViewById(R.id.chActor2)

        imageActor3 = findViewById(R.id.imageActor3)
        nameActor3 = findViewById(R.id.nameActor3)
        chActor3 = findViewById(R.id.chActor3)

        imageActor4 = findViewById(R.id.imageActor4)
        nameActor4 = findViewById(R.id.nameActor4)
        chActor4 = findViewById(R.id.chActor4)

        //var movieChoosed: MovieDetail
        var idMovieChoosed = intent.getStringExtra(CHOOSED_MOVIE_ID)
        if (idMovieChoosed != null){
            getMovieDetail(idMovieChoosed)
            getCastMovie(idMovieChoosed)
        }
        else
            Toast.makeText(this,"erro ao escolher",Toast.LENGTH_SHORT).show()
        //carregar a tela de "o sistema falhou"


    }

    fun getMovieDetail(id: String){
        NetworkTMDB.getMovies().detailMovie(id.toInt())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError {
                //Log.e()
                // carregar a tela de "o sistema falhou"
            }
            .subscribe { resposta ->
                titleMovie.text = resposta.title
                overviewMovie.text = resposta.overview
                backdropMovie.loadMovieImage(resposta.backdrop_path)
                //moviesAdapter.dataset.addAll(resposta.results)
                //moviesAdapter.notifyDataSetChanged()
            }
    }
    fun getCastMovie(id: String){
        NetworkTMDB.getMovies().listingCastMovie(id.toInt())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError {
                //Log.e()
                // carregar a tela de "o sistema falhou"
            }
            .subscribe { resposta ->
                nameActor1.text = resposta.cast[0].name
                chActor1.text = resposta.cast[0].character
                imageActor1.loadMovieImage(resposta.cast[0].profile_path)

                nameActor2.text = resposta.cast[1].name
                chActor2.text = resposta.cast[1].character
                imageActor2.loadMovieImage(resposta.cast[1].profile_path)

                nameActor3.text = resposta.cast[2].name
                chActor3.text = resposta.cast[2].character
                imageActor3.loadMovieImage(resposta.cast[2].profile_path)

                nameActor4.text = resposta.cast[3].name
                chActor4.text = resposta.cast[3].character
                imageActor4.loadMovieImage(resposta.cast[3].profile_path)
                //colocar aqui a logica de busca do diretor
            }
    }


}