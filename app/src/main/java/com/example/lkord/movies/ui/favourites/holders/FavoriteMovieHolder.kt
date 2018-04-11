package com.example.lkord.movies.ui.favourites.holders

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.lkord.movies.common.extensions.loadImage
import com.example.lkord.movies.common.extensions.onClick
import com.example.lkord.movies.model.data.Movie
import kotlinx.android.synthetic.main.response_item_layout.view.*

class FavoriteMovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun setFavoriteData(movie: Movie) = with(itemView) {
        loadImage(this, movie.poster, moviePoster)
        movieTitle.text = movie.title
        movieType.text = movie.type
        movieYear.text = movie.year
    }

}