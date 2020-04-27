package com.example.lkord.movies.di.modules

import com.example.domain.interaction.GetFavouritesUseCase
import com.example.domain.interaction.GetNowPlayingMoviesUseCase
import com.example.domain.interaction.GetPopularMoviesUseCase
import com.example.domain.interaction.impl.GetFavouritesUseCaseImpl
import com.example.domain.interaction.impl.GetNowPlayingMoviesUseCaseImpl
import com.example.domain.interaction.impl.GetPopularMoviesUseCaseImpl
import dagger.Binds
import dagger.Module

@Module(includes = [RepositoryModule::class])
abstract class InteractionModule {

  @Binds
  abstract fun bindNowPlayingUseCase(getNowPlayingMoviesUseCaseImpl: GetNowPlayingMoviesUseCaseImpl): GetNowPlayingMoviesUseCase

  @Binds
  abstract fun bindPopularMoviesUseCase(getPopularMoviesUseCaseImpl: GetPopularMoviesUseCaseImpl): GetPopularMoviesUseCase

  @Binds
  abstract fun bindFavouriteMoviesUseCase(getFavouritesUseCaseImpl: GetFavouritesUseCaseImpl): GetFavouritesUseCase
}