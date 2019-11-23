package com.example.lkord.movies.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.lkord.movies.util.MOVIE_TABLE
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = MOVIE_TABLE)
data class Movie(@PrimaryKey
                 val id: Int,
                 val title: String,
                 @SerializedName("vote_average")
                 val voteAverage: Double,
                 val popularity: Double,
                 @SerializedName("poster_path")
                 val posterPath: String,
                 val overview: String,
                 @SerializedName("release_date")
                 val releaseDate: String,
                 var movieType: String//now playing, popular or favourite movieType
) : Serializable