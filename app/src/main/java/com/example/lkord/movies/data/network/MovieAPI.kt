package com.example.lkord.movies.data.network

import com.example.lkord.movies.model.responses.MovieResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY: String = "jfkla;jfkal;fjk;da"

interface MovieAPI {
  
  @GET("movie/now_playing")
  fun getNowPlayingMovies(@Query("api_key") apiKey: String = API_KEY): Single<Response<MovieResponse>>
  
  @GET("movie/popular")
  fun getPopularMovies(@Query("api_key") apiKey: String = API_KEY): Single<Response<MovieResponse>>
}
