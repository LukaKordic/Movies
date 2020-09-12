package com.example.lkord.movies

import android.app.Application
import com.example.lkord.movies.di.components.AppComponent
import com.example.lkord.movies.di.components.DaggerAppComponent
import com.filip.babic.a11y.setup.A11yInitializer
import timber.log.Timber

class App : Application() {

  companion object {
    lateinit var instance: App
      private set
    lateinit var appComponent: AppComponent
  }

  override fun onCreate() {
    super.onCreate()
    instance = this
  
    A11yInitializer.start(this)
    appComponent = DaggerAppComponent.factory().create(this.applicationContext)
    if (BuildConfig.DEBUG)
      Timber.plant(Timber.DebugTree())
  }
}
