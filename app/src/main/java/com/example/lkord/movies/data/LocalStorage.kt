package com.example.lkord.movies.data

import com.example.lkord.movies.data.db.entities.Movie
import io.reactivex.Flowable

interface LocalStorage {

    fun storeMovies(movies: List<Movie>)

    fun retrieveMoviesWithType(type: String): Flowable<List<Movie>>
}