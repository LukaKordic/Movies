package com.example.lkord.movies.di.modules

import com.example.data.common.SCHEDULERS_IO
import com.example.data.common.SCHEDULERS_MAIN
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [DatabaseModule::class, NetworkingModule::class])
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
