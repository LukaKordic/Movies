package com.example.lkord.movies.presentation

import com.example.lkord.movies.interaction.FavoritesInteractorInterface
import javax.inject.Inject

class FavoritesPresenter @Inject constructor(private val favoritesInteractor: FavoritesInteractorInterface)
    : FavoritesPresenterInterface {

    override fun getFavoriteMovies() {
        favoritesInteractor.getFavoriteMovies()
    }
}