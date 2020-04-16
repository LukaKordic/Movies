package com.example.data.networking

import com.example.data.BuildConfig
import com.example.data.networking.model.response.MovieResponseWrapper
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {

  @GET("movie/now_playing")
  suspend fun getNowPlayingMovies(@Query("api_key") apiKey: String = BuildConfig.TMDB_API_TOKEN): Response<MovieResponseWrapper>

  @GET("movie/popular")
  suspend fun getPopularMovies(@Query("api_key") apiKey: String = BuildConfig.TMDB_API_TOKEN): Response<MovieResponseWrapper>
}