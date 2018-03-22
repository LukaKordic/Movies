package com.example.lkord.movies

import android.app.Application
import android.arch.persistence.room.Room
import com.example.lkord.movies.common.BASE_URL
import com.example.lkord.movies.repository.db.MovieDatabase
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {

    companion object {

        lateinit var sInstance: App
            private set

        val retrofitInstance: Retrofit by lazy {
            Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }

        val movieDb by lazy {
            Room.databaseBuilder(sInstance, MovieDatabase::class.java, "MovieDatabase")
        }
    }

    override fun onCreate() {
        super.onCreate()

        sInstance = this
    }
}