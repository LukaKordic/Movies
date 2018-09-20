package com.example.lkord.movies.repositories

import com.example.lkord.movies.common.SCHEDULERS_IO
import com.example.lkord.movies.common.SCHEDULERS_MAIN
import com.example.lkord.movies.data.LocalStorageImpl
import com.example.lkord.movies.data.db.entities.Movie
import com.example.lkord.movies.data.network.services.MovieApiService
import io.reactivex.Flowable
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(private val movieApiService: MovieApiService,
                                          private val storage: LocalStorageImpl,
                                          @Named(SCHEDULERS_IO) private val ioScheduler: Scheduler,
                                          @Named(SCHEDULERS_MAIN) private val mainScheduler: Scheduler) {

    fun getNowPlayingMovies(): Single<List<Movie>> {
        return movieApiService.getNowPlayingMovies()
                .flatMap {
                    Single.just(it.movies)
                }
                .subscribeOn(ioScheduler)
                .observeOn(mainScheduler)
    }
}
