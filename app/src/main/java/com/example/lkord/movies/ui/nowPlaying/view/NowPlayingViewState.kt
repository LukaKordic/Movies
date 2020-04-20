package com.example.lkord.movies.ui.nowPlaying.view

import com.example.domain.model.Movie

sealed class NowPlayingViewState
class Data(val movies: List<Movie>) : NowPlayingViewState()
class Error(val error: Throwable) : NowPlayingViewState()
object Loading : NowPlayingViewState()