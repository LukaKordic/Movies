package com.example.lkord.movies.model.network

import com.example.lkord.movies.model.data.Movie
import com.google.gson.annotations.SerializedName

data class SearchResponse(@SerializedName("Search") val movies: List<Movie>)