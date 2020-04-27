package com.example.data.common

import kotlinx.coroutines.CoroutineExceptionHandler
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class CoroutineExceptionHandler @Inject constructor() : CoroutineExceptionHandler {
  override fun handleException(context: CoroutineContext, exception: Throwable) {
    println(exception.printStackTrace())
  }
  
  override val key = CoroutineExceptionHandler.Key
}