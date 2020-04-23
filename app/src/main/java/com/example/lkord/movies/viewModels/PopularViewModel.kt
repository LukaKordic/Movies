package com.example.lkord.movies.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.domain.common.onFailure
import com.example.domain.common.onSuccess
import com.example.domain.interaction.GetPopularMoviesUseCase
import com.example.lkord.movies.ui.nowPlaying.view.Data
import com.example.lkord.movies.ui.nowPlaying.view.Error
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class PopularViewModel @Inject constructor(private val getPopularMoviesUseCase: GetPopularMoviesUseCase) : ViewModel() {

  private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
    println(throwable.printStackTrace())
  }
  val popularViewState = liveData(coroutineExceptionHandler + Dispatchers.IO) {
    getPopularMoviesUseCase()
        .onSuccess { emit(Data(it)) }
        .onFailure { emit(Error(it)) }
  }
}