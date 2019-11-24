package com.example.lkord.movies.di.modules

import com.example.lkord.movies.util.SCHEDULERS_IO
import com.example.lkord.movies.util.SCHEDULERS_MAIN
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [NetworkingModule::class, DatabaseModule::class])
class AppModule {

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
