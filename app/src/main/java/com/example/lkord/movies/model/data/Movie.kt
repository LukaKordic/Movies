package com.example.lkord.movies.model.data

import com.google.gson.annotations.SerializedName

data class Movie(
        val imdbRating: String,
        @SerializedName("Title") val title: String,
        @SerializedName("Year") val year: String,
        @SerializedName("Runtime") val runtime: String,
        @SerializedName("Genre") val genre: String,
        @SerializedName("Director") val director: String,
        @SerializedName("Actors") val actors: String,
        @SerializedName("Plot") val plot: String,
        @SerializedName("Poster") val poster: String,
        @SerializedName("Type") val type: String
)