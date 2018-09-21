package com.example.lkord.movies.repositories

import com.example.lkord.movies.data.LocalStorageImpl
import com.example.lkord.movies.data.db.entities.Movie
import com.example.lkord.movies.data.network.services.MovieApiService
import com.example.lkord.movies.model.responses.MovieResponse
import com.example.lkord.movies.util.SCHEDULERS_IO
import com.example.lkord.movies.util.SCHEDULERS_MAIN
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

    fun getNowPlayingMovies(): Flowable<List<Movie>> {
        return movieApiService.getNowPlayingMovies()
                .doOnSuccess {
                    storage.saveMoviesToDatabase(it.movies)
                }
                .onErrorResumeNext { Single.just(MovieResponse(emptyList())) }
                .flatMapPublisher { storage.retrieveMoviesFromDatabase() }
                .subscribeOn(ioScheduler)
                .observeOn(mainScheduler)
    }
}
