package com.example.lkord.movies.ui

sealed class ViewState<out T : Any>
class Data<out T : Any>(val data: T) : ViewState<T>()
class Error(val error: Throwable) : ViewState<Nothing>()
object Loading : ViewState<Nothing>()
