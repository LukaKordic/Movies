package com.example.lkord.movies.data

import com.example.lkord.movies.data.db.entities.Movie
import io.reactivex.Flowable

interface LocalStorage {

    fun saveMoviesToDatabase(movies: List<Movie>)

    fun retrieveMoviesFromDatabase(): Flowable<List<Movie>>
}