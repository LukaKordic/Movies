package com.example.data.networking.service

import com.example.data.networking.model.response.MovieResponseWrapper

interface MovieApiService {

  suspend fun getNowPlayingMovies(): MovieResponseWrapper

  suspend fun getPopularMovies(): MovieResponseWrapper
}