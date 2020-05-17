package com.example.lkord.movies.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.domain.common.onFailure
import com.example.domain.common.onSuccess
import com.example.domain.interaction.GetMoviesUseCase
import com.example.lkord.movies.ui.Data
import com.example.lkord.movies.ui.Error
import com.example.lkord.movies.ui.Loading
import javax.inject.Inject

class MoviesViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase) : ViewModel() {
  
  val moviesViewState = liveData {
    emit(Loading)
    getMoviesUseCase()
        .onSuccess { emit(Data(it)) }
        .onFailure { emit(Error(it)) }
  }
}
