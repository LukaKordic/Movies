package com.example.domain.interaction

import com.example.domain.model.Movie

interface GetNowPlayingMoviesUseCase {
  operator fun invoke(): List<Movie>
}