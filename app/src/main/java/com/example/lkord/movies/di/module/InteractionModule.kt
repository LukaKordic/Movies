package com.example.lkord.movies.di.module

import com.example.lkord.movies.interaction.*
import dagger.Binds
import dagger.Module

@Module(includes = [(NetworkingModule::class)])
abstract class InteractionModule {

    @Binds
    abstract fun moviesInteractor(moviesInteractor: MoviesInteractor): MoviesInteractorInterface

    @Binds
    abstract fun detailsInteractor(detailsInteractor: DetailsInteractor): DetailsInteractorInterface

    @Binds
    abstract fun favoritesInteractor(favoritesInteractor: FavoritesInteractor): FavoritesInteractorInterface
}