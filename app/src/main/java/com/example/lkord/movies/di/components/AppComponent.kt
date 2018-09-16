package com.example.lkord.movies.di.components

import com.example.lkord.movies.MovieApp
import com.example.lkord.movies.di.modules.AppModule
import com.example.lkord.movies.di.modules.ViewModelBuilder
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(modules = [AppModule::class, AndroidSupportInjectionModule::class, ViewModelBuilder::class])
interface AppComponent : AndroidInjector<MovieApp> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<MovieApp>()
}
