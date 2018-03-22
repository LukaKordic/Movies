package com.example.lkord.movies.repository.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.lkord.movies.repository.dataobjects.Movie

@Database(entities = [Movie::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}