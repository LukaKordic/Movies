package com.example.lkord.movies.ui.search.holders

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.lkord.movies.common.extensions.loadImage
import com.example.lkord.movies.common.extensions.onClick
import com.example.lkord.movies.db.entities.Movie
import kotlinx.android.synthetic.main.response_item_layout.view.*

class SearchResponseHolder(itemView: View, private val onItemClick: (Movie) -> Unit) :
        RecyclerView.ViewHolder(itemView) {

    fun setMovieData(movie: Movie) = with(itemView) {
        onClick { onItemClick(movie) }
    }
}