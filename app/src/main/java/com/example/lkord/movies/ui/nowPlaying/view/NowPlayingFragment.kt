package com.example.lkord.movies.ui.nowPlaying.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.domain.model.Movie
import com.example.lkord.movies.App
import com.example.lkord.movies.R
import com.example.lkord.movies.ui.moviedetails.startMovieDetailsActivity
import com.example.lkord.movies.ui.nowPlaying.adapters.MovieAdapter
import com.example.lkord.movies.util.extensions.getViewModel
import com.example.lkord.movies.viewModels.NowPlayingViewModel
import kotlinx.android.synthetic.main.fragment_now_playing.*
import java.util.*
import javax.inject.Inject

class NowPlayingFragment : Fragment() {

  @Inject
  lateinit var viewModelFactory: ViewModelProvider.Factory

  private val viewModel by lazy { getViewModel<NowPlayingViewModel>(viewModelFactory) }
  private val movieAdapter = MovieAdapter(::onListItemClicked)

  override fun onAttach(context: Context) {
    super.onAttach(context)
    App.appComponent.inject(this)
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
    return inflater.inflate(R.layout.fragment_now_playing, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initRecyclerView()
    viewModel.getNowPlayingMovies()
    viewModel.nowPlayingLiveData.observe(this, Observer { it?.run(::onDataChange) })
    TimeZone.getAvailableIDs().forEach { println(it) }
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

  private fun onDataChange(data: List<Movie>) = movieAdapter.addMovies(data)

  companion object {
    fun newInstance() = NowPlayingFragment()
  }
}