package com.example.lkord.movies.ui.home.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lkord.movies.R
import com.example.lkord.movies.dataobjects.Movie
import com.example.lkord.movies.ui.home.holders.MovieResponseHolder

class HomeRecyclerAdapter(private val movieList: List<Movie>) : RecyclerView.Adapter<MovieResponseHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieResponseHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.movie_item_layout, parent, false)
        return MovieResponseHolder(view)
    }

    override fun onBindViewHolder(responseHolder: MovieResponseHolder, position: Int) {
        responseHolder.setMovieData(movieList[position])
    }


    override fun getItemCount(): Int {
        return movieList.size
    }
}