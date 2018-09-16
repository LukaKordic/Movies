package com.example.lkord.movies.di.modules

import android.content.Context
import com.example.lkord.movies.MovieApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
@Singleton
class AppModule {

    @Provides
    fun provideApplicationContext(application: MovieApp): Context = application.applicationContext
}
