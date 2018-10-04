package com.example.lkord.movies.ui.favourites.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.lkord.movies.R
import com.example.lkord.movies.data.db.entities.Movie
import com.example.lkord.movies.ui.favourites.holders.FavoriteMovieHolder

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