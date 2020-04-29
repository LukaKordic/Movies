package com.example.domain.interaction.impl

import com.example.domain.common.DataResult
import com.example.domain.interaction.GetShowsUseCase
import com.example.domain.model.Movie
import com.example.domain.repository.MovieRepository
import javax.inject.Inject

class GetShowsUseCaseImpl @Inject constructor(private val repository: MovieRepository) : GetShowsUseCase {
  override suspend operator fun invoke(): DataResult<List<Movie>> {
    return repository.fetchAndSavePopularShows()
  }
}