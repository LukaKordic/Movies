package com.example.domain.repository

import com.example.domain.common.DataResult
import com.example.domain.model.Movie

interface MovieRepository {

  suspend fun fetchAndSaveNowPlayingMovies(): DataResult<List<Movie>>

  suspend fun fetchAndSavePopularMovies(): DataResult<List<Movie>>

  suspend fun getFavouriteMovies(): DataResult<List<Movie>>
}