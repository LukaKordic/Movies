package com.example.lkord.movies.di.modules

import com.example.data.networking.service.MovieApiService
import com.example.data.networking.service.MovieApiServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class ServicesModule {
  
  @Binds
  abstract fun bindMovieApiService(movieApiServiceImpl: MovieApiServiceImpl): MovieApiService
}