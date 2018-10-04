package com.example.lkord.movies.repositories

import com.example.lkord.movies.data.LocalStorageImpl
import com.example.lkord.movies.data.db.entities.Movie
import com.example.lkord.movies.data.network.services.MovieApiService
import com.example.lkord.movies.model.responses.MovieResponse
import com.example.lkord.movies.util.NOW_PLAYING_TYPE
import com.example.lkord.movies.util.POPULAR_TYPE
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

    fun fetchAndSaveNowPlayingMovies(type: String): Flowable<List<Movie>> {
        return movieApiService.getNowPlayingMovies()
                .doOnSuccess {
                    val typedMovies = it.movies
                    typedMovies.forEach { movie -> movie.movieType = NOW_PLAYING_TYPE }
                    storage.storeMovies(typedMovies)
                }
                .onErrorResumeNext { Single.just(MovieResponse(emptyList())) }
                .flatMapPublisher { storage.retrieveMoviesWithType(type) }
                .subscribeOn(ioScheduler)
                .observeOn(mainScheduler)
    }

    fun fetchAndSavePopularMovies(type: String): Flowable<List<Movie>> {
        return movieApiService.getPopularMovies()
                .doOnSuccess {
                    val typedMovies = it.movies
                    typedMovies.forEach { movie -> movie.movieType = POPULAR_TYPE }
                    storage.storeMovies(typedMovies)
                }
                .onErrorResumeNext { Single.just(MovieResponse(emptyList())) }
                .flatMapPublisher { storage.retrieveMoviesWithType(type) }
                .subscribeOn(ioScheduler)
                .observeOn(mainScheduler)
    }
}
