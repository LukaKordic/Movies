package com.example.data.database.dao

import com.example.data.common.MOVIE_TABLE
import com.example.data.database.entity.MovieEntity

@androidx.room.Dao
interface MovieDao {

  @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
  fun saveMovies(movies: List<MovieEntity>)

  @androidx.room.Query("SELECT * FROM $MOVIE_TABLE WHERE movieType = :movieType")
  fun fetchMoviesWithType(movieType: String):List<MovieEntity>
}