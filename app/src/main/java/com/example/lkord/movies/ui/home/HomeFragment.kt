package com.example.lkord.movies.ui.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lkord.movies.R
import com.example.lkord.movies.dataobjects.Movie
import com.example.lkord.movies.ui.home.adapters.HomeRecyclerAdapter
import kotlinx.android.synthetic.main.home_fragment_layout.*

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.home_fragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeRecycler()
    }

    private fun initializeRecycler() {
        with(homeRecycler) {
            adapter = HomeRecyclerAdapter(ArrayList<Movie>())
            layoutManager = LinearLayoutManager(activity)
        }
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}