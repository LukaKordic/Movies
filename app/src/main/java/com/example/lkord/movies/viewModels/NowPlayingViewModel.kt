package com.example.lkord.movies.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.common.onFailure
import com.example.domain.common.onSuccess
import com.example.domain.interaction.GetNowPlayingMoviesUseCase
import com.example.domain.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class NowPlayingViewModel @Inject constructor(
    private val getNowPlayingMoviesUseCase: GetNowPlayingMoviesUseCase) : ViewModel() {

  private val nowPlayingMovies = MutableLiveData<List<Movie>>()

  fun getNowPlaying() = nowPlayingMovies

  fun fetchNowPlayingMovies() {
    viewModelScope.launch(Dispatchers.IO) {
      getNowPlayingMoviesUseCase()
          .onSuccess { nowPlayingMovies.postValue(it) }
          .onFailure { // TODO: 17/04/2020 showerror
          }
    }
  }
}
