package com.example.lkord.movies.ui.favourites.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.Movie
import com.example.lkord.movies.R

class FavouritesAdapter : RecyclerView.Adapter<FavoriteMovieHolder>() {

    private val favoriteMovies = mutableListOf<Movie>()

    fun updateFavorites(favMovies: List<Movie>) {
        favoriteMovies.clear()
        favoriteMovies.addAll(favMovies)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteMovieHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return FavoriteMovieHolder(view)

    }

    override fun getItemCount() = favoriteMovies.size

    override fun onBindViewHolder(favoriteHolder: FavoriteMovieHolder, position: Int) {
        favoriteHolder.setFavoriteData(favoriteMovies[position])
    }
}