package com.example.lkord.movies.model.responses

import com.example.lkord.movies.db.entities.Movie

data class MovieResponse(val results: List<Movie>)