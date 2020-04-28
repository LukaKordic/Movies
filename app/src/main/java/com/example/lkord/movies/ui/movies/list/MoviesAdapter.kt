package com.example.lkord.movies.ui.movies.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.Movie
import com.example.lkord.movies.R

class MoviesAdapter(private val onItemClick: (Movie) -> Unit) : RecyclerView.Adapter<MoviesViewHolder>() {

    private val movies = mutableListOf<Movie>()

    fun addMovies(data: List<Movie>) {
        movies.clear()
        movies.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return MoviesViewHolder(view, onItemClick)
    }

    override fun onBindViewHolder(responseHolder: MoviesViewHolder, position: Int) {
        responseHolder.setMovieData(movies[position])
    }

    override fun getItemCount() = movies.size
}