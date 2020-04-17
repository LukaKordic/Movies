package com.example.lkord.movies.di.modules

import com.example.data.repository.MovieRepositoryImpl
import com.example.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module

@Module(includes = [DatabaseModule::class, ServicesModule::class])
abstract class RepositoryModule {

  @Binds
  abstract fun bindMovieRepository(movieRepositoryImpl: MovieRepositoryImpl): MovieRepository
}