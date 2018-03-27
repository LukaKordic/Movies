package com.example.lkord.movies.interaction

import com.example.lkord.movies.model.data.Movie

interface MoviesInteractorInterface {

    fun getMovies(page: Int, searchQuery: String? = null, onResult: (List<Movie>) -> Unit)
}