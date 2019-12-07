package com.example.data.database

import com.example.data.database.entity.MovieEntity
import com.example.domain.model.Movie

interface LocalStorage {

  fun storeMovies(movies: List<MovieEntity>)

  fun retrieveMoviesWithType(type: String): List<Movie>
}