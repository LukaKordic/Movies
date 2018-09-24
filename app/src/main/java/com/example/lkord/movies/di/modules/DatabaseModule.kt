package com.example.lkord.movies.di.modules

import android.arch.persistence.room.Room
import android.content.Context
import com.example.lkord.movies.util.DATABASE_NAME
import com.example.lkord.movies.data.LocalStorage
import com.example.lkord.movies.data.LocalStorageImpl
import com.example.lkord.movies.data.db.MovieDatabase
import com.example.lkord.movies.data.db.daos.MovieDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(applicationContext: Context): MovieDatabase {
        return Room.databaseBuilder(applicationContext, MovieDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
    }

    @Provides
    @Singleton
    fun provideMovieDao(db: MovieDatabase): MovieDao = db.movieDao()

    @Provides
    @Singleton
    fun provideLocalStorage(movieDao: MovieDao): LocalStorage {
        return LocalStorageImpl(movieDao)
    }
}