package com.example.lkord.movies

import android.app.Application
import android.arch.persistence.room.Room
import com.example.lkord.movies.common.BASE_URL
import com.example.lkord.movies.database.MovieDatabase
import com.example.lkord.movies.di.AppComponent
import com.example.lkord.movies.di.DaggerAppComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {

    companion object {

        lateinit var instance: App
            private set

        val component: AppComponent by lazy { DaggerAppComponent.builder().build() }

        val retrofitInstance: Retrofit by lazy {
            Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }

        val movieDb by lazy {
            Room.databaseBuilder(instance, MovieDatabase::class.java, "MovieDatabase").fallbackToDestructiveMigration().build()
        }
    }

    override fun onCreate() {
        super.onCreate()

        instance = this
    }
}