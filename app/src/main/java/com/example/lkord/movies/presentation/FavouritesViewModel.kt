package com.example.lkord.movies.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.domain.common.onFailure
import com.example.domain.common.onSuccess
import com.example.domain.interaction.GetFavouritesUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class FavouritesViewModel @Inject constructor(private val getFavouritesUseCase: GetFavouritesUseCase) : ViewModel() {

  private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
    println(throwable.printStackTrace())
  }

  val favouriteMovies = liveData(Dispatchers.IO + coroutineExceptionHandler) {
    getFavouritesUseCase()
        .onSuccess { emit(it) }
        .onFailure { emit(it) }
  }
}