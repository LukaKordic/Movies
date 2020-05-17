package com.example.lkord.movies.ui.favourites.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lkord.movies.App
import com.example.lkord.movies.R
import com.example.lkord.movies.ui.favourites.list.FavouritesAdapter
import com.example.lkord.movies.util.extensions.viewModel
import kotlinx.android.synthetic.main.favourites_fragment_layout.*

class FavouritesFragment : Fragment() {
  
  private val viewModel by viewModel { App.appComponent.favouritesViewModel }
  
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
