package com.example.data.networking.model.response

import com.example.data.database.entity.MovieEntity
import com.google.gson.annotations.SerializedName

data class MovieResponse(
    val id: Int = 0,
    val title: String = "",
    @SerializedName("vote_average")
    val voteAverage: Double = 0.0,
    val popularity: Double = 0.0,
    @SerializedName("poster_path")
    val posterPath: String = "",
    val overview: String = "",
    @SerializedName("release_date")
    val releaseDate: String = ""
)

fun MovieResponse.mapToDbEntity() = MovieEntity(id, title, voteAverage, popularity, posterPath, overview, releaseDate)