package com.example.domain.common

sealed class NetworkResult<out T : Any>
class Success<out T : Any>(val data: T) : NetworkResult<T>()
class Failure(val error: Throwable) : NetworkResult<Nothing>()

inline fun <T : Any> NetworkResult<T>.onSuccess(block: (T) -> Unit) {
  if (this is Success) block(this.data)
}

inline fun NetworkResult<Nothing>.onFailure(block: (Throwable) -> Unit) {
  if (this is Failure) block(this.error)
}