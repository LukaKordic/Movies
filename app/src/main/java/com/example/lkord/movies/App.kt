package com.example.lkord.movies

import android.app.Application
import com.example.lkord.movies.di.components.AppComponent
import com.example.lkord.movies.di.components.DaggerAppComponent
import timber.log.Timber

class App : Application() {

  companion object {
    lateinit var instance: App
      private set
    lateinit var component: AppComponent
  }

  override fun onCreate() {
    super.onCreate()
    instance = this

    component = DaggerAppComponent.factory().create(this.applicationContext)
    if (BuildConfig.DEBUG)
      Timber.plant(Timber.DebugTree())
  }
}

