package com.example.data.networking.model.response

import com.google.gson.annotations.SerializedName

data class MovieResponseWrapper(@SerializedName("results") val movies: List<MovieResponse>)