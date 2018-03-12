package com.example.lkord.movies.dataobjects

import com.google.gson.annotations.SerializedName

data class Movie(@SerializedName("Title") val title: String, @SerializedName("Year") val year: Int,
                 @SerializedName("Released") val released: String, @SerializedName("Runtime") val runtime: Int,
                 @SerializedName("Genre") val genre: String, @SerializedName("Director") val director: String,
                 @SerializedName("Actors") val actors: String, @SerializedName("Plot") val plot: String,
                 @SerializedName("Poster") val poster: String, val imdbRating: String)