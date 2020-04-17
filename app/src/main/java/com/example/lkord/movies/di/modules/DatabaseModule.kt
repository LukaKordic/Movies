package com.example.lkord.movies.di.modules

import android.content.Context
import androidx.room.Room
import com.example.data.common.DATABASE_NAME
import com.example.domain.localstorage.LocalStorage
import com.example.data.database.LocalStorageImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

  @Provides
  @Singleton
  fun provideDatabase(applicationContext: Context): com.example.data.database.MovieDatabase {
    return Room.databaseBuilder(applicationContext, com.example.data.database.MovieDatabase::class.java, DATABASE_NAME)
        .build()
  }

  @Provides
  @Singleton
  fun provideMovieDao(db: com.example.data.database.MovieDatabase): com.example.data.database.dao.MovieDao = db.movieDao()

  @Provides
  @Singleton
  fun provideLocalStorage(movieDao: com.example.data.database.dao.MovieDao): LocalStorage {
    return LocalStorageImpl(movieDao)
  }
}