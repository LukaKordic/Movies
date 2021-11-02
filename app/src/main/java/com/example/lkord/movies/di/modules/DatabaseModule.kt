package com.example.lkord.movies.di.modules

import android.annotation.SuppressLint
import android.content.Context
import androidx.room.Room
import com.example.data.common.DATABASE_NAME
import com.example.data.database.LocalStorageImpl
import com.example.data.database.localstorage.LocalStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@SuppressLint("JvmStaticProvidesInObjectDetector")
//If every method is static then compiler doesn't have to generate an instance of DatabaseModule (just a small optimization)
@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {
  
  @Provides
  @Singleton
  @JvmStatic
  fun provideDatabase(@ApplicationContext applicationContext: Context): com.example.data.database.MovieDatabase {
    return Room.databaseBuilder(applicationContext, com.example.data.database.MovieDatabase::class.java, DATABASE_NAME)
      .build()
  }
  
  @Provides
  @Singleton
  @JvmStatic
  fun provideMovieDao(db: com.example.data.database.MovieDatabase) = db.movieDao()
  
  @Provides
  @Singleton
  @JvmStatic
  fun provideLocalStorage(movieDao: com.example.data.database.dao.MovieDao): LocalStorage {
    return LocalStorageImpl(movieDao)
  }
}