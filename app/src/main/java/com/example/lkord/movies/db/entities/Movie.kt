package com.example.lkord.movies.db.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.example.lkord.movies.common.MOVIE_TABLE
import com.google.gson.annotations.SerializedName

@Entity(tableName = MOVIE_TABLE)
data class Movie(@PrimaryKey private val id: Int,
                 private val title: String,
                 @SerializedName("poster_path") private val posterPath: String)