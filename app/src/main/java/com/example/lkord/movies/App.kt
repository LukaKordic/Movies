package com.example.lkord.movies

import com.example.lkord.movies.di.components.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import timber.log.Timber

class App : DaggerApplication() {
  
  lateinit var instance: App
    private set
  
  override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
    return DaggerAppComponent.builder().create(this)
  }
  
  override fun onCreate() {
    super.onCreate()
    instance = this
    
    if (BuildConfig.DEBUG)
      Timber.plant(Timber.DebugTree())
  }
}

