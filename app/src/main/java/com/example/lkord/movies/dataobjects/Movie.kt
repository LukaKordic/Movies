package com.example.lkord.movies.dataobjects

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Movie(
        @SerializedName("Title") val title: String, @SerializedName("Year") val year: String,
        @SerializedName("Runtime") val runtime: String, @SerializedName("Genre") val genre: String, @SerializedName("Director") val director: String,
        @SerializedName("Actors") val actors: String, @SerializedName("Plot") val plot: String,
        @SerializedName("Poster") val poster: String, @ColumnInfo(name = "imdb_rating") val imdbRating: String, @SerializedName(
                "Type"
        ) val type: String, @PrimaryKey(autoGenerate = true) val uid: Int
)