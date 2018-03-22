package com.example.lkord.movies.repository.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.example.lkord.movies.repository.dataobjects.Movie

@Dao
interface UserDao {
    @Query("SELECT * FROM movie")
    fun getAllMovies(): List<Movie>
}