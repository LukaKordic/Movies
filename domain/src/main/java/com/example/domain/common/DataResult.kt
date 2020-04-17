package com.example.domain.common

sealed class DataResult<out T : Any>
class Success<out T : Any>(val data: T) : DataResult<T>()
class Failure(val error: Throwable) : DataResult<Nothing>()

inline fun <T : Any> DataResult<T>.onSuccess(block: (T) -> Unit): DataResult<T> {
  if (this is Success) block(this.data)
  return this
}

inline fun <T : Any> DataResult<T>.onFailure(block: (Throwable) -> Unit){
  if (this is Failure) block(this.error)
}