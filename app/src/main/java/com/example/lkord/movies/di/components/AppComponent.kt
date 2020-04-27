package com.example.lkord.movies.di.components

import android.content.Context
import com.example.lkord.movies.di.modules.AppModule
import com.example.lkord.movies.di.modules.builders.ViewModelBuilder
import com.example.lkord.movies.ui.favourites.view.FavouritesFragment
import com.example.lkord.movies.ui.home.HomeActivity
import com.example.lkord.movies.ui.moviedetails.MovieDetailsActivity
import com.example.lkord.movies.ui.popular.view.PopularFragment
import com.example.lkord.movies.ui.toprated.view.TopRatedFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ViewModelBuilder::class])
interface AppComponent {

  fun inject(homeActivity: HomeActivity)

  fun inject(movieDetailsActivity: MovieDetailsActivity)

  fun inject(topRatedFragment: TopRatedFragment)

  fun inject(popularFragment: PopularFragment)

  fun inject(favouritesFragment: FavouritesFragment)

  @Component.Factory
  interface Factory {
    fun create(@BindsInstance context: Context): AppComponent
  }
}
