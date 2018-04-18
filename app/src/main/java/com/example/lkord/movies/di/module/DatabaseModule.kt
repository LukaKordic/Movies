package com.example.lkord.movies.di.module

import com.example.lkord.movies.presentation.FavoritesPresenter
import com.example.lkord.movies.presentation.FavoritesPresenterInterface
import com.google.firebase.database.FirebaseDatabase
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
@Singleton
class DatabaseModule {

    @Provides
    fun firebaseDatabase(): FirebaseDatabase = FirebaseDatabase.getInstance()
}
