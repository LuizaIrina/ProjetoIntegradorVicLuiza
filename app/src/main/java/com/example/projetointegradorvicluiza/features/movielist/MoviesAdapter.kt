package com.example.projetointegradorvicluiza.features.movielist

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetointegradorvicluiza.MovieList
import com.example.projetointegradorvicluiza.R
import com.example.projetointegradorvicluiza.extensions.loadMovieImage
import com.example.projetointegradorvicluiza.features.moviedetail.MovieDetailActivity

const val CHOOSED_MOVIE_ID = "com.example.projetointegradorvicluiza.ID"

public class MoviesAdapter(var context: Context, var dataset: MutableList<MovieList> = mutableListOf()) : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {
    inner class MoviesViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val nameMovie: TextView = view.findViewById(R.id.nameMovie)
        //val idMovie: TextView = view.findViewById(R.id.idMovie)
        val moviePoster: ImageButton = view.findViewById(R.id.moviePoster)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder =
        MoviesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        )

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.nameMovie.text = dataset[position].title
        //holder.idMovie.text = dataset[position].id.toString()

        holder.moviePoster.loadMovieImage(dataset[position].poster_path)
        holder.moviePoster.setOnClickListener{
            val intent = Intent(context, MovieDetailActivity::class.java).apply{
                putExtra(CHOOSED_MOVIE_ID,dataset[position].id.toString())
            }
            context.startActivity(intent)
        }
        
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}