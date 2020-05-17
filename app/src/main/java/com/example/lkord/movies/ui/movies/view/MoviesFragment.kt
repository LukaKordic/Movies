package com.example.lkord.movies.ui.movies.view

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.domain.model.Movie
import com.example.lkord.movies.App
import com.example.lkord.movies.R
import com.example.lkord.movies.ui.moviedetails.startMovieDetailsActivity
import com.example.lkord.movies.ui.movies.list.MoviesAdapter
import com.example.lkord.movies.util.extensions.isVisible
import com.example.lkord.movies.util.extensions.subscribe
import com.example.lkord.movies.util.extensions.viewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_movies.*

class MoviesFragment : Fragment(R.layout.fragment_movies) {
  
  private val viewModel by viewModel { App.appComponent.moviesViewModel }
  private val movieAdapter = MoviesAdapter(::onListItemClicked)
  
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initRecyclerView()
    viewModel.nowPlayingViewState.subscribe(viewLifecycleOwner, this::onViewStateChanged)
  }
  
  private fun initRecyclerView() {
    with(movieRecyclerView) {
      adapter = movieAdapter
      itemAnimator = androidx.recyclerview.widget.DefaultItemAnimator()
      layoutManager = androidx.recyclerview.widget.GridLayoutManager(activity, 2)
      setHasFixedSize(true)
    }
  }
  
  private fun onListItemClicked(movie: Movie) {
    activity?.let { context ->
      startMovieDetailsActivity(context, movie)
    }
  }
  
  private fun onViewStateChanged(viewState: MovieListViewState) {
    when (viewState) {
      is Data -> handleData(viewState.movies)
      is Error -> showError(viewState.error)
      Loading -> showLoading()
    }
  }
  
  private fun handleData(movies: List<Movie>) {
    hideLoading()
    movieAdapter.addMovies(movies)
  }
  
  private fun showLoading() {
    loadingIndicator.isVisible = true
  }
  
  private fun hideLoading() {
    loadingIndicator.isVisible = false
  }
  
  private fun showError(error: Throwable) {
    hideLoading()
    Snackbar.make(activity?.findViewById(R.id.rootView)!!, error.message ?: "", Snackbar.LENGTH_LONG)
  }
  
  companion object {
    fun newInstance() = MoviesFragment()
  }
}