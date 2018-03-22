package com.example.lkord.movies.ui.search.holders

import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.lkord.movies.repository.dataobjects.Movie
import kotlinx.android.synthetic.main.response_item_layout.view.*

class SearchResponseHolder(itemView: View, private val onItemClick: (Movie) -> Unit) :
        RecyclerView.ViewHolder(itemView) {

    fun setMovieData(movie: Movie) {
        with(itemView) {
            loadImage(this, movie.poster, moviePoster)
            movieTitle.text = movie.title
            movieYear.text = movie.year
            movieType.text = movie.type

            onClick { onItemClick(movie) }
        }
    }
}

fun View.onClick(onClick: () -> Unit) {
    setOnClickListener { onClick() }
}

fun View.loadImage(view: View, poster: String?, imageView: ImageView) {
    Glide.with(view).load(Uri.parse(poster)).into(imageView)
}