package com.example.domain.interaction

import com.example.domain.model.Movie

interface GetPopularMoviesUseCase {
  operator fun invoke(): List<Movie>
}