package com.example.lkord.movies.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lkord.movies.data.db.entities.Movie
import com.example.lkord.movies.repositories.MovieRepository
import com.example.lkord.movies.util.NOW_PLAYING_TYPE
import com.example.lkord.movies.util.POPULAR_TYPE
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class NowPlayingViewModel @Inject constructor(private val movieRepository: MovieRepository) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    private val _nowPlayingLiveData = MutableLiveData<List<Movie>>()

    val nowPlayingLiveData: LiveData<List<Movie>>
        get() = _nowPlayingLiveData

    fun getNowPlayingMovies() {
        compositeDisposable.add(movieRepository.fetchAndSaveNowPlayingMovies(NOW_PLAYING_TYPE)
                .subscribe({ _nowPlayingLiveData.value = it },
                        { Throwable(it.message) }))
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}
