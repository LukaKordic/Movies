package com.example.lkord.movies.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.domain.common.onFailure
import com.example.domain.common.onSuccess
import com.example.domain.interaction.GetPopularMoviesUseCase
import com.example.lkord.movies.ui.toprated.view.Data
import com.example.lkord.movies.ui.toprated.view.Error
import com.example.lkord.movies.ui.toprated.view.Loading
import javax.inject.Inject

class PopularViewModel @Inject constructor(private val getPopularMoviesUseCase: GetPopularMoviesUseCase) : ViewModel() {
  
  val popularViewState = liveData {
    emit(Loading)
    getPopularMoviesUseCase()
        .onSuccess { emit(Data(it)) }
        .onFailure { emit(Error(it)) }
  }
}