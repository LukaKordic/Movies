package com.example.lkord.movies.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.example.lkord.movies.R
import com.example.lkord.movies.common.extensions.getViewModel
import com.example.lkord.movies.common.extensions.toast
import com.example.lkord.movies.ui.nowPlaying.adapters.NowPlayingAdapter
import com.example.lkord.movies.viewModels.MainViewModel
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by lazy { getViewModel<MainViewModel>(viewModelFactory) }
    private val nowPlayingAdapter by lazy { NowPlayingAdapter { _ -> } }//should call api to retrieve details about selected movie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        observeLiveData()
        initBottomNavigation()
        viewModel.getNowPlayingMovies()
    }

    private fun observeLiveData() {
        viewModel.movieLiveData.observe(this, Observer {
            it?.let { movies ->
                nowPlayingAdapter.addMovies(movies)
            }
        })
    }

    private fun initRecyclerView() {
        with(movieRecyclerView) {
            adapter = nowPlayingAdapter
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            setHasFixedSize(true)
        }
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
