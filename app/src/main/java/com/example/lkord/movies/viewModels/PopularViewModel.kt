package com.example.lkord.movies.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.common.onFailure
import com.example.domain.common.onSuccess
import com.example.domain.interaction.GetPopularMoviesUseCase
import com.example.lkord.movies.ui.nowPlaying.view.Data
import com.example.lkord.movies.ui.nowPlaying.view.Error
import com.example.lkord.movies.ui.nowPlaying.view.Loading
import com.example.lkord.movies.ui.nowPlaying.view.MovieListViewState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class PopularViewModel @Inject constructor(private val getPopularMoviesUseCase: GetPopularMoviesUseCase) : ViewModel() {

  private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
    println(throwable.printStackTrace())
    popularViewState.postValue(Error(throwable))
  }
  private val popularViewState = MutableLiveData<MovieListViewState>()

  fun getPopularViewState() = popularViewState

  fun getPopularMovies() {
    popularViewState.postValue(Loading)
    viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
      getPopularMoviesUseCase()
          .onSuccess { popularViewState.postValue(Data(it)) }
          .onFailure { popularViewState.postValue(Error(it)) }
    }
  }
}