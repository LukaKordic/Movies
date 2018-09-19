package com.example.lkord.movies.ui.search.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lkord.movies.R
import com.example.lkord.movies.db.entities.Movie
import com.example.lkord.movies.ui.search.holders.SearchResponseHolder

class SearchRecyclerAdapter(private val onItemClick: (Movie) -> Unit) : RecyclerView.Adapter<SearchResponseHolder>() {

    private val movies = mutableListOf<Movie>()

    fun addMovies(data: List<Movie>) {
        movies.clear()
        movies.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResponseHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.response_item_layout, parent, false)
        return SearchResponseHolder(view, onItemClick)
    }

    override fun onBindViewHolder(responseHolder: SearchResponseHolder, position: Int) {
        responseHolder.setMovieData(movies[position])
    }

    override fun getItemCount() = movies.size
}