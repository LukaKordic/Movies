package com.example.lkord.movies.repositories

import com.example.lkord.movies.common.SCHEDULERS_IO
import com.example.lkord.movies.common.SCHEDULERS_MAIN
import com.example.lkord.movies.model.responses.MovieResponse
import com.example.lkord.movies.network.MovieApiService
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(private val movieApiService: MovieApiService,
                                          @Named(SCHEDULERS_IO) private val ioScheduler: Scheduler,
                                          @Named(SCHEDULERS_MAIN) private val mainScheduler: Scheduler) {

    fun getNowPlayingMovies(): Single<MovieResponse> {
        return movieApiService.getNowPlayingMovies()
                .subscribeOn(ioScheduler)
                .observeOn(mainScheduler)
    }
}
