package com.example.data.database

import com.example.data.database.dao.MovieDao
import com.example.data.database.entity.MovieEntity
import com.example.data.database.entity.mapToDomainModel
import com.example.domain.localstorage.LocalStorage
import com.example.domain.model.Movie

class LocalStorageImpl(private val movieDao: MovieDao) : LocalStorage {
  override fun storeMovies(movies: List<MovieEntity>) = movieDao.saveMovies(movies)

  override fun retrieveMoviesWithType(type: String): List<Movie> = movieDao.fetchMoviesWithType(type)
      .map { it.mapToDomainModel() }
}