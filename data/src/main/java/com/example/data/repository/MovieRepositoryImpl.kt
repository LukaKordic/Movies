package com.example.data.repository

import com.example.data.common.*
import com.example.data.database.localstorage.LocalStorage
import com.example.data.networking.model.response.mapToDbEntity
import com.example.data.networking.model.response.mapToDomainModel
import com.example.data.networking.service.MovieApiService
import com.example.domain.common.*
import com.example.domain.model.Movie
import com.example.domain.repository.MovieRepository
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepositoryImpl @Inject constructor(
    private val movieApiService: MovieApiService,
    private val localStorage: LocalStorage,
    private val connectivity: Connectivity,
    private val coroutineContextProvider: CoroutineContextProvider,
    private val coroutineExceptionHandler: CoroutineExceptionHandler) : MovieRepository {
  
  override suspend fun fetchAndSaveNowPlayingMovies(): DataResult<List<Movie>> {
    return withContext(coroutineContextProvider.io + coroutineExceptionHandler) {
      if (connectivity.hasNetworkAccess()) {
        getNowPlayingMoviesFromApi()
      } else {
        Success(localStorage.retrieveMoviesWithType(NOW_PLAYING_TYPE))
      }
    }
  }
  
  override suspend fun fetchAndSavePopularMovies(): DataResult<List<Movie>> {
    return withContext(coroutineContextProvider.io + coroutineExceptionHandler) {
      if (connectivity.hasNetworkAccess()) {
        getPopularMoviesFromApi()
      } else {
        Success(localStorage.retrieveMoviesWithType(POPULAR_TYPE))
      }
    }
  }
  
  override suspend fun getFavouriteMovies(): DataResult<List<Movie>> {
    return withContext(coroutineContextProvider.io + coroutineExceptionHandler) {
      try {
        Success(localStorage.retrieveMoviesWithType(FAVOURITES))
      } catch (e: Exception) {
        Failure(Throwable(e))
      }
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