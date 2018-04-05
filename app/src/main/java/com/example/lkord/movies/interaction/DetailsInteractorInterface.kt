package com.example.lkord.movies.interaction

import com.example.lkord.movies.model.data.Movie

interface DetailsInteractorInterface {

    fun getMovieWithDetails(searchQuery: String? = null, onResult: (Movie) -> Unit)
}