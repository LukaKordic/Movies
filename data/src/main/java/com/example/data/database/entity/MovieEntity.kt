package com.example.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.common.MOVIE_TABLE
import com.example.domain.model.Movie

@Entity(tableName = MOVIE_TABLE)
data class MovieEntity(
    @PrimaryKey
    val id: Int = 0,
    val title: String = "",
    val voteAverage: Double = 0.0,
    val popularity: Double = 0.0,
    val posterPath: String = "",
    val overview: String = "",
    val releaseDate: String = "",
    var movieType: String = ""//now playing, popular or favourite movieType
)

fun MovieEntity.mapToDomainModel() = Movie(id, title, voteAverage, popularity, posterPath, overview, releaseDate)