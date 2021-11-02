package com.example.lkord.movies.ui.movies.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.domain.model.Movie
import com.example.lkord.movies.R
import com.example.lkord.movies.presentation.MoviesViewModel
import com.example.lkord.movies.ui.Data
import com.example.lkord.movies.ui.Error
import com.example.lkord.movies.ui.Loading
import com.example.lkord.movies.ui.ViewState
import com.example.lkord.movies.ui.moviedetails.startMovieDetailsActivity
import com.example.lkord.movies.ui.movies.list.MoviesAdapter
import com.example.lkord.movies.util.extensions.isVisible
import com.example.lkord.movies.util.extensions.subscribe
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_movies.*

@AndroidEntryPoint
class MoviesFragment : Fragment(R.layout.fragment_movies) {
  
  private val viewModel: MoviesViewModel by viewModels()
  private val movieAdapter = MoviesAdapter(::onListItemClicked)
  
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initRecyclerView()
    viewModel.moviesViewState.subscribe(viewLifecycleOwner, this::onViewStateChanged)
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
  
  private fun onViewStateChanged(viewState: ViewState<List<Movie>>) {
    when (viewState) {
      is Data -> handleData(viewState.data)
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
    Snackbar.make(activity?.findViewById(R.id.rootView)!!, error.message ?: "", Snackbar.LENGTH_LONG).show()
  }
  
  companion object {
    fun newInstance() = MoviesFragment()
  }
}