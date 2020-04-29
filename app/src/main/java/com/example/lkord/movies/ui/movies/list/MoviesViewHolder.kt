package com.example.lkord.movies.ui.movies.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.Movie
import com.example.lkord.movies.util.extensions.loadPosterImage
import com.example.lkord.movies.util.extensions.onClick
import kotlinx.android.synthetic.main.movie_item.view.*

class MoviesViewHolder(itemView: View, private val onItemClick: (Movie) -> Unit) :
    RecyclerView.ViewHolder(itemView) {
  
  fun setMovieData(movie: Movie) = with(itemView) {
    moviePoster.loadPosterImage(movie.posterPath)
    onClick { onItemClick(movie) }
  }
}