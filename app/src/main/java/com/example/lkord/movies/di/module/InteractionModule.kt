package com.example.lkord.movies.di.module

import com.example.lkord.movies.interaction.MoviesInteractor
import com.example.lkord.movies.interaction.MoviesInteractorInterface
import dagger.Binds
import dagger.Module

@Module(includes = [(NetworkingModule::class)])
abstract class InteractionModule {

    @Binds
    abstract fun moviesInteractor(moviesInteractor: MoviesInteractor): MoviesInteractorInterface
}