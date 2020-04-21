package com.example.data.repository

import com.example.data.common.Connectivity
import com.example.data.common.NOW_PLAYING_TYPE
import com.example.data.common.POPULAR_TYPE
import com.example.data.database.localstorage.LocalStorage
import com.example.data.networking.model.response.mapToDbEntity
import com.example.data.networking.model.response.mapToDomainModel
import com.example.data.networking.service.MovieApiService
import com.example.domain.common.*
import com.example.domain.model.Movie
import com.example.domain.repository.MovieRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepositoryImpl @Inject constructor(
    private val movieApiService: MovieApiService,
    private val localStorage: LocalStorage,
    private val connectivity: Connectivity) : MovieRepository {

  override suspend fun fetchAndSaveNowPlayingMovies(): DataResult<List<Movie>> {
    return if (connectivity.hasNetworkAccess()) {
      getNowPlayingMoviesFromApi()
    } else {
      Success(localStorage.retrieveMoviesWithType(NOW_PLAYING_TYPE))
    }
  }

  override suspend fun fetchAndSavePopularMovies(): DataResult<List<Movie>> {
    return if (connectivity.hasNetworkAccess()) {
      getPopularMoviesFromApi()
    } else {
      Success(localStorage.retrieveMoviesWithType(POPULAR_TYPE))
    }
  }

  private suspend fun getPopularMoviesFromApi(): DataResult<List<Movie>> {
    movieApiService.getPopularMovies()
        .onSuccess {
          localStorage.storeMovies(it.movies.map { movieResponse ->
            movieResponse.mapToDbEntity().also { movieEntity -> movieEntity.movieType = POPULAR_TYPE }
          })
          return Success(it.movies.map { movieResponse -> movieResponse.mapToDomainModel() })
        }
        .onFailure { return Failure(it) }
    return Failure(Throwable())
  }

  private suspend fun getNowPlayingMoviesFromApi(): DataResult<List<Movie>> {
    movieApiService.getNowPlayingMovies().onSuccess {
      localStorage.storeMovies(it.movies.map { movieResponse ->
        movieResponse.mapToDbEntity().also { movieEntity -> movieEntity.movieType = NOW_PLAYING_TYPE }
      })
      return Success(it.movies.map { movieResponse -> movieResponse.mapToDomainModel() })
    }.onFailure { return Failure(it) }

    return Failure(Throwable())
  }
}