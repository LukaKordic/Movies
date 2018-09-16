package com.example.lkord.movies.viewModels

import android.arch.lifecycle.ViewModel
import com.example.lkord.movies.repositories.MovieRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainViewModel @Inject constructor(private val movieRepository: MovieRepository) : ViewModel()
