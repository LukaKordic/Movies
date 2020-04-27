package com.example.data.common

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

open class CoroutineContextProvider @Inject constructor() {
  open val io = Dispatchers.IO
  open val main: CoroutineDispatcher = Dispatchers.Main
  open val default = Dispatchers.Default
}

class TestCoroutineContextProvider : CoroutineContextProvider() {
  override val default = Dispatchers.Unconfined
  override val io = Dispatchers.Unconfined
  override val main = Dispatchers.Unconfined
}