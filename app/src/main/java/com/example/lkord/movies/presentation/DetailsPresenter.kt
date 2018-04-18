package com.example.lkord.movies.presentation

import com.example.lkord.movies.interaction.DetailsInteractorInterface
import com.example.lkord.movies.model.data.Movie
import javax.inject.Inject

class DetailsPresenter @Inject constructor(private val interactor: DetailsInteractorInterface) : DetailsPresenterInterface {

    override fun saveMovieToDatabase(movie: Movie) {
        interactor.saveMovieToDatabase(movie)
    }

    override fun searchMovieWithDetails(searchQuery: String, onResult: (Movie) -> Unit) {
        interactor.getMovieWithDetails(searchQuery, onResult)
    }
}