package com.example.domain.interaction

import com.example.domain.common.DataResult
import com.example.domain.model.Movie

interface GetNowPlayingMoviesUseCase {
  suspend operator fun invoke(): DataResult<List<Movie>>
}