package com.example.lkord.movies

import android.app.Application
import android.arch.persistence.room.Room
import com.example.lkord.movies.common.BASE_URL
import com.example.lkord.movies.db.MovieDatabase
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {

    companion object {

        lateinit var sInstance: App
            private set

        fun get() = sInstance

        val retrofitInstance: Retrofit by lazy {
            Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }

        val movieDb by lazy {
            Room.databaseBuilder(sInstance, MovieDatabase::class.java, "MovieDatabase").fallbackToDestructiveMigration().build()
        }
    }

    override fun onCreate() {
        super.onCreate()

        sInstance = this
    }
}