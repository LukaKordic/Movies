package com.example.lkord.movies.di.components

import android.content.Context
import com.example.lkord.movies.di.modules.AppModule
import com.example.lkord.movies.di.modules.DatabaseModule
import com.example.lkord.movies.di.modules.ServicesModule
import com.example.lkord.movies.di.modules.builders.ViewModelBuilder
import com.example.lkord.movies.ui.home.HomeActivity
import com.example.lkord.movies.ui.moviedetails.MovieDetailsActivity
import com.example.lkord.movies.ui.nowPlaying.view.NowPlayingFragment
import com.example.lkord.movies.ui.popular.PopularFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ViewModelBuilder::class])
interface AppComponent {

  fun inject(homeActivity: HomeActivity)

  fun inject(movieDetailsActivity: MovieDetailsActivity)

  fun inject(nowPlayingFragment: NowPlayingFragment)

  fun inject(popularFragment: PopularFragment)

  @Component.Factory
  interface Factory {
    fun create(@BindsInstance context: Context): AppComponent
  }
}
