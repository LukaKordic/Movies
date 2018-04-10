package com.example.lkord.movies.di

import com.example.lkord.movies.App
import com.example.lkord.movies.di.module.DatabaseModule
import com.example.lkord.movies.di.module.PresentationModule
import com.example.lkord.movies.presentation.DetailsPresenterInterface
import com.example.lkord.movies.presentation.SearchPresenterInterface
import com.google.firebase.database.FirebaseDatabase
import dagger.Component
import javax.inject.Singleton

@Component(modules = [PresentationModule::class, DatabaseModule::class])
@Singleton
interface AppComponent {

    fun inject(app: App)

    fun searchPresenter(): SearchPresenterInterface

    fun detailsPresenter(): DetailsPresenterInterface

    fun firebaseDatabase(): FirebaseDatabase
}
