package com.example.lkord.movies.data.db.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.example.lkord.movies.util.MOVIE_TABLE
import com.google.gson.annotations.SerializedName

@Entity(tableName = MOVIE_TABLE)
data class Movie(@PrimaryKey val id: Int,
                 val title: String,
                 @SerializedName("poster_path")
                 val posterPath: String,
                 @SerializedName("release_date") val releaseDate: String)