package com.example.lkord.movies.di.modules

import com.example.domain.interaction.GetFavouritesUseCase
import com.example.domain.interaction.GetMoviesUseCase
import com.example.domain.interaction.GetShowsUseCase
import com.example.domain.interaction.impl.GetFavouritesUseCaseImpl
import com.example.domain.interaction.impl.GetMoviesUseCaseImpl
import com.example.domain.interaction.impl.GetShowsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class InteractionModule {

  @Binds
  abstract fun bindNowPlayingUseCase(getNowPlayingMoviesUseCaseImpl: GetMoviesUseCaseImpl): GetMoviesUseCase

  @Binds
  abstract fun bindPopularMoviesUseCase(getPopularMoviesUseCaseImpl: GetShowsUseCaseImpl): GetShowsUseCase

  @Binds
  abstract fun bindFavouriteMoviesUseCase(getFavouritesUseCaseImpl: GetFavouritesUseCaseImpl): GetFavouritesUseCase
}