package com.example.lkord.movies.viewModels

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.lkord.movies.common.UNKNOWN_VIEWMODEL_CLASS
import com.example.lkord.movies.repositories.MovieRepository

class MainViewModelFactory(private val movieRepository: MovieRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(movieRepository) as T
        }
        throw IllegalArgumentException(UNKNOWN_VIEWMODEL_CLASS)
    }
}
