package com.example.data.networking

import com.example.data.TMDB_API_KEY
import com.example.data.networking.model.response.MovieResponse
import com.example.data.networking.model.response.MovieResponseWrapper
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY: String = TMDB_API_KEY

interface MovieAPI {

  @GET("movie/now_playing")
  fun getNowPlayingMovies(@Query("api_key") apiKey: String = API_KEY): Single<Response<MovieResponseWrapper>>

  @GET("movie/popular")
  fun getPopularMovies(@Query("api_key") apiKey: String = API_KEY): Single<Response<MovieResponseWrapper>>
}