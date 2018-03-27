package com.example.lkord.movies.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.lkord.movies.model.data.Movie

@Database(entities = [Movie::class], version = 2)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}