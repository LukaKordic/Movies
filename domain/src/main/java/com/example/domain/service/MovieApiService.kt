package com.example.domain.service

import com.example.data.networking.model.response.MovieResponseWrapper
import com.example.domain.common.NetworkResult

interface MovieApiService {

  suspend fun getNowPlayingMovies(): NetworkResult<MovieResponseWrapper>

  suspend fun getPopularMovies(): NetworkResult<MovieResponseWrapper>
}