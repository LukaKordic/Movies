package com.example.lkord.movies.presentation

import com.example.lkord.movies.model.data.Movie

interface DetailsPresenterInterface {

    fun searchMovieWithDetails(searchQuery: String, onResult: (Movie) -> Unit)

    fun saveMovieToDatabase(movie: Movie)
}