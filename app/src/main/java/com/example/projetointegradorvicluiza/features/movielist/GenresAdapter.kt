package com.example.projetointegradorvicluiza.features.movielist

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.ToggleButton
import androidx.recyclerview.widget.RecyclerView
import com.example.projetointegradorvicluiza.MovieList
import com.example.projetointegradorvicluiza.R
import com.example.projetointegradorvicluiza.MovieGenre
import com.example.projetointegradorvicluiza.extensions.loadMovieImage
import com.example.projetointegradorvicluiza.features.moviedetail.MovieDetailActivity

const val CHOOSED_GENERS_ID = "com.example.projetointegradorvicluiza.GENERSID"

public class GenresAdapter(var context: Context, var dataset: MutableList<MovieGenre> = mutableListOf()) : RecyclerView.Adapter<GenresAdapter.GenresViewHolder>() {
    inner class GenresViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val bttogGenre: ToggleButton = view.findViewById(R.id.toggleButtonGenre)
        var idGenre = 0
        //val idMovie: TextView = view.findViewById(R.id.idMovie)
        //val moviePoster: ImageButton = view.findViewById(R.id.moviePoster)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenresViewHolder =
        GenresViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_genres, parent, false)
        )

    override fun onBindViewHolder(holder: GenresViewHolder, position: Int) {
        holder.bttogGenre.text = dataset[position].name
        holder.idGenre = dataset[position].id
        holder.bttogGenre.setOnCheckedChangeListener(){_, isChecked ->
            if (isChecked) {
                val intent = Intent(context, MainActivity::class.java).apply{
                putExtra(CHOOSED_GENERS_ID,dataset[position].id.toString())
            }}
            //context.startActivity(intent)
        }

        //moviesFilteredGener()

        //holder.idMovie.text = dataset[position].id.toString()

        /*holder.moviePoster.loadMovieImage(dataset[position].poster_path)
        holder.moviePoster.setOnClickListener{
            val intent = Intent(context, MovieDetailActivity::class.java).apply{
                putExtra(CHOOSED_MOVIE_ID,dataset[position].id.toString())
            }
            context.startActivity(intent)
        }*/

    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}