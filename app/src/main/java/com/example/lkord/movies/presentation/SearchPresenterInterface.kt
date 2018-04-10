package com.example.lkord.movies.presentation

import com.example.lkord.movies.model.data.Movie

interface SearchPresenterInterface {

    fun loadMovies(searchQuery: String, onResult: (List<Movie>?) -> Unit)
}