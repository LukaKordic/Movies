package com.example.lkord.movies.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.lkord.movies.model.data.Movie

@Dao
interface MovieDao {
    @Query("SELECT * FROM movie")
    fun getAllMovies(): List<Movie>

    @Insert
    fun insertAll(movies: List<Movie>)
}