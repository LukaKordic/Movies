package com.example.lkord.movies.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.lkord.movies.dataobjects.Movie

@Database(entities = [Movie::class], version = 2)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}