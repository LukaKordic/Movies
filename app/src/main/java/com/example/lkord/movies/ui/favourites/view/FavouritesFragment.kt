package com.example.lkord.movies.ui.favourites.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lkord.movies.App
import com.example.lkord.movies.R
import com.example.lkord.movies.presentation.FavouritesViewModel
import com.example.lkord.movies.ui.favourites.list.FavouritesAdapter
import com.example.lkord.movies.util.extensions.getViewModel
import kotlinx.android.synthetic.main.favourites_fragment_layout.*
import javax.inject.Inject

class FavouritesFragment : Fragment() {

  @Inject
  lateinit var viewModelFactory: ViewModelProvider.Factory
  private val viewModel by lazy { getViewModel<FavouritesViewModel>(viewModelFactory) }

  override fun onAttach(context: Context) {
    super.onAttach(context)
    App.appComponent.inject(this)
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.favourites_fragment_layout, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    showFavourites()
  }

  private fun showFavourites() {
    with(favoriteMovies) {
      adapter = FavouritesAdapter()
      layoutManager = LinearLayoutManager(activity)
      itemAnimator = DefaultItemAnimator()
      setHasFixedSize(true)
    }
  }

  companion object {
    fun newInstance() = FavouritesFragment()
  }
}
