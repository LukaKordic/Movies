package com.example.lkord.movies.di.modules

import com.example.domain.interaction.GetNowPlayingMoviesUseCase
import com.example.domain.interaction.GetNowPlayingMoviesUseCaseImpl
import com.example.domain.interaction.GetPopularMoviesUseCase
import com.example.domain.interaction.GetPopularMoviesUseCaseImpl
import dagger.Binds
import dagger.Module

@Module(includes = [RepositoryModule::class])
abstract class InteractionModule {

  @Binds
  abstract fun bindNowPlayingUseCase(getNowPlayingMoviesUseCaseImpl: GetNowPlayingMoviesUseCaseImpl): GetNowPlayingMoviesUseCase

  @Binds
  abstract fun bindPopularMoviesUseCase(getPopularMoviesUseCaseImpl: GetPopularMoviesUseCaseImpl): GetPopularMoviesUseCase
}