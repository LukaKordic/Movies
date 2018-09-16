package com.example.lkord.movies.repositories

import com.example.lkord.movies.network.MovieApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(private val movieApiService: MovieApiService) {
}
