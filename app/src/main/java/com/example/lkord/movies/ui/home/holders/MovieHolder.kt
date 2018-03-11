package com.example.lkord.movies.ui.home.holders

import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import com.example.lkord.movies.dataobjects.Movie
import kotlinx.android.synthetic.main.movie_item_layout.view.*

class MovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun setMovieData(movie: Movie) {
        with(itemView) {
            Glide.with(this).load(Uri.parse(movie.poster)).into(moviePoster)
            movieTitle.text = movie.title
            movieDescription.text = movie.description
        }
    }
}