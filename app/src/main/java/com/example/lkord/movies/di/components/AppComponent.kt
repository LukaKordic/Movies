package com.example.lkord.movies.di.components

import com.example.lkord.movies.App
import com.example.lkord.movies.di.modules.AppModule
import com.example.lkord.movies.di.modules.builders.ActivityBuilder
import com.example.lkord.movies.di.modules.builders.FragmentBuilder
import com.example.lkord.movies.di.modules.builders.ViewModelBuilder
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [AppModule::class, AndroidSupportInjectionModule::class, ViewModelBuilder::class, ActivityBuilder::class, FragmentBuilder::class])
interface AppComponent : AndroidInjector<App> {
  
  @Component.Builder
  abstract class Builder : AndroidInjector.Builder<App>()
}
