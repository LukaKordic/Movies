package com.example.lkord.movies.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.model.Movie
import javax.inject.Inject

class PopularViewModel @Inject constructor() : ViewModel() {

    private val _popularLiveData = MutableLiveData<List<Movie>>()
    val popularLiveData: LiveData<List<Movie>>
        get() = _popularLiveData

    fun getPopularMovies() {
      // TODO: 2019-12-07 call UseCase
    }
}