package com.example.data.networking.service

import com.example.data.networking.MovieAPI
import com.example.data.networking.model.response.MovieResponseWrapper
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

class MovieApiServiceImpl @Inject constructor(private val movieApi: MovieAPI) : MovieApiService {

  override fun getNowPlayingMovies(): Single<MovieResponseWrapper> {
    return movieApi.getNowPlayingMovies().flatMap {
      if (it.isSuccessful) {
        Single.just(it.body())
      } else {
        Single.error(Throwable(it.message()))
      }
    }
  }

  override fun getPopularMovies(): Single<MovieResponseWrapper> {
    return movieApi.getPopularMovies().flatMap {
      if (it.isSuccessful) {
        Single.just(it.body())
      } else {
        Single.error(Throwable(it.message()))
      }
    }
  }
}
