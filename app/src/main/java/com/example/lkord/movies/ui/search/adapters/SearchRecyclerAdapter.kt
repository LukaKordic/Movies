package com.example.lkord.movies.ui.search.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lkord.movies.R
import com.example.lkord.movies.dataobjects.Movie
import com.example.lkord.movies.ui.search.holders.SearchResponseHolder

class SearchRecyclerAdapter(
        private val movieList: List<Movie>?,
        private val onItemClick: (Movie) -> Unit
) : RecyclerView.Adapter<SearchResponseHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResponseHolder {
        val view: View =
                LayoutInflater.from(parent.context).inflate(R.layout.response_item_layout, parent, false)
        return SearchResponseHolder(view, onItemClick)
    }

    override fun onBindViewHolder(responseHolder: SearchResponseHolder, position: Int) {
        responseHolder.setMovieData(movieList?.get(position))
    }

    override fun getItemCount(): Int {
        return movieList?.size ?: 0
    }
}