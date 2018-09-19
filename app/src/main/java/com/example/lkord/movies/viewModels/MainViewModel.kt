package com.example.lkord.movies.viewModels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.lkord.movies.db.entities.Movie
import com.example.lkord.movies.repositories.MovieRepository
import io.reactivex.SingleObserver
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class MainViewModel @Inject constructor(private val movieRepository: MovieRepository) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    private val movieLiveDataPrivate = MutableLiveData<List<Movie>>()

    val movieLiveData: LiveData<List<Movie>>
        get() = movieLiveDataPrivate

    fun getNowPlayingMovies() {
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}
