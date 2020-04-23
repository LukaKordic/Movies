package com.example.lkord.movies.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.domain.common.onFailure
import com.example.domain.common.onSuccess
import com.example.domain.interaction.GetNowPlayingMoviesUseCase
import com.example.lkord.movies.ui.nowPlaying.view.Data
import com.example.lkord.movies.ui.nowPlaying.view.Error
import com.example.lkord.movies.ui.nowPlaying.view.MovieListViewState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class NowPlayingViewModel @Inject constructor(
    private val getNowPlayingMoviesUseCase: GetNowPlayingMoviesUseCase) : ViewModel() {

  private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
    println(throwable.printStackTrace())
  }

  val nowPlayingViewState = liveData<MovieListViewState>(coroutineExceptionHandler + Dispatchers.IO) {
    getNowPlayingMoviesUseCase()
        .onSuccess { emit(Data(it)) }
        .onFailure { emit(Error(it)) }
  }
}
