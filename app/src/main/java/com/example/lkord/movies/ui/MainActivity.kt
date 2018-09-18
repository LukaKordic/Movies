package com.example.lkord.movies.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View
import com.example.lkord.movies.R
import com.example.lkord.movies.viewModels.MainViewModel
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by lazy { ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        observeLiveData()
        initBottomNavigation()
        viewModel.getNowPlayingMovies()
    }

    private fun observeLiveData() {
        viewModel.movieLiveData.observe(this, Observer {
            Timber.e("retrieving now playing")
        })
    }

    private fun initBottomNavigation() {
        bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigationSearch -> {
                    searchQuery.visibility = View.VISIBLE
                    true
                }
                else -> {
                    searchQuery.visibility = View.GONE
                    true
                }
            }
        }
    }
}
