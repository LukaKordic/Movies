package com.example.lkord.movies.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.example.lkord.movies.R
import com.example.lkord.movies.ui.nowPlaying.adapters.NowPlayingAdapter
import com.example.lkord.movies.util.extensions.getViewModel
import com.example.lkord.movies.util.extensions.onItemTapped
import com.example.lkord.movies.viewModels.MainViewModel
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by lazy { getViewModel<MainViewModel>(viewModelFactory) }
    private val nowPlayingAdapter by lazy { NowPlayingAdapter { _ -> } }//should call api to retrieve details about selected movie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        observeLiveData()
        initRecyclerView()
    }

    override fun onResume() {
        super.onResume()
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
        bottomNavigation.onItemTapped {
            when (it) {
                R.id.navigationSearch -> toggleSearchBar(searchQuery.visibility)
                R.id.navigationFavourites -> handleFavoritesClicked()
                R.id.navigationNowPlaying -> handleNowPlayingClicked()
            }
        }
    }

    private fun toggleSearchBar(isVisible: Int): Boolean {
        if (isVisible == 0) searchQuery.visibility = View.GONE //0 for visible, 8 for gone
        else searchQuery.visibility = View.VISIBLE
        return true
    }

    private fun handleFavoritesClicked() {
        searchQuery.visibility = View.GONE
    }

    private fun handleNowPlayingClicked() {
        searchQuery.visibility = View.GONE
    }
}
