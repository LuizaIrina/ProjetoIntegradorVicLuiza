package com.example.projetointegradorvicluiza

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load

const val CHOOSED_MOVIE_ID = "com.example.projetointegradorvicluiza.ID"

public class MoviesAdapter(var context: Context, var dataset: MutableList<Movie> = mutableListOf()) : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {
    inner class MoviesViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val nameMovie: TextView = view.findViewById(R.id.nameMovie)
        val idMovie: TextView = view.findViewById(R.id.idMovie)
        val moviePoster: ImageButton = view.findViewById(R.id.moviePoster)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder =
        MoviesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        )

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.nameMovie.text = dataset[position].title
        holder.idMovie.text = dataset[position].id.toString()

        val baseImg = "https://image.tmdb.org/t/p/"
        //val backdrop_sizes: List<String> = listOf("w300", "w780", "w1280", "original")
        val poster_sizes: List<String> = listOf("w92", "w154", "w185", "w342", "w500", "w780", "original")

        holder.moviePoster.load(baseImg+poster_sizes[4]+dataset[position].poster_path)
        holder.moviePoster.setOnClickListener{
            val intent = Intent(context, MovieDetailActivity::class.java).apply{
                putExtra(CHOOSED_MOVIE_ID,dataset[position].id.toString())
            }
            context.startActivity(intent)
        }

/*        fun showDatails (view: View){
            val intent = Intent(view.getContext(),TelaDetalhe::class.java).apply{
                putExtra(EXTRA_ID, dataset[position].id)
            }
            view.getContext().startActivity(intent)
        }*/

    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}