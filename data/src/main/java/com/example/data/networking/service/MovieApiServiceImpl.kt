package com.example.data.networking.service

import com.example.data.networking.MovieAPI
import com.example.data.networking.model.response.MovieResponseWrapper
import javax.inject.Inject

class MovieApiServiceImpl @Inject constructor(private val movieApi: MovieAPI) : MovieApiService {

  override suspend fun getNowPlayingMovies(): MovieResponseWrapper {
    return MovieResponseWrapper(emptyList())
  }

  override suspend fun getPopularMovies(): MovieResponseWrapper {
    return MovieResponseWrapper(emptyList())
  }
}
