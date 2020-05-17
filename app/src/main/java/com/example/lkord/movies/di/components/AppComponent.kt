package com.example.lkord.movies.di.components

import android.content.Context
import com.example.lkord.movies.di.modules.InteractionModule
import com.example.lkord.movies.presentation.FavouritesViewModel
import com.example.lkord.movies.presentation.MoviesViewModel
import com.example.lkord.movies.presentation.TvShowsViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [InteractionModule::class])
interface AppComponent {
  
  val moviesViewModel: MoviesViewModel
  val tvShowsViewModel: TvShowsViewModel
  val favouritesViewModel: FavouritesViewModel
  
  @Component.Factory
  interface Factory {
    fun create(@BindsInstance context: Context): AppComponent
  }
}
