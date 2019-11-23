package com.example.lkord.movies.data.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.lkord.movies.util.MOVIE_TABLE
import com.example.lkord.movies.data.db.entities.Movie
import io.reactivex.Flowable

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveMovies(movies: List<Movie>)

    @Query("SELECT * FROM $MOVIE_TABLE WHERE movieType = :movieType")
    fun fetchMoviesWithType(movieType: String): Flowable<List<Movie>>
}