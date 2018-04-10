package com.example.lkord.movies.presentation

import com.example.lkord.movies.interaction.MoviesInteractorInterface
import com.example.lkord.movies.model.data.Movie
import javax.inject.Inject

class SearchPresenter @Inject constructor(private val interactor: MoviesInteractorInterface) : SearchPresenterInterface {

    override fun loadMovies(searchQuery: String, onResult: (List<Movie>?) -> Unit) {
        interactor.getMovies(searchQuery, onResult)
    }


}