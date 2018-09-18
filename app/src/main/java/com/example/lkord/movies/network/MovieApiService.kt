package com.example.lkord.movies.network

import com.example.lkord.movies.model.data.Movie
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieApiService @Inject constructor(private val movieApi: MovieAPI) {

    fun getNowPlayingMovies(): Single<List<Movie>> {
        return movieApi.getNowPlayingMovies().flatMap {
            if (it.isSuccessful) {
                Single.just(it.body())
            } else {
                Single.error(Throwable(it.message()))
            }
        }
    }
}
