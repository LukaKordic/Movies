package com.example.lkord.movies

import android.app.Application
import com.example.lkord.movies.di.AppComponent
import com.example.lkord.movies.di.DaggerAppComponent

class App : Application() {

    companion object {

        lateinit var instance: App

        val component: AppComponent by lazy {
            DaggerAppComponent.builder().build()
        }
    }

    override fun onCreate() {
        super.onCreate()

        instance = this
    }
}