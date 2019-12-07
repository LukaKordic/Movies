package com.example.data.database

import com.example.data.database.dao.MovieDao
import com.example.data.database.entity.MovieEntity
import com.example.data.database.entity.mapToDomainModel
import com.example.domain.model.Movie
import javax.inject.Inject

class LocalStorageImpl @Inject constructor(private val movieDao: MovieDao) : LocalStorage {
  override fun storeMovies(movies: List<MovieEntity>) = movieDao.saveMovies(movies)

  override fun retrieveMoviesWithType(type: String): List<Movie> = movieDao.fetchMoviesWithType(type)
      .map { it.mapToDomainModel() }
}