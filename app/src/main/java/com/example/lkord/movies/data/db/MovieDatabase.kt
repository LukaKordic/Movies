package com.example.lkord.movies.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lkord.movies.data.db.daos.MovieDao
import com.example.lkord.movies.data.db.entities.Movie

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
}