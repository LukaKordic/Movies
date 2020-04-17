package com.example.data.networking.service

import com.example.data.networking.MovieAPI
import com.example.data.networking.model.response.MovieResponseWrapper
import com.example.domain.common.Failure
import com.example.domain.common.DataResult
import com.example.domain.common.Success
import javax.inject.Inject

class MovieApiServiceImpl @Inject constructor(private val movieApi: MovieAPI) : MovieApiService {

  override suspend fun getNowPlayingMovies(): DataResult<MovieResponseWrapper> {
    movieApi.getNowPlayingMovies().run {
      body()?.let { return Success(it) }
      errorBody()?.let { return Failure(Throwable(message())) }
    }

    return Failure(KotlinNullPointerException()) // This should never happen.
  }

  override suspend fun getPopularMovies(): DataResult<MovieResponseWrapper> {
    movieApi.getPopularMovies().run {
      body()?.let { return Success(it) }
      errorBody()?.let { return Failure(Throwable(message())) }
    }

    return Failure(KotlinNullPointerException()) // This should never happen.
  }
}
