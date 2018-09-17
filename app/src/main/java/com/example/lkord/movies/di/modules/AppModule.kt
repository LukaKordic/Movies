package com.example.lkord.movies.di.modules

import android.content.Context
import com.example.lkord.movies.MovieApp
import com.example.lkord.movies.common.SCHEDULERS_IO
import com.example.lkord.movies.common.SCHEDULERS_MAIN
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named
import javax.inject.Singleton

@Module
@Singleton
class AppModule {

    @Provides
    fun provideApplicationContext(application: MovieApp): Context = application.applicationContext

    @Singleton
    @Provides
    @Named(SCHEDULERS_IO)
    fun provideIOScheduler(): Scheduler {
        return Schedulers.io()
    }

    @Singleton
    @Provides
    @Named(SCHEDULERS_MAIN)
    fun provideMainScheduler(): Scheduler {
        return AndroidSchedulers.mainThread()
    }
}
