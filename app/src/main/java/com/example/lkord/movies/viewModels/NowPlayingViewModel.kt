package com.example.lkord.movies.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.common.onFailure
import com.example.domain.common.onSuccess
import com.example.domain.interaction.GetNowPlayingMoviesUseCase
import com.example.lkord.movies.ui.nowPlaying.view.Data
import com.example.lkord.movies.ui.nowPlaying.view.Error
import com.example.lkord.movies.ui.nowPlaying.view.Loading
import com.example.lkord.movies.ui.nowPlaying.view.MovieListViewState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class NowPlayingViewModel @Inject constructor(
    private val getNowPlayingMoviesUseCase: GetNowPlayingMoviesUseCase) : ViewModel() {

  private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
    println(throwable.printStackTrace())
    nowPlayingViewState.postValue(Error(throwable))
  }

  private val nowPlayingViewState = MutableLiveData<MovieListViewState>()

  fun getNowPlayingViewState() = nowPlayingViewState

  fun fetchNowPlayingMovies() {
    nowPlayingViewState.postValue(Loading)
    viewModelScope.launch(coroutineExceptionHandler + Dispatchers.IO) {// TODO: 20/04/2020 move this IO switch further down the call chain (repository)
      getNowPlayingMoviesUseCase()
          .onSuccess { nowPlayingViewState.postValue(Data(it)) }
          .onFailure { nowPlayingViewState.postValue(Error(it)) }
    }
  }
}
