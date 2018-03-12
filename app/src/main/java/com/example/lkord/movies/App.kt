package com.example.lkord.movies

import android.app.Application
import com.example.lkord.movies.common.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {

    companion object {
        private lateinit var sInstance: App
        fun get() = sInstance
        fun getRetrofitInstance() = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    override fun onCreate() {
        super.onCreate()

        sInstance = this
    }
}