package com.example.lkord.movies.db.daos

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.graphics.Movie
import com.example.lkord.movies.common.MOVIE_TABLE
import io.reactivex.Flowable

@Dao
interface MovieDao {

    @Insert
    fun saveMovies(movies: List<Movie>)

    @Query("SELECT * FROM $MOVIE_TABLE")
    fun fetchMovies(): Flowable<Movie>
}