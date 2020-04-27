package com.example.lkord.movies.ui.topRated.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.Movie
import com.example.lkord.movies.R

class MovieAdapter(private val onItemClick: (Movie) -> Unit) : RecyclerView.Adapter<NowPlayingHolder>() {

    private val movies = mutableListOf<Movie>()

    fun addMovies(data: List<Movie>) {
        movies.clear()
        movies.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NowPlayingHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return NowPlayingHolder(view, onItemClick)
    }

    override fun onBindViewHolder(responseHolder: NowPlayingHolder, position: Int) {
        responseHolder.setMovieData(movies[position])
    }

    override fun getItemCount() = movies.size
}