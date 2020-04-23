package com.example.lkord.movies.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lkord.movies.R
import com.example.lkord.movies.ui.nowPlaying.view.NowPlayingFragment
import com.example.lkord.movies.ui.popular.PopularFragment
import com.example.lkord.movies.util.extensions.onItemTapped
import com.example.lkord.movies.util.extensions.replace
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_home)
    initBottomNavigation()
    startNowPlayingFragment()
  }

  private fun initBottomNavigation() {
    bottomNavigation.onItemTapped {
      when (it) {
        R.id.navigationNowPlaying -> {
          startNowPlayingFragment()
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

  private fun startNowPlayingFragment() {
    supportFragmentManager.replace(R.id.container, NowPlayingFragment.newInstance())
  }

  private fun startPopularFragment() {
    supportFragmentManager.replace(R.id.container, PopularFragment.getInstance())
  }

  private fun startFavouritesFragment() {
//        supportFragmentManager.replace(R.id.container, FavouritesFragment.getInstance())
  }
}
