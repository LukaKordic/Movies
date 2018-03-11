package com.example.lkord.movies.ui.home.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lkord.movies.R
import com.example.lkord.movies.dataobjects.Movie
import com.example.lkord.movies.ui.home.holders.MovieHolder

class RecyclerAdapter : RecyclerView.Adapter<MovieHolder>() {

    val movieList = ArrayList<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.movie_item_layout, parent, false)
        return MovieHolder(view)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.setMovieData(movieList[position])
    }


    override fun getItemCount(): Int {

    }
}