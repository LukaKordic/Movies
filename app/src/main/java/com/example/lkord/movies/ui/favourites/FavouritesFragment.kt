//package com.example.lkord.movies.ui.favourites
//
//import android.os.Bundle
//import android.support.v4.app.Fragment
//import android.support.v7.widget.DefaultItemAnimator
//import android.support.v7.widget.LinearLayoutManager
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import com.example.lkord.movies.R
//import com.example.lkord.movies.favoritesPresenter
//import com.example.lkord.movies.ui.favourites.adapters.FavouritesAdapter
//import kotlinx.android.synthetic.main.favourites_fragment_layout.*
//
//class FavouritesFragment : Fragment() {
//
//
//    companion object {
//        fun newInstance() = FavouritesFragment()
//    }
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        return inflater.inflate(R.layout.favourites_fragment_layout, container, false)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        initUI()
//        favoritesPresenter.getFavoriteMovies()
//    }
//
//    private fun initUI() {
//        with(favoriteMovies) {
//            adapter = FavouritesAdapter()
//            layoutManager = LinearLayoutManager(activity)
//            itemAnimator = DefaultItemAnimator()
//            setHasFixedSize(true)
//        }
//    }
//}
