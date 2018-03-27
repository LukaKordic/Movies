package com.example.lkord.movies.ui.search.holders

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.lkord.movies.common.loadImage
import com.example.lkord.movies.common.onClick
import com.example.lkord.movies.model.data.Movie
import kotlinx.android.synthetic.main.response_item_layout.view.*

class SearchResponseHolder(itemView: View, private val onItemClick: (Movie) -> Unit) :
        RecyclerView.ViewHolder(itemView) {

    fun setMovieData(movie: Movie) = with(itemView) {
        loadImage(this, movie.poster, moviePoster)
        movieTitle.text = movie.title
        movieYear.text = movie.year
        movieType.text = movie.type

        onClick { onItemClick(movie) }
    }
}