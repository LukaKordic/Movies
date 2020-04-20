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
import com.example.lkord.movies.ui.nowPlaying.view.NowPlayingViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class NowPlayingViewModel @Inject constructor(
    private val getNowPlayingMoviesUseCase: GetNowPlayingMoviesUseCase) : ViewModel() {

  private val nowPlayingMovies = MutableLiveData<NowPlayingViewState>()

  fun getNowPlaying() = nowPlayingMovies

  fun fetchNowPlayingMovies() {
    nowPlayingMovies.postValue(Loading)
    viewModelScope.launch(Dispatchers.IO) {// TODO: 20/04/2020 move this IO switch further down the call chain (repository)
      getNowPlayingMoviesUseCase()
          .onSuccess { nowPlayingMovies.postValue(Data(it)) }
          .onFailure { nowPlayingMovies.postValue(Error(it)) }
    }
  }
}
