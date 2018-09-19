package com.example.lkord.movies.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.lkord.movies.db.daos.MovieDao
import com.example.lkord.movies.db.entities.Movie

@Database(entities = [Movie::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
}