package com.example.lkord.movies.viewModels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.lkord.movies.data.db.entities.Movie
import com.example.lkord.movies.repositories.MovieRepository
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainViewModel @Inject constructor(private val movieRepository: MovieRepository) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    private val movieLiveDataPrivate = MutableLiveData<List<Movie>>()

    val movieLiveData: LiveData<List<Movie>>
        get() = movieLiveDataPrivate

    fun getNowPlayingMovies() {
        compositeDisposable.add(movieRepository.getNowPlayingMovies()
                .subscribe({ movieLiveDataPrivate.value = it },
                        { Throwable(it.message) }))
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}
