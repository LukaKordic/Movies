package com.example.lkord.movies.common.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
    super.onCreate(savedInstanceState, persistentState)
    injectDependencies()
    setContentView(getLayout())
    viewReady()
  }

  abstract fun injectDependencies()

  abstract fun getLayout(): Int

  abstract fun viewReady()
}