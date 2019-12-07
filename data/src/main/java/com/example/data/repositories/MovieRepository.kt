package com.example.data.repositories

import com.example.data.common.NOW_PLAYING_TYPE
import com.example.data.common.SCHEDULERS_IO
import com.example.data.common.SCHEDULERS_MAIN
import com.example.data.database.LocalStorage
import com.example.data.networking.model.response.MovieResponseWrapper
import com.example.data.networking.model.response.mapToDbEntity
import com.example.data.networking.service.MovieApiService
import com.example.data.networking.service.MovieApiServiceImpl
import com.example.domain.model.Movie
import io.reactivex.Flowable
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(private val movieApiService: MovieApiService,
                                          private val storage: LocalStorage,
                                          @Named(SCHEDULERS_IO) private val ioScheduler: Scheduler,
                                          @Named(SCHEDULERS_MAIN) private val mainScheduler: Scheduler) {

  fun fetchAndSaveNowPlayingMovies(): Flowable<List<Movie>> {
    return movieApiService.getNowPlayingMovies()
        .doOnSuccess { responseMovies ->
          responseMovies.results.map { movie -> movie.mapToDbEntity() }.also { storage.storeMovies(it) }
        }
        .onErrorResumeNext { Single.just(MovieResponseWrapper(emptyList())) }
        .flatMapPublisher { storage.retrieveMoviesWithType(NOW_PLAYING_TYPE) }
        .subscribeOn(ioScheduler)
        .observeOn(mainScheduler)
  }

  fun fetchAndSavePopularMovies(type: String): Flowable<List<Movie>> {
    return movieApiService.getPopularMovies()
        .doOnSuccess { responseMovies ->
          responseMovies.results.map { movie -> movie.mapToDbEntity() }.also { storage.storeMovies(it) }
        }
        .onErrorResumeNext { Single.just(MovieResponseWrapper(emptyList())) }
        .flatMapPublisher { storage.retrieveMoviesWithType(type) }
        .subscribeOn(ioScheduler)
        .observeOn(mainScheduler)
  }
}