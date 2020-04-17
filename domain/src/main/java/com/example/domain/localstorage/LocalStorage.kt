package com.example.domain.localstorage

import com.example.data.database.entity.MovieEntity
import com.example.domain.model.Movie

interface LocalStorage {

  fun storeMovies(movies: List<MovieEntity>)

  fun retrieveMoviesWithType(type: String): List<Movie>
}