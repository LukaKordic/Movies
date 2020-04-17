package com.example.domain.interaction

import com.example.domain.localstorage.LocalStorage
import com.example.domain.model.Movie
import com.example.domain.service.MovieApiService

class GetNowPlayingMoviesUseCaseImpl(
    private val movieApiService: MovieApiService,
    private val localStorage: LocalStorage) : GetNowPlayingMoviesUseCase {
  override fun invoke(): List<Movie> {
    movieApiService.getNowPlayingMovies()
  }
}