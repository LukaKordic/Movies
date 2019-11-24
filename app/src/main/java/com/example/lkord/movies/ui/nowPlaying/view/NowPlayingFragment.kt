package com.example.lkord.movies.ui.nowPlaying.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.lkord.movies.App
import com.example.lkord.movies.R
import com.example.lkord.movies.data.db.entities.Movie
import com.example.lkord.movies.ui.moviedetails.MovieDetailsActivity
import com.example.lkord.movies.ui.nowPlaying.adapters.MovieAdapter
import com.example.lkord.movies.util.extensions.getViewModel
import com.example.lkord.movies.viewModels.NowPlayingViewModel
import kotlinx.android.synthetic.main.fragment_now_playing.*
import javax.inject.Inject

class NowPlayingFragment : Fragment() {

  @Inject
  lateinit var viewModelFactory: ViewModelProvider.Factory

  private val viewModel by lazy { getViewModel<NowPlayingViewModel>(viewModelFactory) }
  private val movieAdapter = MovieAdapter { MovieDetailsActivity.launch(activity!!, it) } // FIXME: 2019-11-23 activity!!

  companion object {
    fun getInstance() = NowPlayingFragment()
  }

  override fun onAttach(context: Context?) {
    super.onAttach(context)
    App.component.inject(this)
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
      itemAnimator = androidx.recyclerview.widget.DefaultItemAnimator()
      layoutManager = androidx.recyclerview.widget.GridLayoutManager(activity, 2)
      setHasFixedSize(true)
    }
  }

  private fun displayData(data: List<Movie>) = movieAdapter.addMovies(data)
}