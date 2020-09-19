package com.example.lkord.movies.presentation

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.domain.common.onFailure
import com.example.domain.common.onSuccess
import com.example.domain.interaction.GetShowsUseCase
import com.example.lkord.movies.ui.Data
import com.example.lkord.movies.ui.Error
import com.example.lkord.movies.ui.Loading

class TvShowsViewModel @ViewModelInject constructor(private val getShowsUseCase: GetShowsUseCase) : ViewModel() {
  
  val popularViewState = liveData {
    emit(Loading)
    getShowsUseCase()
      .onSuccess { emit(Data(it)) }
      .onFailure { emit(Error(it)) }
  }
}