package com.example.lkord.movies.ui.nowPlaying.view

import com.example.domain.model.Movie

sealed class MovieListViewState
class Data(val movies: List<Movie>) : MovieListViewState()
class Error(val error: Throwable) : MovieListViewState()
object Loading : MovieListViewState()