package com.example.data.networking.service

import com.example.data.networking.model.response.MovieResponseWrapper
import com.example.domain.common.DataResult

interface MovieApiService {
  
  suspend fun getPopularShows(): DataResult<MovieResponseWrapper>

  suspend fun getPopularMovies(): DataResult<MovieResponseWrapper>
}