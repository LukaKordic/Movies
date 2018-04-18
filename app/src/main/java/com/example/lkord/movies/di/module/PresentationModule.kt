package com.example.lkord.movies.di.module

import com.example.lkord.movies.presentation.*
import dagger.Binds
import dagger.Module

@Module(includes = [InteractionModule::class])
abstract class
PresentationModule {

    @Binds
    abstract fun searchPresenter(searchPresenter: SearchPresenter): SearchPresenterInterface

    @Binds
    abstract fun detailsPresenter(detailsPresenter: DetailsPresenter): DetailsPresenterInterface

    @Binds
    abstract fun favoritesPresenter(favoritesPresenter: FavoritesPresenter): FavoritesPresenterInterface
}