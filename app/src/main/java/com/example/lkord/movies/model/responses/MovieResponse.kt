package com.example.lkord.movies.model.responses

import com.example.lkord.movies.data.db.entities.Movie
import com.google.gson.annotations.SerializedName

data class MovieResponse(@SerializedName("results") val movies: List<Movie>)