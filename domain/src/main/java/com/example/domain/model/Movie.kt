package com.example.domain.model

import java.io.Serializable

data class Movie(
    val id: Int,
    val title: String,
    val voteAverage: Double,
    val popularity: Double,
    val posterPath: String,
    val overview: String,
    val releaseDate: String
) : Serializable