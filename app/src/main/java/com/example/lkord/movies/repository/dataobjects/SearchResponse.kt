package com.example.lkord.movies.repository.dataobjects

import com.google.gson.annotations.SerializedName

data class SearchResponse(@SerializedName("Search") val movies: List<Movie>)