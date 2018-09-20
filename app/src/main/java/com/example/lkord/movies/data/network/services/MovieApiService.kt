package com.example.lkord.movies.data.network.services

import com.example.lkord.movies.model.responses.MovieResponse
import com.example.lkord.movies.data.network.MovieAPI
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieApiService @Inject constructor(private val movieApi: MovieAPI) {

    fun getNowPlayingMovies(): Single<MovieResponse> {
        return movieApi.getNowPlayingMovies().flatMap {
            if (it.isSuccessful) {
                Single.just(it.body())
            } else {
                Single.error(Throwable(it.message()))
            }
        }
    }
}
