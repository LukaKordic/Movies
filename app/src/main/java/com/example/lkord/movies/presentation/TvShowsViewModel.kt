package com.example.lkord.movies.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.domain.common.onFailure
import com.example.domain.common.onSuccess
import com.example.domain.interaction.GetShowsUseCase
import com.example.lkord.movies.ui.Data
import com.example.lkord.movies.ui.Error
import com.example.lkord.movies.ui.Loading
import javax.inject.Inject

class TvShowsViewModel @Inject constructor(private val getShowsUseCase: GetShowsUseCase) : ViewModel() {
  
  val popularViewState = liveData {
    emit(Loading)
    getShowsUseCase()
        .onSuccess { emit(Data(it)) }
        .onFailure { emit(Error(it)) }
  }
}