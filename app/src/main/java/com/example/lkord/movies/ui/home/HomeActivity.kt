package com.example.lkord.movies.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lkord.movies.R
import com.example.lkord.movies.ui.favourites.view.FavouritesFragment
import com.example.lkord.movies.ui.popular.view.PopularFragment
import com.example.lkord.movies.ui.topRated.view.TopRatedFragment
import com.example.lkord.movies.util.extensions.onItemTapped
import com.example.lkord.movies.util.extensions.replace
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_home)
    initBottomNavigation()
    startTopRatedFragment()
  }

  private fun initBottomNavigation() {
    bottomNavigation.onItemTapped {
      when (it) {
        R.id.navigationTopRated -> {
          startTopRatedFragment()
        }
        R.id.navigationPopular -> {
          startPopularFragment()
        }
        R.id.navigationFavourites -> {
          startFavouritesFragment()
        }
      }
    }
  }

  private fun startTopRatedFragment() {
    supportFragmentManager.replace(R.id.container, TopRatedFragment.newInstance())
  }

  private fun startPopularFragment() {
    supportFragmentManager.replace(R.id.container, PopularFragment.getInstance())
  }

  private fun startFavouritesFragment() {
    supportFragmentManager.replace(R.id.container, FavouritesFragment.newInstance())
  }
}
