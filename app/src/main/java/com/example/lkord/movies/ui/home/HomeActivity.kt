package com.example.lkord.movies.ui.home

import android.os.Bundle
import com.example.lkord.movies.R
import com.example.lkord.movies.ui.nowPlaying.view.NowPlayingFragment
import com.example.lkord.movies.ui.popular.PopularFragment
import com.example.lkord.movies.util.extensions.onItemTapped
import com.example.lkord.movies.util.extensions.replace
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class HomeActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initToolbar()
        initBottomNavigation()
        startNowPlayingFragment()
    }

    private fun initToolbar() {
        setSupportActionBar(toolbar)
        toolbarTitle.text = getString(R.string.now_playing)
    }

    private fun initBottomNavigation() {
        bottomNavigation.onItemTapped {
            when (it) {
                R.id.navigationNowPlaying -> {
                    startNowPlayingFragment()
                    toolbarTitle.text = getString(R.string.now_playing)
                }
                R.id.navigationPopular -> {
                    startPopularFragment()
                    toolbarTitle.text = getString(R.string.popular)
                }
                R.id.navigationFavourites -> {
                    startFavouritesFragment()
                    toolbarTitle.text = getString(R.string.favourites)
                }
            }
        }
    }

    private fun startNowPlayingFragment() {
        supportFragmentManager.replace(R.id.container, NowPlayingFragment.getInstance())
    }

    private fun startPopularFragment() {
        supportFragmentManager.replace(R.id.container, PopularFragment.getInstance())
    }

    private fun startFavouritesFragment() {
//        supportFragmentManager.replace(R.id.container, FavouritesFragment.getInstance())
    }
}
