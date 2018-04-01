package com.example.lkord.movies

import android.app.Application
import com.example.lkord.movies.di.AppComponent
import com.example.lkord.movies.di.DaggerAppComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {

    companion object {

        lateinit var instance: App
            private set

        val component: AppComponent by lazy { DaggerAppComponent.builder().build()
        }
    }
}