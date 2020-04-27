package com.example.domain.interaction.impl

import com.example.domain.common.DataResult
import com.example.domain.interaction.GetFavouritesUseCase
import com.example.domain.model.Movie
import com.example.domain.repository.MovieRepository
import javax.inject.Inject

class GetFavouritesUseCaseImpl @Inject constructor(private val movieRepository: MovieRepository) : GetFavouritesUseCase {
  override suspend fun invoke(): DataResult<List<Movie>> {
    return movieRepository.getFavouriteMovies()
  }
}