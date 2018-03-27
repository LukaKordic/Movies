package com.example.lkord.movies.di

import com.example.lkord.movies.App
import com.example.lkord.movies.di.module.PresentationModule
import com.example.lkord.movies.presentation.SearchPresenterInterface
import dagger.Component
import javax.inject.Singleton

@Component(modules = [PresentationModule::class])
@Singleton
interface AppComponent {

    fun inject(app: App)

    fun searchPresenter(): SearchPresenterInterface
}