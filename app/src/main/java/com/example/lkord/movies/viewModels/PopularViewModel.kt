package com.example.lkord.movies.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.data.common.POPULAR_TYPE
import com.example.domain.model.Movie
import com.example.data.repositories.MovieRepository
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class PopularViewModel @Inject constructor(private val movieRepository: MovieRepository) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    private val _popularLiveData = MutableLiveData<List<Movie>>()

    val popularLiveData: LiveData<List<Movie>>
        get() = _popularLiveData

    fun getPopularMovies() {
        compositeDisposable.add(
                movieRepository.fetchAndSavePopularMovies(POPULAR_TYPE).subscribe({
                    _popularLiveData.value = it
                }, { Throwable(it.message) })
        )
    }
}