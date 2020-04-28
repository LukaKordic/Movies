package com.example.lkord.movies.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lkord.movies.R
import com.example.lkord.movies.ui.favourites.view.FavouritesFragment
import com.example.lkord.movies.ui.tvshows.view.TvShowsFragment
import com.example.lkord.movies.ui.profile.ProfileFragment
import com.example.lkord.movies.ui.search.SearchFragment
import com.example.lkord.movies.ui.movies.view.MoviesFragment
import com.example.lkord.movies.util.extensions.onItemTapped
import com.example.lkord.movies.util.extensions.replace
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_home)
    initBottomNavigation()
    startMoviesFragment()
  }
  
  private fun initBottomNavigation() {
    bottomNavigation.onItemTapped {
      when (it) {
        R.id.navigationMovies -> startMoviesFragment()
        R.id.navigationTvShows -> startTvShowsFragment()
        R.id.navigationSearch -> startSearchFragment()
        R.id.navigationFavourites -> startFavouritesFragment()
        R.id.navigationProfile -> startProfileFragment()
      }
    }
  }
  
  private fun startMoviesFragment() {
    supportFragmentManager.replace(R.id.container, MoviesFragment.newInstance())
  }
  
  private fun startTvShowsFragment() {
    supportFragmentManager.replace(R.id.container, TvShowsFragment.newInstance())
  }
  
  private fun startSearchFragment() {
    supportFragmentManager.replace(R.id.container, SearchFragment.newInstance())
  }
  
  private fun startFavouritesFragment() {
    supportFragmentManager.replace(R.id.container, FavouritesFragment.newInstance())
  }
  
  private fun startProfileFragment() {
    supportFragmentManager.replace(R.id.container, ProfileFragment.newInstance())
  }
}
