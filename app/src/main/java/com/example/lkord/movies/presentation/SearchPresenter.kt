package com.example.lkord.movies.presentation

import com.example.lkord.movies.interaction.MoviesInteractorInterface
import javax.inject.Inject

class SearchPresenter @Inject constructor(private val interactor: MoviesInteractorInterface) : SearchPresenterInterface {
}