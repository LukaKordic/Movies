package com.example.lkord.movies.data

import com.example.lkord.movies.data.db.daos.MovieDao
import com.example.lkord.movies.data.db.entities.Movie
import io.reactivex.Flowable
import javax.inject.Inject

class LocalStorageImpl @Inject constructor(private val movieDao: MovieDao) : LocalStorage {
    override fun storeMovies(movies: List<Movie>) = movieDao.saveMovies(movies)

    override fun retrieveMoviesWithType(type: String): Flowable<List<Movie>> = movieDao.fetchMoviesWithType(type)
}