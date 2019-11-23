package com.example.lkord.movies.ui.popular

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lkord.movies.R
import com.example.lkord.movies.data.db.entities.Movie
import com.example.lkord.movies.ui.nowPlaying.adapters.MovieAdapter
import com.example.lkord.movies.util.extensions.getViewModel
import com.example.lkord.movies.viewModels.PopularViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_popular.*
import javax.inject.Inject

class PopularFragment : DaggerFragment() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val viewModel by lazy { getViewModel<PopularViewModel>(factory) }
    private val movieAdapter = MovieAdapter {}

    companion object {
        fun getInstance() = PopularFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_popular, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()

        viewModel.popularLiveData.observe(this, Observer { it?.run(::displayData) })
        viewModel.getPopularMovies()
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