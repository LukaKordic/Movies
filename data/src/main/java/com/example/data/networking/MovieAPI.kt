package com.example.data.networking

import com.example.data.networking.model.response.MovieResponseWrapper
import retrofit2.Response
import retrofit2.http.GET

interface MovieAPI {

  @GET("movie/now_playing")
  suspend fun getNowPlayingMovies(): Response<MovieResponseWrapper>

  @GET("movie/popular")
  suspend fun getPopularMovies(): Response<MovieResponseWrapper>
}