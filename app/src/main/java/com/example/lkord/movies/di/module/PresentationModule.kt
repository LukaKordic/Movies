package com.example.lkord.movies.di.module

import com.example.lkord.movies.presentation.SearchPresenter
import com.example.lkord.movies.presentation.SearchPresenterInterface
import dagger.Binds
import dagger.Module

@Module(includes = [InteractionModule::class])
abstract class PresentationModule {

    @Binds
    abstract fun searchPresenter(searchPresenter: SearchPresenter): SearchPresenterInterface
}