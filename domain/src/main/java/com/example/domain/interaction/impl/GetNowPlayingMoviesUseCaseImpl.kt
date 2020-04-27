package com.example.domain.interaction.impl

import com.example.domain.common.DataResult
import com.example.domain.interaction.GetNowPlayingMoviesUseCase
import com.example.domain.model.Movie
import com.example.domain.repository.MovieRepository
import javax.inject.Inject

class GetNowPlayingMoviesUseCaseImpl @Inject constructor(
    private val repository: MovieRepository) : GetNowPlayingMoviesUseCase {
  override suspend operator fun invoke(): DataResult<List<Movie>> {
    return repository.fetchAndSaveNowPlayingMovies()
  }
}