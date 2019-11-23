package com.example.lkord.movies.ui.nowPlaying.holders

import androidx.recyclerview.widget.RecyclerView
import android.view.View
import com.example.lkord.movies.data.db.entities.Movie
import com.example.lkord.movies.util.extensions.loadImage
import com.example.lkord.movies.util.extensions.onClick
import kotlinx.android.synthetic.main.movie_item.view.*

class NowPlayingHolder(itemView: View, private val onItemClick: (Movie) -> Unit) :
        RecyclerView.ViewHolder(itemView) {

    fun setMovieData(movie: Movie) = with(itemView) {
        movieTitle.text = movie.title
        releaseDate.text = movie.releaseDate
        moviePoster.loadImage(movie.posterPath)
        onClick { onItemClick(movie) }
    }
}