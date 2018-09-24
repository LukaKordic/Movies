package com.example.lkord.movies.ui.nowPlaying.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lkord.movies.R
import com.example.lkord.movies.data.db.entities.Movie
import com.example.lkord.movies.ui.nowPlaying.adapters.MovieAdapter
import com.example.lkord.movies.util.extensions.getViewModel
import com.example.lkord.movies.viewModels.NowPlayingViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_now_playing.*
import javax.inject.Inject

class NowPlayingFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by lazy { getViewModel<NowPlayingViewModel>(viewModelFactory) }
    private val movieAdapter = MovieAdapter {} //pass lambda to get details about selected movie from api

    companion object {
        fun getInstance() = NowPlayingFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_now_playing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()

        viewModel.nowPlayingLiveData.observe(this, Observer { it?.run(::displayData) })

        viewModel.getNowPlayingMovies()
    }

    private fun initRecyclerView() {
        with(movieRecyclerView) {
            adapter = movieAdapter
            itemAnimator = DefaultItemAnimator()
            layoutManager = GridLayoutManager(activity, 2)
            setHasFixedSize(true)
        }
    }

    private fun displayData(data: List<Movie>) = movieAdapter.addMovies(data)
}