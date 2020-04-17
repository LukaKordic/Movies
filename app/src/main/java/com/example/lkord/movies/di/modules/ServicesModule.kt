package com.example.lkord.movies.di.modules

import com.example.domain.service.MovieApiService
import com.example.data.networking.service.MovieApiServiceImpl
import dagger.Binds
import dagger.Module

@Module(includes = [NetworkingModule::class])
abstract class ServicesModule {

  @Binds
  abstract fun bindMovieApiService(movieApiServiceImpl: MovieApiServiceImpl): MovieApiService
}