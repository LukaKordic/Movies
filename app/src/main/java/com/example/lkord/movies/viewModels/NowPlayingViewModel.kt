package com.example.lkord.movies.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.model.Movie
import javax.inject.Inject

class NowPlayingViewModel @Inject constructor() : ViewModel() {

  private val _nowPlayingLiveData = MutableLiveData<List<Movie>>()
  val nowPlayingLiveData: LiveData<List<Movie>>
    get() = _nowPlayingLiveData

  fun getNowPlayingMovies() {
    // TODO: 2019-12-07 call use case
  }
}
