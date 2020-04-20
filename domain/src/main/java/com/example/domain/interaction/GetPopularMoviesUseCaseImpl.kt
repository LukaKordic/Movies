package com.example.domain.interaction

import com.example.domain.common.DataResult
import com.example.domain.model.Movie
import com.example.domain.repository.MovieRepository
import javax.inject.Inject

class GetPopularMoviesUseCaseImpl @Inject constructor(private val repository: MovieRepository) : GetPopularMoviesUseCase {
  override suspend operator fun invoke(): DataResult<List<Movie>> {
    return repository.fetchAndSavePopularMovies()
  }
}