package com.example.lkord.movies.ui.tvshows.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.domain.model.Movie
import com.example.lkord.movies.App
import com.example.lkord.movies.R
import com.example.lkord.movies.ui.movies.list.MoviesAdapter
import com.example.lkord.movies.ui.movies.view.Data
import com.example.lkord.movies.ui.movies.view.Error
import com.example.lkord.movies.ui.movies.view.Loading
import com.example.lkord.movies.ui.movies.view.MovieListViewState
import com.example.lkord.movies.util.extensions.isVisible
import com.example.lkord.movies.util.extensions.subscribe
import com.example.lkord.movies.util.extensions.viewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_shows.*

class TvShowsFragment : Fragment(R.layout.fragment_shows) {
  
  private val viewModel by viewModel { App.appComponent.tvShowsViewModel }
  private val movieAdapter = MoviesAdapter {}
  
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    
    initRecyclerView()
    viewModel.popularViewState.subscribe(viewLifecycleOwner, this::onViewStateChanged)
  }
  
  private fun initRecyclerView() {
    with(movieRecyclerView) {
      adapter = movieAdapter
      itemAnimator = androidx.recyclerview.widget.DefaultItemAnimator()
      layoutManager = androidx.recyclerview.widget.GridLayoutManager(activity, 2)
      setHasFixedSize(true)
    }
  }
  
  private fun onViewStateChanged(viewState: MovieListViewState) {
    when (viewState) {
      is Data -> handleData(viewState.movies)
      is Error -> showError(viewState.error)
      Loading -> showLoading()
    }
  }
  
  private fun showLoading() {
    loadingIndicator.isVisible = true
  }
  
  private fun hideLoading() {
    loadingIndicator.isVisible = false
  }
  
  private fun handleData(movies: List<Movie>) {
    hideLoading()
    movieAdapter.addMovies(movies)
  }
  
  private fun showError(error: Throwable) {
    hideLoading()
    Snackbar.make(activity?.findViewById(R.id.rootView)!!, error.message ?: "", Snackbar.LENGTH_LONG)
  }
  
  companion object {
    fun newInstance() = TvShowsFragment()
  }
}